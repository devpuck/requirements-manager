package com.wms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wms.api.instorage.InWarehouseBillSubVo;
import com.wms.api.instorage.InWarehouseBillVo;
import com.wms.errorcode.ErrorCode;
import com.wms.mapper.requirements.InRequirementSubMapper;
import com.wms.model.bo.requirements.InRequirementSubBo;
import com.wms.model.entity.InRequirementSubEntity;
import com.wms.sdk.instorage.InWarehouseManager;
import com.wms.service.InRequirementSubService;
import com.wms.tools.RequirementTools;
import com.xac.core.api.ApiResultCode;
import com.xac.core.constant.CoreConstant;
import com.wms.model.entity.InRequirementEntity;
import com.wms.mapper.requirements.InRequirementMapper;
import com.wms.service.InRequirementService;
import com.wms.api.requirements.InRequirementQueryParam;
import com.wms.model.bo.requirements.InRequirementBo;
import com.xac.core.service.impl.BaseServiceImpl;
import com.xac.core.api.Paging;
import com.xac.core.util.BeanListUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;


/**
 * <pre>
 * 入库需求表 服务实现类
 * </pre>
 *
 * @author puck
 * @since 2020-12-23
 */
@Slf4j
@Service
public class InRequirementServiceImpl extends BaseServiceImpl<InRequirementMapper, InRequirementEntity> implements InRequirementService {

    @Autowired
    private InRequirementMapper inRequirementMapper;
    @Autowired
    private InRequirementSubService inRequirementSubService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveInRequirement(InRequirementBo inRequirement) throws Exception
    {

        generateRequirementCode(inRequirement);

        InRequirementEntity entity = new InRequirementEntity();
        BeanUtils.copyProperties(inRequirement , entity);
        boolean result = super.save(entity);
        if(!result)
        {
            return result;
        }

        List<InRequirementSubBo> subBoList = inRequirement.getInRequirementSubBoList();
        if(null != subBoList)
        {
            List<InRequirementSubEntity> entityList = BeanListUtil.copyListProperties(subBoList,InRequirementSubEntity.class);
            InRequirementSubServiceImpl inRequirementServiceSub = new InRequirementSubServiceImpl();
            result = inRequirementServiceSub.saveBatch(entityList);
        }

        InRequirementBo queryInRequireBo = queryInRequirementByOriginalID(inRequirement.getOriginalOrderId());
        int code = createInWarehouseBill(queryInRequireBo);
        if(ErrorCode.OUT_OK == code)
        {
            result = true;
        }
        return result;
    }

    /**
     * 自动生成需求编号
     * @param inRequirement
     */
    public void generateRequirementCode(InRequirementBo inRequirement)
    {
        String requirementCode = UUID.randomUUID().toString().replaceAll("-", "");
        inRequirement.setRequirementCode(requirementCode);
        Iterator<InRequirementSubBo> it = inRequirement.getInRequirementSubBoList().iterator();
        while(it.hasNext())
        {
            InRequirementSubBo inRequirementSubBo = it.next();
            inRequirementSubBo.setRequirementCode(requirementCode);

        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateInRequirement(InRequirementBo inRequirement)
    {
        InRequirementEntity entity = new InRequirementEntity();
        BeanUtils.copyProperties(inRequirement , entity);
        return super.updateById(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteInRequirement(Long id)
    {
        return super.removeById(id);
    }

    @Override
    public InRequirementBo getInRequirementById(Serializable id)
    {
        return inRequirementMapper.getInRequirementById(id);
    }

    @Override
    public InRequirementBo queryInRequirementByOriginalID(String originalOrderID)  throws Exception
    {
        InRequirementEntity inRequirementEntity = inRequirementMapper.selectOne(new QueryWrapper<InRequirementEntity>().lambda()
                .eq(InRequirementEntity::getOriginalOrderId,originalOrderID));
        if(null != inRequirementEntity)
        {
            InRequirementBo inRequirementBo = new InRequirementBo();
            BeanUtils.copyProperties(inRequirementEntity,inRequirementBo);

            List<InRequirementSubBo> inRequirementSubBoList = inRequirementSubService.queryInRequirementSubByRequirementCode(inRequirementBo.getRequirementCode());
            inRequirementBo.setInRequirementSubBoList(inRequirementSubBoList);

            return inRequirementBo;
        }
        return null;
    }

    @Override
    public Paging<InRequirementBo> getInRequirementPageList(InRequirementQueryParam inRequirementQueryParam) {
        Page page = setPageParam(inRequirementQueryParam, OrderItem.desc(CoreConstant.CREATED_DATE));
        IPage<InRequirementBo> iPage = inRequirementMapper.getInRequirementPageList(page, inRequirementQueryParam);
        return new Paging(iPage);
    }

    @Override
    public String queryRequirementIDByOriginalID(String originalID)
    {
        return inRequirementMapper.queryRequirementIDByOriginalID(originalID);
    }

    public int createInWarehouseBill(InRequirementBo inRequirementBo)
    {
        int code = ErrorCode.ERROR;
        InWarehouseBillVo inWarehouseBillVo = RequirementTools.generateInWarehouseBill(inRequirementBo);
        if(null != inWarehouseBillVo)
        {
            InWarehouseManager inWarehouseManager = new InWarehouseManager();
            code = inWarehouseManager.createInWarehouseBill(inWarehouseBillVo);

        }
        return code;
    }

}
