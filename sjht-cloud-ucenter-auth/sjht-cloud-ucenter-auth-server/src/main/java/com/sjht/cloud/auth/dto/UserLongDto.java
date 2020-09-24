package com.sjht.cloud.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName UserLongDto
 * @Description 用户登录dto
 * @Author maojianyun
 * @Date 2019/12/5 14:18
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ToString
@ApiModel(value = "UserLongDto", description = "用户登录认证DTO")
public class UserLongDto implements Serializable {


    @ApiModelProperty(name = "userName", value = "用户账号", required = true)
    private String userName;

    @ApiModelProperty(name = "password", value = "密码", required = true)
    private String password;

    private String grant_type;

    @ApiModelProperty(name = "verifyCode", value = "验证码", required = false)
    private String verifyCode;
}
