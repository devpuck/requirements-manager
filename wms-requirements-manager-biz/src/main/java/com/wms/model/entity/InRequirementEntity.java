package com.wms.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.xac.core.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <pre>
 * 入库需求表
 * </pre>
 *
 * @author puck
 * @since 2020-12-23
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@TableName("WMS_IN_REQUIREMENT")
public class InRequirementEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 表id
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 需求编号，自动生成
     */
    private String requirementCode;

    /**
     * 库房编号
     */
    private String warehouseCode;

    /**
     * 原始单据ID
     */
    private String originalOrderId;

    /**
     * 原始单据来源，sale:采购、ames:装配mes、emes:零件mes、wms:统一库房自提
     */
    private String originalFrom;

    /**
     * 原始单据编码
     */
    private String originalCode;

    /**
     * 原始单据类型,统一数据库事务对应对子集，如合同到货、紧急到货
     */
    private String originalType;

    /**
     * 需求入库类型，对应之前事务
     */
    private String requirementType;

    /**
     * 合同号
     */
    private String contractCode;

    /**
     * 提供者ID
     */
    private String supplierId;

    /**
     * 提供者类型，supplier 供应商，workshop 生产车间
     */
    private String supplierType;

    /**
     * 提供者名字，采购为供应商，生产部门为生产部门名字
     */
    private String supplierName;

    /**
     * 发货地址，采购为供应商地址，生产为车间地址
     */
    private String supplierAddress;

    /**
     * 到货单类型（普通发货、军品发货、转包品发货、修理品发货)
     */
    private String deliverType;

    /**
     * 到货日期
     */
    private Date deliverDate;

    /**
     * 申请人
     */
    private String applySysUser;

    /**
     * 申请部门
     */
    private String applyHrDept;

    /**
     * 申请日期
     */
    private Date applyDate;

    /**
     * 备注
     */
    private String note;

    /**
     * 发货状态(已生成、已确认、部分出库、已完成、已关闭、已删除)
     */
    private String status;

    /**
     * 版本
     */
    private String version;

}
