package com.sjht.cloud.ucenter.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName AssignRoleVo
 * @Description AssignRoleVo
 * @Author maojianyun
 * @Date 2019/12/24 10:13
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ToString
@ApiModel(value = "AssignRoleVo", description = "给用户分配角色vo")
public class AssignRoleVo implements Serializable {

    private static final long serialVersionUID = -7828819529626042859L;

    @ApiModelProperty(name = "id", value = "角色id")
    private String id;

    @ApiModelProperty(name = "name", value = "角色名称")
    private String name;

    @ApiModelProperty(name = "description", value = "角色描述")
    private String description;

    @ApiModelProperty(name = "checked", value = "是否已经分配：false-未分配、true已经分配")
    private Boolean checked=false;
}
