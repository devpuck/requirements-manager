package com.wms.model.bo.requirements;

import com.xac.core.bo.BaseBo;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.util.Date;

/**
 * <pre>
 * 出库需求表 查询结果业务对象
 * </pre>
 *
 * @author puck
 * @date 2020-12-23
 */
@Data
@Accessors(chain = true)
public class OutRequirementBo extends BaseBo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 表id
     */
    private Long id;

    /**
     * 需求编号，自动生成
     */
    private String requirementCode;

    /**
     * 原始单据ID
     */
    private String originalOrderId;

    /**
     * 原始单据来源，sale:采购、ames:装配mes、emes:零件mes、wms:统一库房自提
     */
    private String originalFrom;

    /**
     * 出库需求类型
     */
    private String requirementType;

    /**
     * 库房编码
     */
    private String warehouseCode;

    /**
     * 原始单据类型
     */
    private String originalType;

    /**
     * 原始单据编码
     */
    private String originalCode;

    /**
     * 需求组织类型，对外销售公司，内部
     */
    private String requirementOrganizationType;

    /**
     * 需求部门ID
     */
    private String requirementDeptId;

    /**
     * 需求部门名称
     */
    private String requirementDeptName;

    /**
     * 领用人
     */
    private String requirementUserId;

    /**
     * 领用人名称
     */
    private String requirementUserName;

    /**
     * 领用地址
     */
    private String requirementAddress;

    /**
     * 申请时间
     */
    private Date applyOutDate;

    /**
     * 申请人
     */
    private String applySysUser;

    /**
     * 申请部门
     */
    private String applyHrDept;

    /**
     * 申请时间
     */
    private Date applyDate;

    /**
     * 备注
     */
    private String note;

    /**
     * 状态(已生成、已确认、部分出库、已完成、已关闭)
     */
    private String status;

    /**
     * 版本
     */
    private String version;

}
