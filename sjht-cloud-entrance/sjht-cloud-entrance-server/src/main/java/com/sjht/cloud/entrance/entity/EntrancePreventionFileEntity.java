package com.sjht.cloud.entrance.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sjht.cloud.framework.common.entity.BaseEntity;
import lombok.Data;
import lombok.ToString;

/**
 * ***************************************************
 * @ClassName GetEntrancePreventionFileVo
 * @Description 查验证明文件实体
 * @Author maojianyun
 * @Date 2020/3/2 19:12
 * @Version V1.0
 * ****************************************************
 **/
@TableName("sjht_entrance_prevention_file")
@Data
@ToString
public class EntrancePreventionFileEntity extends BaseEntity {

    private long preId;

    private int type;

    private String fileId;

    private int sortNum;
}
