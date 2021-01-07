package com.wms.mapper.requirements;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wms.model.entity.OutRequirementEntity;
import com.wms.api.requirements.OutRequirementQueryParam;
import com.wms.model.bo.requirements.OutRequirementBo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 出库需求表 Mapper 接口
 * </pre>
 *
 * @author puck
 * @since 2020-12-23
 */
@Repository
public interface OutRequirementMapper extends BaseMapper<OutRequirementEntity> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    OutRequirementBo getOutRequirementById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param outRequirementQueryParam
     * @return
     */
    IPage<OutRequirementBo> getOutRequirementPageList(@Param("page") Page page, @Param("param") OutRequirementQueryParam outRequirementQueryParam);

}
