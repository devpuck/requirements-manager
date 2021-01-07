package com.wms.api.requirements;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.xac.core.api.SortQueryParam;

/**
 * <pre>
 * 入库需求表 查询参数对象
 * </pre>
 *
 * @author puck
 * @date 2020-12-23
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "InRequirementQueryParam对象", description = "入库需求表查询参数")
public class InRequirementQueryParam extends SortQueryParam {
    private static final long serialVersionUID = 1L;
}
