package com.wms.mapper.requirements;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wms.model.entity.OutRequirementSubEntity;
import com.wms.api.requirements.OutRequirementSubQueryParam;
import com.wms.model.bo.requirements.OutRequirementSubBo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 出库需求子表 Mapper 接口
 * </pre>
 *
 * @author puck
 * @since 2020-12-24
 */
@Repository
public interface OutRequirementSubMapper extends BaseMapper<OutRequirementSubEntity> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    OutRequirementSubBo getOutRequirementSubById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param outRequirementSubQueryParam
     * @return
     */
    IPage<OutRequirementSubBo> getOutRequirementSubPageList(@Param("page") Page page, @Param("param") OutRequirementSubQueryParam outRequirementSubQueryParam);

}
