package com.sjht.cloud.framework.common.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * ***************************************************
 * @ClassName HeaderUtil
 * @Description 从head中取值
 * @Author maojianyun
 * @Date 2019/12/10 10:33
 * @Version V1.0
 * ****************************************************
 **/
public class HeaderUtil {

    /**
     * @param response
     * @param name
     * @param value
     */
    public static void addHead(HttpServletResponse response, String name, String value) {
        response.setHeader("Access-Control-Allow-Headers", name + "=" + value);
    }

    /**
     * 根据head名称读取head
     * @param request
     * @param headNames
     * @return String
     */
    public static Map<String, String> readHeads(HttpServletRequest request, String... headNames) {
        Map<String, String> heads = new HashMap<>();
        for (int i = 0; i < headNames.length; i++) {
            heads.put(headNames[i], request.getHeader(headNames[i]));
        }
        return heads;
    }
}
