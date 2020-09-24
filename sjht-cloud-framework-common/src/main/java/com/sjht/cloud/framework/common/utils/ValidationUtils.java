package com.sjht.cloud.framework.common.utils;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.validation.constraints.NotBlank;

/**
 * ***************************************************
 * @ClassName ValidationUtils
 * @Description 参数校验工具类
 * @Author maojianyun
 * @Date 2020/2/19 10:26
 * @Version V1.0
 * ****************************************************
 **/
public class ValidationUtils {

    /**
     * 得到校验不通过的描述信息
     * @param bindingResult
     * @return String
     */
    public static String processErrorString(BindingResult bindingResult){
        if(!bindingResult.hasErrors()){
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(FieldError fieldError:bindingResult.getFieldErrors()){
            stringBuilder.append(fieldError.getDefaultMessage()+",");
        }
        return stringBuilder.substring(0,stringBuilder.length()-1);
    }
}
