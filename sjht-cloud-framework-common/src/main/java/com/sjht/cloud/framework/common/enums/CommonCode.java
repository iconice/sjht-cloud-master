package com.sjht.cloud.framework.common.enums;

import com.sjht.cloud.framework.common.entity.response.ResultCode;
import lombok.ToString;

/**
 * ***************************************************
 * @ClassName CommonCode
 * @Description 通用返回码
 * @Author maojianyun
 * @Date 2019/12/12 13:53
 * @Version V1.0
 * ****************************************************
 **/
@ToString
public enum CommonCode implements ResultCode {

    SUCCESS(true, 10000, "操作成功！"),
    FAIL(false, 10001, "操作失败！"),
    INVALID_PARAM(false, 10002, "非法参数！"),
    UNAUTHENTICATED(false, 10003, "此操作需要登陆系统！"),
    UNAUTHORISE(false, 10004, "权限不足，无权操作！"),
    SERVER_ERROR(false, 10005, "抱歉，系统繁忙，请稍后重试！"),
    REDIS_FALL(false, 10006, "redis罢工了！"),
    CANT_NOT_DELETE(false, 10007, "该数据不能删除"),
    VALIDATION_FALL(false, 10008, "参数校验失败"),
    NULL(false, 10009, "数据为空"),
    TOO_FREQUENT(false, 10010, "请求过于频繁,请5分钟后重试！"),
    ALREADY_REGISTED(false,10011,"该手机号已经注册,请直接登录!"),
    WRONG_PHONE_NUM(false,10011,"手机号位数或格式错误!");

    /**
     * 操作是否成功,true为成功，false操作失败
     *
     * @return
     */
    boolean success;

    /**
     * 操作代码
     *
     * @return
     */
    int code;

    /**
     * 提示信息
     *
     * @return
     */
    String message;

    private CommonCode(boolean success, int code, String message) {
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
}