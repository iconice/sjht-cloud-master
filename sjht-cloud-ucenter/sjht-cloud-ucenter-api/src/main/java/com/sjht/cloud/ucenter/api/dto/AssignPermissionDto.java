package com.sjht.cloud.ucenter.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName AssignPermissionDto
 * @Description 分配权限dto
 * @Author maojianyun
 * @Date 2019/12/23 13:49
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ToString
@ApiModel(value = "AssignPermissionDto", description = "分配权限dto")
public class AssignPermissionDto implements Serializable {

    private static final long serialVersionUID = -3126077632781801241L;

    @ApiModelProperty(name = "roleId", value = "角色id", required = true)
    private long roleId;

    @ApiModelProperty(name = "permissionIdStr", value = "权限id,多个权限id用逗号分隔", example = "id1,id2,id3", required = true)
    private String permissionIdStr;
}
