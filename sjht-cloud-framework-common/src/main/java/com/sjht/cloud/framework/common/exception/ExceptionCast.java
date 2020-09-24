package com.sjht.cloud.framework.common.exception;

import com.sjht.cloud.framework.common.entity.response.ResultCode;

/**
 * ***************************************************
 * @ClassName ExceptionCast
 * @Description 抛出异常
 * @Author maojianyun
 * @Date 2019/12/5 16:01
 * @Version V1.0
 * ****************************************************
 **/
public class ExceptionCast {

    public static void cast(ResultCode resultCode){
        throw new CustomException(resultCode);
    }
}
