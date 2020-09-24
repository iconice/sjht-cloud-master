package com.sjht.cloud.ucenter.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName RegisteredDto
 * @Description 用户注册
 * @Author maojianyun
 * @Date 2020/3/11 14:12
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ToString
@ApiModel(value = "RegisteredDto", description = "用户注册dto,type=1系统用户 2=客户端用户")
public class RegisteredDto implements Serializable {

    @ApiModelProperty(name = "tell", value = "电话号码", required = true)
    private String tell;

    @ApiModelProperty(name = "password", value = "密码", required = true)
    private String password;

    @ApiModelProperty(name = "type", value = "用户类型：1-系统用户，2-客户端用户", required = true)
    private int type;
}
