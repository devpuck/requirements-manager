package com.wms.api.requirements;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.xac.core.vo.BaseVo;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.util.Date;

/**
 * <pre>
 * 出库需求表 查询结果对象
 * </pre>
 *
 * @author puck
 * @date 2020-12-23
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "OutRequirementVo对象", description = "出库需求表查询参数")
public class OutRequirementVo extends BaseVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "表id")
    private Long id;

    @ApiModelProperty(value = "需求编号，自动生成")
    private String requirementCode;

    @ApiModelProperty(value = "原始单据ID")
    private String originalOrderId;

    @ApiModelProperty(value = "原始单据来源，sale:采购、ames:装配mes、emes:零件mes、wms:统一库房自提")
    private String originalFrom;

    @ApiModelProperty(value = "出库需求类型")
    private String requirementType;

    @ApiModelProperty(value = "库房编码")
    private String warehouseCode;

    @ApiModelProperty(value = "原始单据类型")
    private String originalType;

    @ApiModelProperty(value = "原始单据编码")
    private String originalCode;

    @ApiModelProperty(value = "需求组织类型，对外销售公司，内部")
    private String requirementOrganizationType;

    @ApiModelProperty(value = "需求部门ID")
    private String requirementDeptId;

    @ApiModelProperty(value = "需求部门名称")
    private String requirementDeptName;

    @ApiModelProperty(value = "领用人")
    private String requirementUserId;

    @ApiModelProperty(value = "领用人名称")
    private String requirementUserName;

    @ApiModelProperty(value = "领用地址")
    private String requirementAddress;

    @ApiModelProperty(value = "申请时间")
    private Date applyOutDate;

    @ApiModelProperty(value = "申请人")
    private String applySysUser;

    @ApiModelProperty(value = "申请部门")
    private String applyHrDept;

    @ApiModelProperty(value = "申请时间")
    private Date applyDate;

    @ApiModelProperty(value = "备注")
    private String note;

    @ApiModelProperty(value = "状态(已生成、已确认、部分出库、已完成、已关闭)")
    private String status;

    @ApiModelProperty(value = "版本")
    private String version;

}
