package com.wms.api.requirements;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.xac.core.api.SortQueryParam;

/**
 * <pre>
 * 出库需求子表 查询参数对象
 * </pre>
 *
 * @author puck
 * @date 2020-12-24
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "OutRequirementSubQueryParam对象", description = "出库需求子表查询参数")
public class OutRequirementSubQueryParam extends SortQueryParam {
    private static final long serialVersionUID = 1L;
}
