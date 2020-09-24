package com.sjht.cloud.ucenter.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * ***************************************************
 *
 * @ClassName ChangePasswordDto
 * @Description
 * @Author 张弛
 * @Date 2020/4/3 16:02
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ToString
@ApiModel(value = "ChangePasswordDto", description = "改密Dto")
public class ChangePasswordDto implements Serializable {

    private static final long serialVersionUID = -4817146702771670070L;

    @ApiModelProperty(name = "id", value = "用户id")
    private String id;
    @ApiModelProperty(name = "oldpw", value = "旧密码")
    private String oldpw;
    @ApiModelProperty(name = "newpw", value = "新密码")
    private String newpw;
}
