package com.sjht.cloud.ucenter.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName UserDto
 * @Description 描述
 * @Author maojianyun
 * @Date 2019/12/26 13:29
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ToString
@ApiModel(value = "UserDto", description = "用户dto")
public class UserDto implements Serializable {

    private static final long serialVersionUID = -7308052080429495179L;

    @ApiModelProperty(name = "id", value = "用户id")
    private long id;

    @ApiModelProperty(name = "userName", value = "用户名")
    private String userName;

    @ApiModelProperty(name = "name", value = "真实姓名")
    private String name;

    @ApiModelProperty(name = "email", value = "邮箱")
    private String email;

    @ApiModelProperty(name = "tell", value = "电话号码")
    private String tell;

    @ApiModelProperty(name = "status", value = "用户状态：1-正常 2-禁用")
    private int status;

    @ApiModelProperty(name = "fileId", value = "头像id")
    private String fileId;
}
