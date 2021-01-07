package com.wms.service;

import com.wms.model.entity.InRequirementEntity;
import com.xac.core.service.BaseService;
import com.wms.api.requirements.InRequirementQueryParam;
import com.wms.model.bo.requirements.InRequirementBo;
import com.xac.core.api.Paging;

import java.io.Serializable;

/**
 * <pre>
 * 入库需求表 服务类
 * </pre>
 *
 * @author puck
 * @since 2020-12-23
 */
public interface InRequirementService extends BaseService<InRequirementEntity> {

    /**
     * 保存
     *
     * @param inRequirement
     * @return
     * @throws Exception
     */
    boolean saveInRequirement(InRequirementBo inRequirement) throws Exception;

    /**
     * 修改
     *
     * @param inRequirement
     * @return
     * @throws Exception
     */
    boolean updateInRequirement(InRequirementBo inRequirement);

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteInRequirement(Long id);

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    InRequirementBo getInRequirementById(Serializable id);

    /**
     * 根据原始单据ID查询需求单据
     * @param originalOrderID
     * @return
     */
    InRequirementBo queryInRequirementByOriginalID(String originalOrderID) throws Exception;

    /**
     * 获取分页对象
     *
     * @param inRequirementQueryParam
     * @return
     * @throws Exception
     */
    Paging<InRequirementBo> getInRequirementPageList(InRequirementQueryParam inRequirementQueryParam);

    /**
     * 根据原始单据ID获取需求ID，用于判断是否被重复处理
     * @param originalID
     * @return
     */
    String queryRequirementIDByOriginalID(String originalID);

}
