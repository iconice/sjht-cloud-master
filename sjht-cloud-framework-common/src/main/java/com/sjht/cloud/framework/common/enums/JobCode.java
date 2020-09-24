package com.sjht.cloud.framework.common.enums;

import com.google.common.collect.ImmutableMap;
import com.sjht.cloud.framework.common.entity.response.ResultCode;
import lombok.ToString;


/**
 * ***************************************************
 * @ClassName JobCode
 * @Description 系统文件code
 * @Author maojianyun
 * @Date 2019/12/1 23:12
 * @Version V1.0
 * ****************************************************
 **/
@ToString
public enum JobCode implements ResultCode {

    NOT_MISFIRE_POLICY(false,40001,"任务没有策略！"),
    CREATE_JOB_FALE(false,40002,"创建任务失败！"),
    CHECKCRONEXPRESSION_JOB_FALE(false,40003,"校验表达式失败！"),
    CHECKCRONEXPRESSION_JOB_SUCCESS(true,40004,"校验表达式成功！");

    //操作代码
    boolean success;

    //操作代码
    int code;
    //提示信息
    String message;
    private JobCode(boolean success, int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }
    private static final ImmutableMap<Integer, JobCode> CACHE;

    static {
        final ImmutableMap.Builder<Integer, JobCode> builder = ImmutableMap.builder();
        for (JobCode commonCode : values()) {
            builder.put(commonCode.code(), commonCode);
        }
        CACHE = builder.build();
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
