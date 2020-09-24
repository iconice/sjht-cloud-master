package com.sjht.cloud.framework.common.utils;

public class PageUtil {
    public static Integer getPageNo(Integer limit,Integer offset){
        return offset == 0 ? 1 : offset / limit + 1;
    }
}