package com.sjht.cloud.entrance.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName UpdateRegionAddDto
 * @Description 修改区域地址
 * @Author maojianyun
 * @Date 2020/1/8 12:46
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ToString
@ApiModel(value = "UpdateRegionAddDto", description = "修改区域地址dto")
public class UpdateRegionAddDto implements Serializable {

    @ApiModelProperty(name = "id", value = "id")
    private long id;

    @ApiModelProperty(name = "parentId", value = "父id")
    private long parentId;

    @ApiModelProperty(name = "name", value = "名称")
    private String name;

    @ApiModelProperty(name = "type", value = "类型")
    private int type;

    @ApiModelProperty(name = "remark", value = "备注")
    private String remark;
}
