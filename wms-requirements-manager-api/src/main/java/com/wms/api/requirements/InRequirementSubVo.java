package com.wms.api.requirements;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.xac.core.vo.BaseVo;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <pre>
 * 入库需求子表 查询结果对象
 * </pre>
 *
 * @author puck
 * @date 2020-12-24
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "InRequirementSubVo对象", description = "入库需求子表查询参数")
public class InRequirementSubVo extends BaseVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "表id")
    private Long id;

    @ApiModelProperty(value = "需求编号，自动生成")
    private String requirementCode;

    @ApiModelProperty(value = "原始子表ID,如果存在的话")
    private String originalOrderListId;

    @ApiModelProperty(value = "原始单据子号")
    private String originalSubCode;

    @ApiModelProperty(value = "合同子号")
    private String contractSubCode;

    @ApiModelProperty(value = "派工号，FO执行序列号")
    private String dispatchCode;

    @ApiModelProperty(value = "产品编码")
    private String productionCode;

    @ApiModelProperty(value = "产品类型")
    private String productionType;

    @ApiModelProperty(value = "是否为父件，0父件、1子件、2非父子件")
    private String isParent;

    @ApiModelProperty(value = "物料制造处理状态，produce 在制品，clout 余料，waste废料")
    private String produceStatus;

    @ApiModelProperty(value = "父产品编码")
    private String parentProductionCode;

    @ApiModelProperty(value = "项目编码")
    private String projectCode;

    @ApiModelProperty(value = "采购价格")
    private BigDecimal buyPrice;

    @ApiModelProperty(value = "价格单位")
    private String priceUnit;

    @ApiModelProperty(value = "均摊比例，只在成品中使用，如果大于0，则为成品均摊计价")
    private BigDecimal buyPricePrecent;

    @ApiModelProperty(value = "牌号")
    private String brand;

    @ApiModelProperty(value = "规格")
    private String specifications;

    @ApiModelProperty(value = "状态/级别/型号")
    private String productionLevel;

    @ApiModelProperty(value = "项目编码")
    private String technicalConditions;

    @ApiModelProperty(value = "附加技术条件")
    private String additionalTechnicalConditions;

    @ApiModelProperty(value = "图号")
    private String drawCode;

    @ApiModelProperty(value = "三期代码")
    private String threePeriodCode;

    @ApiModelProperty(value = "生产日期")
    private Date manufactureDate;

    @ApiModelProperty(value = "过期日期")
    private Date expirationDate;

    @ApiModelProperty(value = "批次号")
    private String batch;

    @ApiModelProperty(value = "炉批号或小号")
    private String splysotCode;

    @ApiModelProperty(value = "机型")
    private String aircraftCode;

    @ApiModelProperty(value = "架次")
    private String sortieCode;

    @ApiModelProperty(value = "版号")
    private String modelCode;

    @ApiModelProperty(value = "构型号")
    private String constructionCode;

    @ApiModelProperty(value = "质量编号")
    private String qualityCode;

    @ApiModelProperty(value = "质检状态")
    private String qualityStatus;

    @ApiModelProperty(value = "需求状态")
    private String status;

    @ApiModelProperty(value = "合格证号")
    private String certificateNo;

    @ApiModelProperty(value = "供方合格证号")
    private String supplyCertificateNo;

    @ApiModelProperty(value = "需求数量")
    private BigDecimal requirementQuantity;

    @ApiModelProperty(value = "接收数量")
    private BigDecimal receiveQuantity;

    @ApiModelProperty(value = "试料数量")
    private BigDecimal tryQuantity;

    @ApiModelProperty(value = "主单位")
    private String unit;

    @ApiModelProperty(value = "接收人")
    private String receiverSysUser;

    @ApiModelProperty(value = "接收部门")
    private String receiverHrDept;

    @ApiModelProperty(value = "是否寄售")
    private String isConsignment;

    @ApiModelProperty(value = "备注")
    private String details;

    @ApiModelProperty(value = "重量")
    private BigDecimal weight;
    @ApiModelProperty(value = "重量单位")
    private String weightUnit;
    @ApiModelProperty(value = "提供者类型")
    private String supplierType;
    @ApiModelProperty(value = "提供者")
    private String supplierBy;
    @ApiModelProperty(value = "物料尺寸，本身为物料属性，此处尺寸仅仅在物料状态为余料时有效")
    private String productionSize;

private String attribute1;

private String attribute2;

private String attribute3;

private String attribute4;

private String attribute5;

private String attribute6;

private String attribute7;

private String attribute8;

private String attribute9;

private String attribute10;

private String version;

}
