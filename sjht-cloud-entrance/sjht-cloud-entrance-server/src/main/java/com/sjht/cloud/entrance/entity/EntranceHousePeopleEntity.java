package com.sjht.cloud.entrance.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sjht.cloud.framework.common.entity.BaseEntity;
import lombok.Data;
import lombok.ToString;

/**
 * ***************************************************
 * @ClassName EntranceHousePeopleEntity
 * @Description 房产所属权人
 * @Author maojianyun
 * @Date 2020/3/2 19:10
 * @Version V1.0
 * ****************************************************
 **/
@TableName("sjht_entrance_house_people_info")
@Data
@ToString
public class EntranceHousePeopleEntity extends BaseEntity {

    private long houseId;

    private String name;

    private String relation;
}
