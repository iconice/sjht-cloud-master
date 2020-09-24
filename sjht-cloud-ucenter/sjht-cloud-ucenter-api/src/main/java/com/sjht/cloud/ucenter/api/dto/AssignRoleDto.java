package com.sjht.cloud.ucenter.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName AssignRoleDto
 * @Description AssignRoleDto
 * @Author maojianyun
 * @Date 2019/12/24 10:40
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ToString
@ApiModel(value = "AssignRoleDto", description = "分配角色dto")
public class AssignRoleDto implements Serializable {

    @ApiModelProperty(name = "userId", value = "用户id", required = true)
    private long userId;

    @ApiModelProperty(name = "roleIdStr", value = "角色id，多个id格式为：id1,id2,id3", required = true)
    private String roleIdStr;
}
