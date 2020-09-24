package com.sjht.cloud.entrance.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sjht.cloud.framework.common.entity.BaseEntity;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * ***************************************************
 * @ClassName EntranceHouseEntity
 * @Description 入学房产信息实体
 * @Author maojianyun
 * @Date 2020/3/2 19:07
 * @Version V1.0
 * ****************************************************
 **/
@TableName("sjht_entrance_house_info")
@Data
@ToString
public class EntranceHouseEntity extends BaseEntity {

    private long appliId;

    private long communityId;

    private long streetId;

    private String address;

    private Date inTime;

    private int type;

    private int status;

    private int isMulti;

    private String feedback;
}
