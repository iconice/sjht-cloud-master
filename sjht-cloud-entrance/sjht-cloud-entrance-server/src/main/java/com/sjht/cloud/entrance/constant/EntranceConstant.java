package com.sjht.cloud.entrance.constant;

/**
 * ***************************************************
 * @ClassName EntranceConstant
 * @Description 入学常量类
 * @Author maojianyun
 * @Date 2020/3/3 20:07
 * @Version V1.0
 * ****************************************************
 **/
public interface EntranceConstant {

    /**
     * 入学申请
     */
    public static  abstract class CommonConstant {
        public static final int status_draft = 1;
        public static final int status_to_audit = 2;
        public static final int status_audit_no = 3;
        public static final int status_audit_yes = 4;
        public static final int status_complete = 5;
    }
}
