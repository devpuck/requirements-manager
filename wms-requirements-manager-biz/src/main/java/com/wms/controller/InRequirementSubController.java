package com.wms.controller;

import com.xac.core.util.BeanListUtil;
import com.wms.model.entity.InRequirementSubEntity;
import com.wms.service.InRequirementSubService;
import com.wms.api.requirements.InRequirementSubQueryParam;
import com.wms.api.requirements.InRequirementSubVo;
import com.wms.model.bo.requirements.InRequirementSubBo;
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
 * 入库需求子表 前端控制器
 * </pre>
 *
 * @author puck
 * @since 2020-12-24
 */
@Slf4j
@RestController
@RequestMapping("/requirements555")
@Api("入库需求子表 API")
public class InRequirementSubController extends BaseController {

    @Autowired
    private InRequirementSubService inRequirementSubService;

    /**
     * 添加入库需求子表
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加InRequirementSub对象", notes = "添加入库需求子表", response = ApiResult.class)
    public ApiResult<Boolean> addInRequirementSub(@Valid @RequestBody InRequirementSubVo inRequirementSub) throws Exception {
         InRequirementSubBo bo = new InRequirementSubBo();
        BeanUtils.copyProperties(inRequirementSub,bo);

        boolean flag = inRequirementSubService.saveInRequirementSub(bo);
        return ApiResult.result(flag);
    }

    /**
     * 修改入库需求子表
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改InRequirementSub对象", notes = "修改入库需求子表", response = ApiResult.class)
    public ApiResult<Boolean> updateInRequirementSub(@Valid @RequestBody InRequirementSubVo inRequirementSub) throws Exception {
        InRequirementSubBo bo = new InRequirementSubBo();
        BeanUtils.copyProperties(inRequirementSub,bo);

        boolean flag = inRequirementSubService.updateInRequirementSub(bo);
        return ApiResult.result(flag);
    }

    /**
     * 删除入库需求子表
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除InRequirementSub对象", notes = "删除入库需求子表", response = ApiResult.class)
    public ApiResult<Boolean> deleteInRequirementSub(@PathVariable("id") Long id) throws Exception {
        boolean flag = inRequirementSubService.deleteInRequirementSub(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取入库需求子表
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取InRequirementSub对象详情", notes = "查看入库需求子表", response = InRequirementSubVo.class)
    public ApiResult<InRequirementSubVo> getInRequirementSub(@PathVariable("id") Long id) throws Exception {
        InRequirementSubBo inRequirementSubBo = inRequirementSubService.getInRequirementSubById(id);
        InRequirementSubVo queryVo = null;
        if (inRequirementSubBo != null) {
            queryVo = new InRequirementSubVo();
            BeanUtils.copyProperties(inRequirementSubBo , queryVo);
        }
        return ApiResult.ok(queryVo);
    }

    /**
     * 入库需求子表分页列表
     */
    @PostMapping("/pagelist")
    @ApiOperation(value = "获取InRequirementSub分页列表", notes = "入库需求子表分页列表", response = InRequirementSubVo.class)
    public ApiResult<Paging<InRequirementSubVo>> getInRequirementSubPageList(@Valid @RequestBody InRequirementSubQueryParam inRequirementSubQueryParam) throws Exception {
        Paging<InRequirementSubBo> paging = inRequirementSubService.getInRequirementSubPageList(inRequirementSubQueryParam);
        Paging<InRequirementSubVo> resultPage = new Paging<>();
        resultPage.setTotal(paging.getTotal());
        resultPage.setRecords(BeanListUtil.copyListProperties(paging.getRecords(), InRequirementSubVo.class));
        return ApiResult.ok(resultPage);
    }

}

