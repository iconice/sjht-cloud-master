package com.sjht.cloud.ucenter.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName PermissionDto
 * @Description permissionDto
 * @Author maojianyun
 * @Date 2019/12/23 9:03
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ToString
@ApiModel(value = "PermissionDto", description = "权限dto")
public class PermissionDto implements Serializable {

    private static final long serialVersionUID = 4585365561393244796L;

    @ApiModelProperty(name = "id", value = "id")
    private long id;

    @ApiModelProperty(name = "name", value = "权限名称")
    private String name;

    @ApiModelProperty(name = "parentName", value = "父权限名称")
    private String parentName;

    @ApiModelProperty(name = "description", value = "权限描述")
    private String description;

    @ApiModelProperty(name = "url", value = "权限访问路径")
    private String url;

    @ApiModelProperty(name = "perms", value = "权限标识")
    private String perms;

    @ApiModelProperty(name = "parentId", value = "父级权限id")
    private long parentId;

    @ApiModelProperty(name = "type", value = "类型   0：目录   1：菜单   2：按钮")
    private String type;

    @ApiModelProperty(name = "orderNum", value = "排序")
    private Integer orderNum;

    @ApiModelProperty(name = "icon", value = "图标")
    private String icon;

    @ApiModelProperty(name = "status", value = "状态：1有效；2删除")
    private int status;
}
