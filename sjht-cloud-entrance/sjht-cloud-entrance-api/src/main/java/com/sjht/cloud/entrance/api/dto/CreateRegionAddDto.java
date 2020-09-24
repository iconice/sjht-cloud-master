package com.sjht.cloud.entrance.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName CreateRegionAddDto
 * @Description 创建区域地址dto
 * @Author maojianyun
 * @Date 2020/1/8 10:58
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ToString
@ApiModel(value = "CreateRegionAddDto", description = "创建区域地址dto")
public class CreateRegionAddDto implements Serializable {

    @ApiModelProperty(name = "parentId", value = "如果是小区就默认我0")
    private long parentId;

    @ApiModelProperty(name = "name", value = "小区名称或地址")
    private String name;

    @ApiModelProperty(name = "type", value = "1-小区、2-地址")
    private int type;

    @ApiModelProperty(name = "remark", value = "备注")
    private String remark;
}
