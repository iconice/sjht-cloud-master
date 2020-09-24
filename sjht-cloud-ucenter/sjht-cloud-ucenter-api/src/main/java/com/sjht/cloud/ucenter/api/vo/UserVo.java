package com.sjht.cloud.ucenter.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * ***************************************************
 * @ClassName UserVo
 * @Description UserVo
 * @Author maojianyun
 * @Date 2019/12/24 11:10
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ToString
@ApiModel(value = "UserVo", description = "用户vo")
public class UserVo implements Serializable {

    private static final long serialVersionUID = 3749959901914770374L;

    @ApiModelProperty(name = "id", value = "用户id")
    private String id;

    @ApiModelProperty(name = "userName", value = "用户名")
    private String userName;

    @ApiModelProperty(name = "name", value = "真实姓名")
    private String name;

    @ApiModelProperty(name = "email", value = "邮箱")
    private String email;

    @ApiModelProperty(name = "tell", value = "电话号码")
    private String tell;

    @ApiModelProperty(name = "userType", value = "用户类型")
    private String userType;

    @ApiModelProperty(name = "status", value = "用户状态")
    private String status;

    @ApiModelProperty(name = "headUrl", value = "用户头像")
    private String headUrl;

    @ApiModelProperty(name = "orgName", value = "用户所属机构名称")
    private String orgName;

    @ApiModelProperty(name = "createTime", value = "创建时间")
    private Date createTime;

    @ApiModelProperty(name = "updateTime", value = "更新时间")
    private Date updateTime;
}
