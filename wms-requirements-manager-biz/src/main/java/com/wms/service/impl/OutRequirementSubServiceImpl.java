package com.wms.service.impl;

import com.xac.core.constant.CoreConstant;
import com.wms.model.entity.OutRequirementSubEntity;
import com.wms.mapper.requirements.OutRequirementSubMapper;
import com.wms.service.OutRequirementSubService;
import com.wms.api.requirements.OutRequirementSubQueryParam;
import com.wms.model.bo.requirements.OutRequirementSubBo;
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
 * 出库需求子表 服务实现类
 * </pre>
 *
 * @author puck
 * @since 2020-12-24
 */
@Slf4j
@Service
public class OutRequirementSubServiceImpl extends BaseServiceImpl<OutRequirementSubMapper, OutRequirementSubEntity> implements OutRequirementSubService {

    @Autowired
    private OutRequirementSubMapper outRequirementSubMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveOutRequirementSub(OutRequirementSubBo outRequirementSub) {
        OutRequirementSubEntity entity = new OutRequirementSubEntity();
        BeanUtils.copyProperties(outRequirementSub , entity);
        return super.save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateOutRequirementSub(OutRequirementSubBo outRequirementSub) {
        OutRequirementSubEntity entity = new OutRequirementSubEntity();
        BeanUtils.copyProperties(outRequirementSub , entity);
        return super.updateById(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteOutRequirementSub(Long id) {
        return super.removeById(id);
    }

    @Override
    public OutRequirementSubBo getOutRequirementSubById(Serializable id) {
        return outRequirementSubMapper.getOutRequirementSubById(id);
    }

    @Override
    public Paging<OutRequirementSubBo> getOutRequirementSubPageList(OutRequirementSubQueryParam outRequirementSubQueryParam) {
        Page page = setPageParam(outRequirementSubQueryParam, OrderItem.desc(CoreConstant.CREATED_DATE));
        IPage<OutRequirementSubBo> iPage = outRequirementSubMapper.getOutRequirementSubPageList(page, outRequirementSubQueryParam);
        return new Paging(iPage);
    }

}
