package com.sjht.cloud.entrance.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sjht.cloud.framework.common.entity.BaseEntity;
import lombok.Data;
import lombok.ToString;

/**
 * ***************************************************
 * @ClassName EntranceHouseFileEntity
 * @Description 房产文件实体
 * @Author maojianyun
 * @Date 2020/3/2 19:04
 * @Version V1.0
 * ****************************************************
 **/
@TableName("sjht_entrance_house_info_file")
@Data
@ToString
public class EntranceHouseFileEntity extends BaseEntity {

    private long houseId;

    private String fileId;

    private int type;

    private int subType;

    private int childType;

    private int sortNum;
}
