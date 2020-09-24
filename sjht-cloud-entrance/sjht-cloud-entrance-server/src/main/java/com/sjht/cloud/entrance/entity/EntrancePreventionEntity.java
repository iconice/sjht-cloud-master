package com.sjht.cloud.entrance.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sjht.cloud.framework.common.entity.BaseEntity;
import lombok.Data;

/**
 * ***************************************************
 *
 * @ClassName EntrancePreventionEntity
 * @Description 接种信息实体
 * @Author maojianyun
 * @Date 2020/3/18 16:01
 * @Version V1.0
 * ****************************************************
 **/
@Data
@TableName("sjht_entrance_prevention")
public class EntrancePreventionEntity extends BaseEntity {

    private long appliId;

    private int status;

    private String feedback;
}
