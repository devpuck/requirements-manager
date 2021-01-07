package com.wms.model.bo.requirements;

import com.xac.core.bo.BaseBo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <pre>
 * 入库需求子表 查询结果业务对象
 * </pre>
 *
 * @author puck
 * @date 2020-12-24
 */
@Data
@Accessors(chain = true)
public class InRequirementSubBo extends BaseBo implements Serializable {
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
     * 原始子表ID,如果存在的话
     */
    private String originalOrderListId;

    /**
     * 原始单据子号
     */
    private String originalSubCode;

    /**
     * 合同子号
     */
    private String contractSubCode;

    /**
     * 派工号，FO执行序列号
     */
    private String dispatchCode;

    /**
     * 产品编码
     */
    private String productionCode;

    /**
     * 产品类型
     */
    private String productionType;

    /**
     * 是否为父件，0父件、1子件、2非父子件
     */
    private String isParent;

    /**
     * 物料制造处理状态，produce 在制品，clout 余料，waste废料
     */
    private String produceStatus;

    /**
     * 父产品编码
     */
    private String parentProductionCode;

    /**
     * 项目编码
     */
    private String projectCode;

    /**
     * 采购价格
     */
    private BigDecimal buyPrice;

    /**
     * 价格单位
     */
    private String priceUnit;

    /**
     * 均摊比例，只在成品中使用，如果大于0，则为成品均摊计价
     */
    private BigDecimal buyPricePrecent;

    /**
     * 牌号
     */
    private String brand;

    /**
     * 规格
     */
    private String specifications;

    /**
     * 状态/级别/型号
     */
    private String productionLevel;

    /**
     * 项目编码
     */
    private String technicalConditions;

    /**
     * 附加技术条件
     */
    private String additionalTechnicalConditions;

    /**
     * 图号
     */
    private String drawCode;

    /**
     * 三期代码
     */
    private String threePeriodCode;

    /**
     * 生产日期
     */
    private Date manufactureDate;

    /**
     * 过期日期
     */
    private Date expirationDate;

    /**
     * 批次号
     */
    private String batch;

    /**
     * 炉批号或小号
     */
    private String splysotCode;

    /**
     * 机型
     */
    private String aircraftCode;

    /**
     * 架次
     */
    private String sortieCode;

    /**
     * 版号
     */
    private String modelCode;

    /**
     * 构型号
     */
    private String constructionCode;

    /**
     * 质量编号
     */
    private String qualityCode;

    /**
     * 质检状态
     */
    private String qualityStatus;

    /**
     * 需求状态
     */
    private String status;

    /**
     * 合格证号
     */
    private String certificateNo;

    /**
     * 供方合格证号
     */
    private String supplyCertificateNo;

    /**
     * 需求数量
     */
    private BigDecimal requirementQuantity;

    /**
     * 接收数量
     */
    private BigDecimal receiveQuantity;

    /**
     * 试料数量
     */
    private BigDecimal tryQuantity;

    /**
     * 主单位
     */
    private String unit;

    /**
     * 接收人
     */
    private String receiverSysUser;

    /**
     * 接收部门
     */
    private String receiverHrDept;

    /**
     * 是否寄售
     */
    private String isConsignment;

    /**
     * 备注
     */
    private String details;

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

    /**
     * 重量
     */
    private BigDecimal weight;
    /**
     * 重量单位
     */
    private String weightUnit;
    /**
     * 提供者类型
     */
    private String supplierType;
    /**
     * 提供者
     */
    private String supplierBy;
    /**
     * 物料尺寸，本身为物料属性，此处尺寸仅仅在物料状态为余料时有效
     */
    private String productionSize;

}
