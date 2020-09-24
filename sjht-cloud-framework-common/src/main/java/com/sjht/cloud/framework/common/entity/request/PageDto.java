package com.sjht.cloud.framework.common.entity.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName PageDto
 * @Description 分页查询基础类
 * @Author maojianyun
 * @Date 2019/12/2 11:37
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ApiModel(value = "PageDto",description = "列表分页请求")
public class PageDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "offset", value = "偏移量(后端重新计算后)/当前查询页数(前端传入时,从1开始)", example = "0", required = true)
    private Integer offset;

    @ApiModelProperty(name = "pageSize", value = "每页条数", example = "10", required = true)
    private Integer pageSize;
}
