package com.sjht.cloud.framework.common.constant;

/**
 * ***************************************************
 * @ClassName CommonCanstant
 * @Description 常量
 * @Author maojianyun
 * @Date 2019/12/2 9:18
 * @Version V1.0
 * ****************************************************
 **/
public interface CommonCanstant {

    interface AuthCode{
        static final int CODE_500  = 500;
        static final int CODE_401  = 401;
        static final String ACCESS_TOKEN  = "access_token";
        static final String REFRESH_TOKEN  = "refresh_token";
        static final String JTI  = "jti";
    }

    interface cmmonCode{
        static final int delete_0  = 0;
        static final int delete_1  = 1;
    }
}
