package com.sjht.cloud.entrance.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sjht.cloud.framework.common.entity.BaseEntity;
import lombok.Data;
import lombok.ToString;

/**
 * ***************************************************
 * @ClassName EntranceApplicationEntity
 * @Description 入学申请实体
 * @Author maojianyun
 * @Date 2020/3/2 18:32
 * @Version V1.0
 * ****************************************************
 **/
@TableName("sjht_entrance_application_info")
@Data
@ToString
public class EntranceApplicationEntity extends BaseEntity {

    private long userId;

    private String title;

    private int status;

    private int type;
}
