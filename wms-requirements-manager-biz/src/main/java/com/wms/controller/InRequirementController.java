package com.wms.controller;

import com.wms.api.requirements.InRequirementSubVo;
import com.wms.errorcode.ErrorCode;
import com.wms.model.bo.requirements.InRequirementSubBo;
import com.wms.util.CheckParameter;
import com.xac.core.api.ApiResultCode;
import com.xac.core.util.BeanListUtil;
import com.wms.model.entity.InRequirementEntity;
import com.wms.service.InRequirementService;
import com.wms.api.requirements.InRequirementQueryParam;
import com.wms.api.requirements.InRequirementVo;
import com.wms.model.bo.requirements.InRequirementBo;
import com.xac.core.api.ApiResult;
import com.xac.core.api.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.BeanUtils;


import javax.validation.Valid;

import com.xac.core.api.Paging;

import java.util.List;

/**
 * <pre>
 * 入库需求表 前端控制器
 * </pre>
 *
 * @author puck
 * @since 2020-12-22
 */
@Slf4j
@RestController
@RequestMapping("/requirement/in")
@Api("入库需求表 API")
public class InRequirementController extends BaseController {

    @Autowired
    private InRequirementService inRequirementService;

    /**
     * 添加入库需求表
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加InRequirement对象", notes = "添加入库需求表", response = ApiResult.class)
    public ApiResult<Boolean> addInRequirement(@Valid @RequestBody InRequirementVo inRequirement) throws Exception
    {
        String originalOrderID = inRequirement.getOriginalOrderId();
        String originalFrom = inRequirement.getOriginalFrom();
        if(ErrorCode.OK != CheckParameter.checkParameter(originalOrderID,originalFrom))
        {
            return ApiResult.result(ApiResultCode.PARAMETER_EXCEPTION);
        }

        String queryRequirementID = inRequirementService.queryRequirementIDByOriginalID(originalOrderID);
        if(null != queryRequirementID)
        {
            ApiResult apiResult = new ApiResult();
            apiResult.setCode(ErrorCode.WAREHOUSE_REQUIREMENT_CODE_REPEAT);
            apiResult.setMsg(ErrorCode.WAREHOUSE_REQUIREMENT_CODE_REPEAT_MESSAGE);
            apiResult.setSuccess(false);
            return apiResult;
        }

        InRequirementBo bo = new InRequirementBo();
        BeanUtils.copyProperties(inRequirement,bo);

        List<InRequirementSubVo> subVoList = inRequirement.getInRequirementSubVoList();
        if(null != subVoList)
        {
            List<InRequirementSubBo> subBoList = BeanListUtil.copyListProperties(subVoList,InRequirementSubBo.class);
            bo.setInRequirementSubBoList(subBoList);
        }

        boolean flag = inRequirementService.saveInRequirement(bo);
        return ApiResult.result(flag);
    }

    /**
     * 修改入库需求表
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改InRequirement对象", notes = "修改入库需求表", response = ApiResult.class)
    public ApiResult<Boolean> updateInRequirement(@Valid @RequestBody InRequirementVo inRequirement) throws Exception {
        InRequirementBo bo = new InRequirementBo();
        BeanUtils.copyProperties(inRequirement,bo);

        boolean flag = inRequirementService.updateInRequirement(bo);
        return ApiResult.result(flag);
    }

    /**
     * 删除入库需求表
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除InRequirement对象", notes = "删除入库需求表", response = ApiResult.class)
    public ApiResult<Boolean> deleteInRequirement(@PathVariable("id") Long id) throws Exception {
        boolean flag = inRequirementService.deleteInRequirement(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取入库需求表
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取InRequirement对象详情", notes = "查看入库需求表", response = InRequirementVo.class)
    public ApiResult<InRequirementVo> getInRequirement(@PathVariable("id") Long id) throws Exception {
        InRequirementBo inRequirementBo = inRequirementService.getInRequirementById(id);
        InRequirementVo queryVo = null;
        if (inRequirementBo != null) {
            queryVo = new InRequirementVo();
            BeanUtils.copyProperties(inRequirementBo , queryVo);
        }
        return ApiResult.ok(queryVo);
    }

    /**
     * 入库需求表分页列表
     */
    @PostMapping("/pagelist")
    @ApiOperation(value = "获取InRequirement分页列表", notes = "入库需求表分页列表", response = InRequirementVo.class)
    public ApiResult<Paging<InRequirementVo>> getInRequirementPageList(@Valid @RequestBody InRequirementQueryParam inRequirementQueryParam) throws Exception {
        Paging<InRequirementBo> paging = inRequirementService.getInRequirementPageList(inRequirementQueryParam);
        Paging<InRequirementVo> resultPage = new Paging<>();
        resultPage.setTotal(paging.getTotal());
        resultPage.setRecords(BeanListUtil.copyListProperties(paging.getRecords(), InRequirementVo.class));
        return ApiResult.ok(resultPage);
    }

    /**
     * 获取入库需求
     */
    @PostMapping("/queryByOriginal")
    @ApiOperation(value = "获取InRequirement对象详情", notes = "查看入库需求表", response = InRequirementVo.class)
    public ApiResult<InRequirementVo> queryInRequirementByOriginal(@RequestParam String originalOrderId) throws Exception
    {
        InRequirementBo inRequirementBo = inRequirementService.queryInRequirementByOriginalID(originalOrderId);
        InRequirementVo queryVo = null;
        if (inRequirementBo != null)
        {
            queryVo = new InRequirementVo();
            BeanUtils.copyProperties(inRequirementBo , queryVo);

            List<InRequirementSubBo> inRequirementSubBoList = inRequirementBo.getInRequirementSubBoList();
            if(null != inRequirementSubBoList)
            {
                List<InRequirementSubVo> inRequirementSubVoList = BeanListUtil.copyListProperties(inRequirementSubBoList, InRequirementSubVo.class);
                queryVo.setInRequirementSubVoList(inRequirementSubVoList);
            }
        }
        return ApiResult.ok(queryVo);
    }

}

