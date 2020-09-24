package com.sjht.cloud.framework.common.enums;

import com.sjht.cloud.framework.common.entity.response.ResultCode;
import lombok.ToString;

/**
 * ***************************************************
 * @ClassName AuthCode
 * @Description 认证代码返回
 * @Author maojianyun
 * @Date 2019/12/1 23:12
 * @Version V1.0
 * ****************************************************
 **/
@ToString
public enum AuthCode implements ResultCode {

    AUTH_USERNAME_NONE(false,20001, "请输入账号！"),
    AUTH_PASSWORD_NONE(false,20002, "请输入密码！"),
    AUTH_VERIFYCODE_NONE(false,20003, "请输入验证码！"),
    AUTH_ACCOUNT_NOTEXISTS(false,20004, "账号不存在！"),
    AUTH_CREDENTIAL_ERROR(false,20005, "密码错误！"),
    AUTH_LOGIN_ERROR(false,20006, "登陆过程出现异常请尝试重新操作！"),
    AUTH_LOGIN_APPLYTOKEN_FAIL(false,20007, "申请令牌失败！"),
    AUTH_LOGIN_TOKEN_SAVEFAIL(false,20008, "存储令牌失败！");

    boolean success;

    int code;

    String message;

    private AuthCode(boolean success, int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean success() {
        return success;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }}


