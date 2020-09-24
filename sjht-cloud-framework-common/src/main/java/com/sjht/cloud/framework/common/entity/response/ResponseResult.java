package com.sjht.cloud.framework.common.entity.response;

import com.sjht.cloud.framework.common.enums.CommonCode;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName ResponseResult
 * @Description 没带数据的放回
 * @Author maojianyun
 * @Date 2019/12/12 14:00
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ToString
public class ResponseResult implements  Response, Serializable {

    private static final long serialVersionUID = 3425879481796497714L;
    /**
     * 操作是否成功
     */
    boolean success = SUCCESS;

    /**
     * 操作代码
     */
    int code = SUCCESS_CODE;

    /**
     *  提示信息
     */
    String message;

    public ResponseResult(){

    }

    /**
     * 自定义返回
     * @param resultCode
     */
    public ResponseResult(ResultCode resultCode){
        this.success = resultCode.success();
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    /**
     * 成功返回
     * @return
     */
    public static ResponseResult SUCCESS(){
        return new ResponseResult(CommonCode.SUCCESS);
    }

    /**
     * 失败返回
     * @return
     */
    public static ResponseResult FAIL(){
        return new ResponseResult(CommonCode.FAIL);
    }

    /**
     * (只返回信息)自定义返回
     * @param
     */
    public ResponseResult(String message){
        this.message =message;
    }
    /**
     * 失败返回
     * @return
     */
    public static ResponseResult FAIL(String message){
        return new ResponseResult(message);
    }
}
