package com.sjht.cloud.framework.common.entity.response;

import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName ResponseUtil
 * @Description 响应工具类
 * @Author maojianyun
 * @Date 2019/12/12 14:22
 * @Version V1.0
 * ****************************************************
 **/
public class ResponseUtil implements Serializable {

    private static final long serialVersionUID = -4426075050034566453L;

    /**
     * 不带数据的返回
     * @return
     */
    public static ResponseResult SUCCESS(){
        return ResponseResult.SUCCESS();
    }

    /**
     * 失败返回
     * @return
     */
    public static ResponseResult FAIL(){
        return ResponseResult.FAIL();
    }

    /**
     * 返回错误自定义
     * @param resultCode
     * @return
     */
    public static ResponseResult FAIL(ResultCode resultCode){
        return new ResponseResult(resultCode);
    }
    /**
     * 带数据成功返回
     * @param data
     * @return
     */
    public static ResponseDataResult SUCCESS(Object data){
        return new ResponseDataResult<>().SUCCESS(data);
    }

    public static ResponseDataResult SUCCESS(ResultCode resultCode, Object data){
        return new ResponseDataResult<>().SUCCESS(resultCode);
    }
    /*
     * @Author zhangchi
     * @Description 失败返回
     * @Date 10:34 2020/4/8
     * @Param
     * @return
     **/
    public static ResponseDataResult FAILDATA(ResultCode resultCode){
        return new ResponseDataResult(resultCode);
    }
}
