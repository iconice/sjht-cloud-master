package com.sjht.cloud.ucenter.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * ***************************************************
 *
 * @ClassName RoleInfoDto
 * @Description 描述
 * @Author maojianyun
 * @Date 2019/12/23 11:26
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ToString
@ApiModel(value = "RoleInfoDto", description = "角色dto")
public class RoleInfoDto implements Serializable {
    private static final long serialVersionUID = -7628305433773486283L;

    @ApiModelProperty(name = "id", value = "id")
    private long id;

    @ApiModelProperty(name = "name", value = "角色名称")
    private String name;

    @ApiModelProperty(name = "description", value = "角色描述")
    private String description;

    @ApiModelProperty(name = "status", value = "是否删除0-未删除，1-删除（默认为0）")
    private int status;
}
