package com.wms.service.impl;

import com.xac.core.constant.CoreConstant;
import com.wms.model.entity.OutRequirementEntity;
import com.wms.mapper.requirements.OutRequirementMapper;
import com.wms.service.OutRequirementService;
import com.wms.api.requirements.OutRequirementQueryParam;
import com.wms.model.bo.requirements.OutRequirementBo;
import com.xac.core.service.impl.BaseServiceImpl;
import com.xac.core.api.Paging;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.io.Serializable;


/**
 * <pre>
 * 出库需求表 服务实现类
 * </pre>
 *
 * @author puck
 * @since 2020-12-23
 */
@Slf4j
@Service
public class OutRequirementServiceImpl extends BaseServiceImpl<OutRequirementMapper, OutRequirementEntity> implements OutRequirementService {

    @Autowired
    private OutRequirementMapper outRequirementMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveOutRequirement(OutRequirementBo outRequirement) {
        OutRequirementEntity entity = new OutRequirementEntity();
        BeanUtils.copyProperties(outRequirement , entity);
        return super.save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateOutRequirement(OutRequirementBo outRequirement) {
        OutRequirementEntity entity = new OutRequirementEntity();
        BeanUtils.copyProperties(outRequirement , entity);
        return super.updateById(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteOutRequirement(Long id) {
        return super.removeById(id);
    }

    @Override
    public OutRequirementBo getOutRequirementById(Serializable id) {
        return outRequirementMapper.getOutRequirementById(id);
    }

    @Override
    public Paging<OutRequirementBo> getOutRequirementPageList(OutRequirementQueryParam outRequirementQueryParam) {
        Page page = setPageParam(outRequirementQueryParam, OrderItem.desc(CoreConstant.CREATED_DATE));
        IPage<OutRequirementBo> iPage = outRequirementMapper.getOutRequirementPageList(page, outRequirementQueryParam);
        return new Paging(iPage);
    }

}
