package com.sjht.cloud.ucenter.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName PermissionDto
 * @Description 创建菜单dto
 * @Author maojianyun
 * @Date 2019/12/23 9:03
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ToString
@ApiModel(value = "PermissionDto", description = "创建菜单dto")
public class CreatePermissionDto implements Serializable {

    private static final long serialVersionUID = 4585365561393244796L;

    @ApiModelProperty(name = "name", value = "权限名称", example = "系统管理", required = true)
    private String name;

    @ApiModelProperty(name = "description", value = "权限描述", example = "系统管理", required = false)
    private String description;

    @ApiModelProperty(name = "url", value = "权限访问路径", example = "", required = false)
    private String url;

    @ApiModelProperty(name = "perms", value = "权限标识", example = "menu:createMenu", required = false)
    private String perms;

    @ApiModelProperty(name = "parentId", value = "父级权限id", example = "", required = true)
    private long parentId;

    @ApiModelProperty(name = "type", value = "类型   0：目录   1：菜单   2：按钮", example = "1", required = true)
    private int type;

    @ApiModelProperty(name = "orderNum", value = "排序", example = "1", required = false)
    private Integer orderNum;

    @ApiModelProperty(name = "icon", value = "图标", example = "", required = false)
    private String icon;
}
