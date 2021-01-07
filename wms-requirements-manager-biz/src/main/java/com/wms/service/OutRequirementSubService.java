package com.wms.service;

import com.wms.model.entity.OutRequirementSubEntity;
import com.xac.core.service.BaseService;
import com.wms.api.requirements.OutRequirementSubQueryParam;
import com.wms.model.bo.requirements.OutRequirementSubBo;
import com.xac.core.api.Paging;

import java.io.Serializable;

/**
 * <pre>
 * 出库需求子表 服务类
 * </pre>
 *
 * @author puck
 * @since 2020-12-24
 */
public interface OutRequirementSubService extends BaseService<OutRequirementSubEntity> {

    /**
     * 保存
     *
     * @param outRequirementSub
     * @return
     * @throws Exception
     */
    boolean saveOutRequirementSub(OutRequirementSubBo outRequirementSub);

    /**
     * 修改
     *
     * @param outRequirementSub
     * @return
     * @throws Exception
     */
    boolean updateOutRequirementSub(OutRequirementSubBo outRequirementSub);

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteOutRequirementSub(Long id);

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    OutRequirementSubBo getOutRequirementSubById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param outRequirementSubQueryParam
     * @return
     * @throws Exception
     */
    Paging<OutRequirementSubBo> getOutRequirementSubPageList(OutRequirementSubQueryParam outRequirementSubQueryParam);

}
