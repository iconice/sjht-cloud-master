package com.sjht.cloud.ucenter.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName AssignPermissionDto
 * @Description 分配权限vo
 * @Author maojianyun
 * @Date 2019/12/23 13:49
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ToString
@ApiModel(value = "AssignPermissionDto", description = "分配权限Vo")
public class AssignPermissionVo implements Serializable {

    private static final long serialVersionUID = 7970794012273588784L;

    @ApiModelProperty(name = "id", value = "权限id")
    private String id;

    @ApiModelProperty(name = "name", value = "权限名称")
    private String name;

    @ApiModelProperty(name = "parentId", value = "父权限id")
    private String parentId;

    @ApiModelProperty(name = "open", value = "是否展开：true-展开，false-不展开")
    private Boolean open=true;

    @ApiModelProperty(name = "checked", value = "是否已经分配：false-未分配、true已经分配")
    private Boolean checked=false;
}
