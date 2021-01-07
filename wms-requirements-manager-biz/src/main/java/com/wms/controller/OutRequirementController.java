package com.wms.controller;

import com.xac.core.util.BeanListUtil;
import com.wms.model.entity.OutRequirementEntity;
import com.wms.service.OutRequirementService;
import com.wms.api.requirements.OutRequirementQueryParam;
import com.wms.api.requirements.OutRequirementVo;
import com.wms.model.bo.requirements.OutRequirementBo;
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

/**
 * <pre>
 * 出库需求表 前端控制器
 * </pre>
 *
 * @author puck
 * @since 2020-12-23
 */
@Slf4j
@RestController
@RequestMapping("/4444")
@Api("出库需求表 API")
public class OutRequirementController extends BaseController {

    @Autowired
    private OutRequirementService outRequirementService;

    /**
     * 添加出库需求表
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加OutRequirement对象", notes = "添加出库需求表", response = ApiResult.class)
    public ApiResult<Boolean> addOutRequirement(@Valid @RequestBody OutRequirementVo outRequirement) throws Exception {
         OutRequirementBo bo = new OutRequirementBo();
        BeanUtils.copyProperties(outRequirement,bo);

        boolean flag = outRequirementService.saveOutRequirement(bo);
        return ApiResult.result(flag);
    }

    /**
     * 修改出库需求表
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改OutRequirement对象", notes = "修改出库需求表", response = ApiResult.class)
    public ApiResult<Boolean> updateOutRequirement(@Valid @RequestBody OutRequirementVo outRequirement) throws Exception {
        OutRequirementBo bo = new OutRequirementBo();
        BeanUtils.copyProperties(outRequirement,bo);

        boolean flag = outRequirementService.updateOutRequirement(bo);
        return ApiResult.result(flag);
    }

    /**
     * 删除出库需求表
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除OutRequirement对象", notes = "删除出库需求表", response = ApiResult.class)
    public ApiResult<Boolean> deleteOutRequirement(@PathVariable("id") Long id) throws Exception {
        boolean flag = outRequirementService.deleteOutRequirement(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取出库需求表
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取OutRequirement对象详情", notes = "查看出库需求表", response = OutRequirementVo.class)
    public ApiResult<OutRequirementVo> getOutRequirement(@PathVariable("id") Long id) throws Exception {
        OutRequirementBo outRequirementBo = outRequirementService.getOutRequirementById(id);
        OutRequirementVo queryVo = null;
        if (outRequirementBo != null) {
            queryVo = new OutRequirementVo();
            BeanUtils.copyProperties(outRequirementBo , queryVo);
        }
        return ApiResult.ok(queryVo);
    }

    /**
     * 出库需求表分页列表
     */
    @PostMapping("/pagelist")
    @ApiOperation(value = "获取OutRequirement分页列表", notes = "出库需求表分页列表", response = OutRequirementVo.class)
    public ApiResult<Paging<OutRequirementVo>> getOutRequirementPageList(@Valid @RequestBody OutRequirementQueryParam outRequirementQueryParam) throws Exception {
        Paging<OutRequirementBo> paging = outRequirementService.getOutRequirementPageList(outRequirementQueryParam);
        Paging<OutRequirementVo> resultPage = new Paging<>();
        resultPage.setTotal(paging.getTotal());
        resultPage.setRecords(BeanListUtil.copyListProperties(paging.getRecords(), OutRequirementVo.class));
        return ApiResult.ok(resultPage);
    }

}

