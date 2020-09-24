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
public enum UcenterCode implements ResultCode {


    FAIL(false, 40001, "不能删除");

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

    private UcenterCode(boolean success, int code, String message) {
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