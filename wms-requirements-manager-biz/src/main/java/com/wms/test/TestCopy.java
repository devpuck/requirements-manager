package com.wms.test;

import com.wms.api.requirements.InRequirementSubVo;
import com.wms.api.requirements.InRequirementVo;
import com.wms.model.bo.requirements.InRequirementBo;
import com.wms.model.bo.requirements.InRequirementSubBo;
import com.xac.core.util.BeanListUtil;
import io.swagger.models.auth.In;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author puck
 * @date 2020/12/23 4:14 下午
 */
public class TestCopy
{
    public static void main(String args[]) throws Exception
    {
        InRequirementVo vo = new InRequirementVo();
        InRequirementBo bo = new InRequirementBo();
        vo.setOriginalCode("123");
        vo.setRequirementCode("111");

        List<InRequirementSubVo> inRequirementSubVoList = new ArrayList<InRequirementSubVo>();
        InRequirementSubVo subVo = new InRequirementSubVo();
        subVo.setRequirementCode("111");
        inRequirementSubVoList.add(subVo);

        List<InRequirementSubBo> inRequirementBoList = BeanListUtil.copyListProperties(inRequirementSubVoList,InRequirementSubBo.class);

        bo.setInRequirementSubBoList(inRequirementBoList);

        BeanUtils.copyProperties(vo,bo);
        System.out.println(bo.getOriginalCode());
        System.out.println(bo.getInRequirementSubBoList().size());

        //System.out.println(bo.getInRequirementSubBoList());

    }
}
