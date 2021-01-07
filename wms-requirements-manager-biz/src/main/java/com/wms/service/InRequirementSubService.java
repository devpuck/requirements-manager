package com.wms.service;

import com.wms.model.entity.InRequirementSubEntity;
import com.xac.core.service.BaseService;
import com.wms.api.requirements.InRequirementSubQueryParam;
import com.wms.model.bo.requirements.InRequirementSubBo;
import com.xac.core.api.Paging;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * 入库需求子表 服务类
 * </pre>
 *
 * @author puck
 * @since 2020-12-23
 */
public interface InRequirementSubService extends BaseService<InRequirementSubEntity> {

    /**
     * 保存
     *
     * @param inRequirementSub
     * @return
     * @throws Exception
     */
    boolean saveInRequirementSub(InRequirementSubBo inRequirementSub);

    /**
     * 修改
     *
     * @param inRequirementSub
     * @return
     * @throws Exception
     */
    boolean updateInRequirementSub(InRequirementSubBo inRequirementSub);

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteInRequirementSub(Long id);

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    InRequirementSubBo getInRequirementSubById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param inRequirementSubQueryParam
     * @return
     * @throws Exception
     */
    Paging<InRequirementSubBo> getInRequirementSubPageList(InRequirementSubQueryParam inRequirementSubQueryParam);

    /**
     * 根据需求编号查询需求子单列表
     * @param requirementCode
     * @return
     */
    List<InRequirementSubBo> queryInRequirementSubByRequirementCode(String requirementCode) throws Exception;

}
