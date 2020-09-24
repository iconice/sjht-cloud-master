package com.sjht.cloud.entrance.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sjht.cloud.framework.common.entity.BaseEntity;
import lombok.Data;
import lombok.ToString;

/**
 * ***************************************************
 * @ClassName EntranceBaseEntity
 * @Description 基本信息实体
 * @Author maojianyun
 * @Date 2020/3/2 18:58
 * @Version V1.0
 * ****************************************************
 **/
@TableName("sjht_entrance_base_info")
@Data
@ToString
public class EntranceBaseEntity extends BaseEntity {

    private long appliId;

    private String childName;

    private int childSex;

    private String idCard;

    private String childHeadFileId;

    private String masterName;

    private int relation;

    private String tell;

    private String address;

    private String masterFileId;

    private String masterInfoFileId;

    private String childInfoFileId;

    private String modifyFileId;

    private int status;

    private String feedback;
}
