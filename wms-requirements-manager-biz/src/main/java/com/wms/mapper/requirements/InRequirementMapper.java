package com.wms.mapper.requirements;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wms.model.entity.InRequirementEntity;
import com.wms.api.requirements.InRequirementQueryParam;
import com.wms.model.bo.requirements.InRequirementBo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 入库需求表 Mapper 接口
 * </pre>
 *
 * @author puck
 * @since 2020-12-23
 */
@Repository
public interface InRequirementMapper extends BaseMapper<InRequirementEntity> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    InRequirementBo getInRequirementById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param inRequirementQueryParam
     * @return
     */
    IPage<InRequirementBo> getInRequirementPageList(@Param("page") Page page, @Param("param") InRequirementQueryParam inRequirementQueryParam);

    String queryRequirementIDByOriginalID(String originalID);

}
