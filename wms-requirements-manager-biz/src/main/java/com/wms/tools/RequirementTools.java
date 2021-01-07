package com.wms.tools;

import com.wms.api.instorage.InWarehouseBillSubVo;
import com.wms.api.instorage.InWarehouseBillVo;
import com.wms.model.bo.requirements.InRequirementBo;
import com.wms.model.bo.requirements.InRequirementSubBo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author puck
 * @date 2020/12/25 2:51 下午
 */
public class RequirementTools
{
    public static InWarehouseBillSubVo generateInWarehouseSubBill(InRequirementSubBo inRequirementSubBo)
    {
        if(null == inRequirementSubBo)
        {
            return null;
        }

        InWarehouseBillSubVo inWarehouseBillSubVo = new InWarehouseBillSubVo();
        inWarehouseBillSubVo.setRequirementSubId(inRequirementSubBo.getId().toString());

        inWarehouseBillSubVo.setAdditionalTechnicalConditions(inRequirementSubBo.getAdditionalTechnicalConditions());
        inWarehouseBillSubVo.setAircraftCode(inRequirementSubBo.getAircraftCode());
        inWarehouseBillSubVo.setAttribute1(inRequirementSubBo.getAttribute1());
        inWarehouseBillSubVo.setAttribute2(inRequirementSubBo.getAttribute2());
        inWarehouseBillSubVo.setAttribute3(inRequirementSubBo.getAttribute3());
        inWarehouseBillSubVo.setAttribute4(inRequirementSubBo.getAttribute4());
        inWarehouseBillSubVo.setAttribute5(inRequirementSubBo.getAttribute5());
        inWarehouseBillSubVo.setAttribute6(inRequirementSubBo.getAttribute6());
        inWarehouseBillSubVo.setAttribute7(inRequirementSubBo.getAttribute7());
        inWarehouseBillSubVo.setAttribute8(inRequirementSubBo.getAttribute8());
        inWarehouseBillSubVo.setAttribute9(inRequirementSubBo.getAttribute9());
        inWarehouseBillSubVo.setAttribute10(inRequirementSubBo.getAttribute10());

        inWarehouseBillSubVo.setBatch(inRequirementSubBo.getBatch());
        inWarehouseBillSubVo.setBrand(inRequirementSubBo.getBrand());
        inWarehouseBillSubVo.setBuyPrice(inRequirementSubBo.getBuyPrice());
        inWarehouseBillSubVo.setBuyPriceUnit(inRequirementSubBo.getPriceUnit());

        inWarehouseBillSubVo.setCertificateNo(inRequirementSubBo.getCertificateNo());
        inWarehouseBillSubVo.setConstructionCode(inRequirementSubBo.getConstructionCode());
        inWarehouseBillSubVo.setContractSubCode(inRequirementSubBo.getContractSubCode());

        inWarehouseBillSubVo.setDetails(inRequirementSubBo.getDetails());
        inWarehouseBillSubVo.setDispatchCode(inRequirementSubBo.getDispatchCode());
        inWarehouseBillSubVo.setDrawCode(inRequirementSubBo.getDrawCode());

        inWarehouseBillSubVo.setExpirationDate(inRequirementSubBo.getExpirationDate());
        inWarehouseBillSubVo.setIsConsignment(inRequirementSubBo.getIsConsignment());
        inWarehouseBillSubVo.setIsParent(inRequirementSubBo.getIsParent());
        inWarehouseBillSubVo.setManufactureDate(inRequirementSubBo.getManufactureDate());
        inWarehouseBillSubVo.setModelCode(inRequirementSubBo.getModelCode());

        inWarehouseBillSubVo.setProductionCode(inRequirementSubBo.getProductionCode());
        inWarehouseBillSubVo.setParentProductionCode(inRequirementSubBo.getParentProductionCode());
        inWarehouseBillSubVo.setProduceStatus(inRequirementSubBo.getProduceStatus());
        inWarehouseBillSubVo.setProductionLevel(inRequirementSubBo.getProductionLevel());
        inWarehouseBillSubVo.setProductionType(inRequirementSubBo.getProductionType());
        inWarehouseBillSubVo.setProductionSize(inRequirementSubBo.getProductionSize());
        inWarehouseBillSubVo.setProjectCode(inRequirementSubBo.getProjectCode());

        inWarehouseBillSubVo.setQualityCode(inRequirementSubBo.getQualityCode());
        inWarehouseBillSubVo.setQualityStatus(inRequirementSubBo.getQualityStatus());
        inWarehouseBillSubVo.setQuantity(inRequirementSubBo.getReceiveQuantity());

        inWarehouseBillSubVo.setReceiverHrDept(inRequirementSubBo.getReceiverHrDept());
        inWarehouseBillSubVo.setReceiverSysUser(inRequirementSubBo.getReceiverSysUser());

        inWarehouseBillSubVo.setThreePeriodCode(inRequirementSubBo.getThreePeriodCode());
        inWarehouseBillSubVo.setTechnicalConditions(inRequirementSubBo.getTechnicalConditions());

        inWarehouseBillSubVo.setSortieCode(inRequirementSubBo.getSortieCode());
        inWarehouseBillSubVo.setSpecifications(inRequirementSubBo.getSpecifications());
        inWarehouseBillSubVo.setSplysotCode(inRequirementSubBo.getSplysotCode());
        inWarehouseBillSubVo.setSupplierBy(inRequirementSubBo.getSupplierBy());
        inWarehouseBillSubVo.setSupplierType(inRequirementSubBo.getSupplierType());
        inWarehouseBillSubVo.setSupplyCertificateNo(inRequirementSubBo.getSupplyCertificateNo());

        inWarehouseBillSubVo.setUnit(inRequirementSubBo.getUnit());
        inWarehouseBillSubVo.setWeightUnit(inRequirementSubBo.getWeightUnit());
        inWarehouseBillSubVo.setWeight(inRequirementSubBo.getWeight());

        return inWarehouseBillSubVo;
    }

    public static InWarehouseBillVo generateInWarehouseBill(InRequirementBo inRequirementBo)
    {
        if(null == inRequirementBo || null == inRequirementBo.getId())
        {
            return null;
        }

        InWarehouseBillVo inWarehouseBillVo = new InWarehouseBillVo();
        inWarehouseBillVo.setContractCode(inRequirementBo.getContractCode());
        inWarehouseBillVo.setSystemFrom(inRequirementBo.getOriginalFrom());
        inWarehouseBillVo.setWarehouseCode(inRequirementBo.getWarehouseCode());
        inWarehouseBillVo.setWorkCode(inRequirementBo.getRequirementType());
        inWarehouseBillVo.setDealCode(inRequirementBo.getOriginalType());
        inWarehouseBillVo.setRequirementId(inRequirementBo.getId().toString());
        inWarehouseBillVo.setInDept(inRequirementBo.getApplyHrDept());
        inWarehouseBillVo.setInPerson(inRequirementBo.getApplySysUser());
        inWarehouseBillVo.setNote(inRequirementBo.getNote());
        inWarehouseBillVo.setCreatedBy(inRequirementBo.getCreatedBy());

        List<InRequirementSubBo> inRequirementSubBoList = inRequirementBo.getInRequirementSubBoList();
        List<InWarehouseBillSubVo> inWarehouseBillSubVoList = new ArrayList<InWarehouseBillSubVo>();
        Iterator<InRequirementSubBo> it = inRequirementSubBoList.iterator();
        while(it.hasNext())
        {
            InRequirementSubBo inRequirementSubBo = it.next();
            InWarehouseBillSubVo inWarehouseBillSubVo = generateInWarehouseSubBill(inRequirementSubBo);
            inWarehouseBillSubVoList.add(inWarehouseBillSubVo);
        }

        inWarehouseBillVo.setInWarehouseBillSubVoList(inWarehouseBillSubVoList);
        return inWarehouseBillVo;
    }

}
