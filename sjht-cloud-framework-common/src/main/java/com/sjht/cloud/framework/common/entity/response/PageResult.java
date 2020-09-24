package com.sjht.cloud.framework.common.entity.response;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * ***************************************************
 * @ClassName PageResult
 * @Description 分页返回
 * @Author maojianyun
 * @Date 2019/12/12 14:07
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ToString
public class PageResult<T> {

    /**
     * 数据列表
     */
    private List<T> list;
    /**
     * 数据总数
     */
    private long total;
}
