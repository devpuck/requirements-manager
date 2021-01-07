package com.wms.controller;

import com.xac.core.util.BeanListUtil;
import com.wms.model.entity.OutRequirementSubEntity;
import com.wms.service.OutRequirementSubService;
import com.wms.api.requirements.OutRequirementSubQueryParam;
import com.wms.api.requirements.OutRequirementSubVo;
import com.wms.model.bo.requirements.OutRequirementSubBo;
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
 * 出库需求子表 前端控制器
 * </pre>
 *
 * @author puck
 * @since 2020-12-24
 */
@Slf4j
@RestController
@RequestMapping("/requirements")
@Api("出库需求子表 API")
public class OutRequirementSubController extends BaseController {

    @Autowired
    private OutRequirementSubService outRequirementSubService;

    /**
     * 添加出库需求子表
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加OutRequirementSub对象", notes = "添加出库需求子表", response = ApiResult.class)
    public ApiResult<Boolean> addOutRequirementSub(@Valid @RequestBody OutRequirementSubVo outRequirementSub) throws Exception {
         OutRequirementSubBo bo = new OutRequirementSubBo();
        BeanUtils.copyProperties(outRequirementSub,bo);

        boolean flag = outRequirementSubService.saveOutRequirementSub(bo);
        return ApiResult.result(flag);
    }

    /**
     * 修改出库需求子表
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改OutRequirementSub对象", notes = "修改出库需求子表", response = ApiResult.class)
    public ApiResult<Boolean> updateOutRequirementSub(@Valid @RequestBody OutRequirementSubVo outRequirementSub) throws Exception {
        OutRequirementSubBo bo = new OutRequirementSubBo();
        BeanUtils.copyProperties(outRequirementSub,bo);

        boolean flag = outRequirementSubService.updateOutRequirementSub(bo);
        return ApiResult.result(flag);
    }

    /**
     * 删除出库需求子表
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除OutRequirementSub对象", notes = "删除出库需求子表", response = ApiResult.class)
    public ApiResult<Boolean> deleteOutRequirementSub(@PathVariable("id") Long id) throws Exception {
        boolean flag = outRequirementSubService.deleteOutRequirementSub(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取出库需求子表
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取OutRequirementSub对象详情", notes = "查看出库需求子表", response = OutRequirementSubVo.class)
    public ApiResult<OutRequirementSubVo> getOutRequirementSub(@PathVariable("id") Long id) throws Exception {
        OutRequirementSubBo outRequirementSubBo = outRequirementSubService.getOutRequirementSubById(id);
        OutRequirementSubVo queryVo = null;
        if (outRequirementSubBo != null) {
            queryVo = new OutRequirementSubVo();
            BeanUtils.copyProperties(outRequirementSubBo , queryVo);
        }
        return ApiResult.ok(queryVo);
    }

    /**
     * 出库需求子表分页列表
     */
    @PostMapping("/pagelist")
    @ApiOperation(value = "获取OutRequirementSub分页列表", notes = "出库需求子表分页列表", response = OutRequirementSubVo.class)
    public ApiResult<Paging<OutRequirementSubVo>> getOutRequirementSubPageList(@Valid @RequestBody OutRequirementSubQueryParam outRequirementSubQueryParam) throws Exception {
        Paging<OutRequirementSubBo> paging = outRequirementSubService.getOutRequirementSubPageList(outRequirementSubQueryParam);
        Paging<OutRequirementSubVo> resultPage = new Paging<>();
        resultPage.setTotal(paging.getTotal());
        resultPage.setRecords(BeanListUtil.copyListProperties(paging.getRecords(), OutRequirementSubVo.class));
        return ApiResult.ok(resultPage);
    }

}

