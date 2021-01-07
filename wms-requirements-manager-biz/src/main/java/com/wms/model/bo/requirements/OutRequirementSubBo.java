package com.wms.model.bo.requirements;

import com.xac.core.bo.BaseBo;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <pre>
 * 出库需求子表 查询结果业务对象
 * </pre>
 *
 * @author puck
 * @date 2020-12-24
 */
@Data
@Accessors(chain = true)
public class OutRequirementSubBo extends BaseBo implements Serializable {
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
     * 产品编码
     */
    private String productionCode;

    /**
     * 父产品编码
     */
    private String parentProductionCode;

    /**
     * 是否为父件，0父件、1子件、2非父子件
     */
    private String isParent;

    /**
     * 物料制造处理状态，produce 在制品，clout 余料，waste废料
     */
    private String produceStatus;

    /**
     * 项目编码
     */
    private String projectCode;

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
     * 批次
     */
    private String batch;

    /**
     * 构型号
     */
    private String constructionCode;

    /**
     * 版号
     */
    private String modelCode;

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

    private String versionCode;

    /**
     * 质检状态
     */
    private String qualityStatus;

    private String status;

    /**
     * 需求数量
     */
    private BigDecimal requirementQuantity;

    /**
     * 批料数量
     */
    private BigDecimal applyQuantity;

    /**
     * 试料数量
     */
    private BigDecimal tryQuantity;

    /**
     * 库位号
     */
    private String warehouseLocationCode;

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
     * 合格证号
     */
    private String certificateNo;

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

}
