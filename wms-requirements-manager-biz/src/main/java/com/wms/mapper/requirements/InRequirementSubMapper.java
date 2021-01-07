package com.wms.mapper.requirements;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wms.model.entity.InRequirementSubEntity;
import com.wms.api.requirements.InRequirementSubQueryParam;
import com.wms.model.bo.requirements.InRequirementSubBo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 入库需求子表 Mapper 接口
 * </pre>
 *
 * @author puck
 * @since 2020-12-24
 */
@Repository
public interface InRequirementSubMapper extends BaseMapper<InRequirementSubEntity> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    InRequirementSubBo getInRequirementSubById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param inRequirementSubQueryParam
     * @return
     */
    IPage<InRequirementSubBo> getInRequirementSubPageList(@Param("page") Page page, @Param("param") InRequirementSubQueryParam inRequirementSubQueryParam);

}
