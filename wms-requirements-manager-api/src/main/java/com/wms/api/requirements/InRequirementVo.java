package com.wms.api.requirements;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.xac.core.vo.BaseVo;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.util.Date;
import java.util.List;

/**
 * <pre>
 * 入库需求表 查询结果对象
 * </pre>
 *
 * @author puck
 * @date 2020-12-23
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "InRequirementVo对象", description = "入库需求表查询参数")
public class InRequirementVo extends BaseVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "表id")
    private Long id;

    @ApiModelProperty(value = "需求编号，自动生成")
    private String requirementCode;

    @ApiModelProperty(value = "库房编号")
    private String warehouseCode;

    @ApiModelProperty(value = "原始单据ID")
    private String originalOrderId;

    @ApiModelProperty(value = "原始单据来源，sale:采购、ames:装配mes、emes:零件mes、wms:统一库房自提")
    private String originalFrom;

    @ApiModelProperty(value = "原始单据编码")
    private String originalCode;

    @ApiModelProperty(value = "原始单据类型,统一数据库事务对应对子集，如合同到货、紧急到货")
    private String originalType;

    @ApiModelProperty(value = "需求入库类型，对应之前事务")
    private String requirementType;

    @ApiModelProperty(value = "合同号")
    private String contractCode;

    @ApiModelProperty(value = "提供者ID")
    private String supplierId;

    @ApiModelProperty(value = "提供者类型，supplier 供应商，workshop 生产车间")
    private String supplierType;

    @ApiModelProperty(value = "提供者名字，采购为供应商，生产部门为生产部门名字")
    private String supplierName;

    @ApiModelProperty(value = "发货地址，采购为供应商地址，生产为车间地址")
    private String supplierAddress;

    @ApiModelProperty(value = "到货单类型（普通发货、军品发货、转包品发货、修理品发货)")
    private String deliverType;

    @ApiModelProperty(value = "到货日期")
    private Date deliverDate;

    @ApiModelProperty(value = "申请人")
    private String applySysUser;

    @ApiModelProperty(value = "申请部门")
    private String applyHrDept;

    @ApiModelProperty(value = "申请日期")
    private Date applyDate;

    @ApiModelProperty(value = "备注")
    private String note;

    @ApiModelProperty(value = "发货状态(已生成、已确认、部分出库、已完成、已关闭、已删除)")
    private String status;

    @ApiModelProperty(value = "版本")
    private String version;

    @ApiModelProperty(value = "需求子单列表")
    private List<InRequirementSubVo> inRequirementSubVoList;

}
