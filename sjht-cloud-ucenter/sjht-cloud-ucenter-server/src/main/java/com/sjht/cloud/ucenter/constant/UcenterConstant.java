package com.sjht.cloud.ucenter.constant;

import com.sjht.cloud.framework.common.constant.CommonCanstant;

/**
 * ***************************************************
 * @ClassName UcenterConstant
 * @Description 描述
 * @Author maojianyun
 * @Date 2019/12/23 10:03
 * @Version V1.0
 * ****************************************************
 **/
public interface UcenterConstant extends CommonCanstant {

   interface PermissionCode {
      static final int STATUS_1  = 1; // 有效
      static final int STATUS_2  = 2; // 无效
      static final int PERMISSION_CATALOG  = 0; // 目录
      static final int PERMISSION_MENU  = 1; // 菜单
      static final int PERMISSION_BUTTON  = 2; // 按钮
      public static String TOP_MENU_ID         = "0";
      public static String TOP_MENU_NAME       = "顶层菜单";
   }

   interface UserCode {
      static final int STATUS_1  = 1; // 有效
      static final int STATUS_2  = 2; // 无效
      static final String DEFALT_PASSWD = "sjht123456";
   }
}
