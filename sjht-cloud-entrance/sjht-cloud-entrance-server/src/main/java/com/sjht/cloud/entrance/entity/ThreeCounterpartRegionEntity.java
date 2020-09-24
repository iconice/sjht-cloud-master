package com.sjht.cloud.entrance.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sjht.cloud.framework.common.entity.BaseEntity;
import lombok.Data;
import lombok.ToString;

/**
 * ***************************************************
 * @ClassName ThreeCounterpartRegionEntity
 * @Description 学区房区域实体类
 * @Author maojianyun
 * @Date 2020/1/8 10:34
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ToString
@TableName("sys_three_counterpart_region")
public class ThreeCounterpartRegionEntity extends BaseEntity {

    private String name;

    private long parentId;

    private int type;
}
