package com.wms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wms.model.entity.InRequirementEntity;
import com.xac.core.constant.CoreConstant;
import com.wms.model.entity.InRequirementSubEntity;
import com.wms.mapper.requirements.InRequirementSubMapper;
import com.wms.service.InRequirementSubService;
import com.wms.api.requirements.InRequirementSubQueryParam;
import com.wms.model.bo.requirements.InRequirementSubBo;
import com.xac.core.service.impl.BaseServiceImpl;
import com.xac.core.api.Paging;
import com.xac.core.util.BeanListUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * <pre>
 * 入库需求子表 服务实现类
 * </pre>
 *
 * @author puck
 * @since 2020-12-23
 */
@Slf4j
@Service
public class InRequirementSubServiceImpl extends BaseServiceImpl<InRequirementSubMapper, InRequirementSubEntity> implements InRequirementSubService {

    @Autowired
    private InRequirementSubMapper inRequirementSubMapper;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveInRequirementSub(InRequirementSubBo inRequirementSub) {
        InRequirementSubEntity entity = new InRequirementSubEntity();
        BeanUtils.copyProperties(inRequirementSub , entity);
        return super.save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateInRequirementSub(InRequirementSubBo inRequirementSub) {
        InRequirementSubEntity entity = new InRequirementSubEntity();
        BeanUtils.copyProperties(inRequirementSub , entity);
        return super.updateById(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteInRequirementSub(Long id) {
        return super.removeById(id);
    }

    @Override
    public InRequirementSubBo getInRequirementSubById(Serializable id) {
        return inRequirementSubMapper.getInRequirementSubById(id);
    }

    @Override
    public Paging<InRequirementSubBo> getInRequirementSubPageList(InRequirementSubQueryParam inRequirementSubQueryParam) {
        Page page = setPageParam(inRequirementSubQueryParam, OrderItem.desc(CoreConstant.CREATED_DATE));
        IPage<InRequirementSubBo> iPage = inRequirementSubMapper.getInRequirementSubPageList(page, inRequirementSubQueryParam);
        return new Paging(iPage);
    }

    @Override
    public List<InRequirementSubBo> queryInRequirementSubByRequirementCode(String requirementCode)  throws Exception
    {
        System.out.println("REQUIREMENTCODE:"+requirementCode);
        if(null == inRequirementSubMapper)
        {
            System.out.println("XXXXXXXXXXXXXXXXXXXXX");
        }
        List<InRequirementSubEntity> entityList = inRequirementSubMapper.selectList(new QueryWrapper<InRequirementSubEntity>().lambda()
                .eq(InRequirementSubEntity::getRequirementCode,requirementCode));
        if(null == entityList)
        {
            entityList = new ArrayList<InRequirementSubEntity>();
        }
        return BeanListUtil.copyListProperties(entityList,InRequirementSubBo.class);
    }

}
