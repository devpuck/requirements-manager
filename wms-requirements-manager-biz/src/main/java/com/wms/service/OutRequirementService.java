package com.wms.service;

import com.wms.model.entity.OutRequirementEntity;
import com.xac.core.service.BaseService;
import com.wms.api.requirements.OutRequirementQueryParam;
import com.wms.model.bo.requirements.OutRequirementBo;
import com.xac.core.api.Paging;

import java.io.Serializable;

/**
 * <pre>
 * 出库需求表 服务类
 * </pre>
 *
 * @author puck
 * @since 2020-12-23
 */
public interface OutRequirementService extends BaseService<OutRequirementEntity> {

    /**
     * 保存
     *
     * @param outRequirement
     * @return
     * @throws Exception
     */
    boolean saveOutRequirement(OutRequirementBo outRequirement);

    /**
     * 修改
     *
     * @param outRequirement
     * @return
     * @throws Exception
     */
    boolean updateOutRequirement(OutRequirementBo outRequirement);

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteOutRequirement(Long id);

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    OutRequirementBo getOutRequirementById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param outRequirementQueryParam
     * @return
     * @throws Exception
     */
    Paging<OutRequirementBo> getOutRequirementPageList(OutRequirementQueryParam outRequirementQueryParam);

}
