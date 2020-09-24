package com.sjht.cloud.ucenter.api.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
@ApiModel(value = "AuthUserVo", description = "用户认证VO")
public class AuthUserVo implements Serializable{

	private static final long serialVersionUID = -3617785159511297937L;
	
	private String id;

    private String name;

    private String roleName;

    private String userName;

    private String email;

    private String tell;

    private String headUrl;

    private String userType;

    private String status;

    private String orgId;

    private String password;

    private List<String> perms;
}
