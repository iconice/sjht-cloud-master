package com.sjht.cloud.ucenter.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName CreateRoleDto
 * @Description 创建角色Dto
 * @Author maojianyun
 * @Date 2019/12/23 11:13
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ToString
@ApiModel(value = "CreateRoleDto", description = "创建角色Dto")
public class CreateRoleDto implements Serializable {

    @ApiModelProperty(name = "name", value = "角色名称", example = "系统管理员", required = true)
    private String name;

    @ApiModelProperty(name = "description", value = "角色描述", example = "系统管理员", required = false)
    private String description;
}
