package com.sjht.cloud.framework.common.entity.response;

import com.sjht.cloud.framework.common.enums.CommonCode;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName ResponseDataResult
 * @Description 带数数据的放回
 * @Author maojianyun
 * @Date 2019/12/12 14:00
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ToString
public class ResponseDataResult<T> implements  Response, Serializable {

    private static final long serialVersionUID = -1652230124177016557L;
    /**
     * 操作是否成功
     */
    boolean success = SUCCESS;
    boolean fail =FAIL;

    /**
     * 操作代码
     */
    int code = SUCCESS_CODE;

    /**
     *  提示信息
     */
    String message;

    T data;

    public ResponseDataResult(){

    }

    /**
     * 自定义返回
     * @param resultCode
     */
    public ResponseDataResult(ResultCode resultCode, T obj){
        this.success = resultCode.success();
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.data = obj;
    }

    /**
     * 自定义返回
     * @param resultCode
     */
    public ResponseDataResult(ResultCode resultCode){
        this.success = resultCode.success();
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    /**
     * 成功返回
     * @return
     */
    public  ResponseDataResult SUCCESS(T obj){
        return new ResponseDataResult(CommonCode.SUCCESS, obj);
    }
    }
