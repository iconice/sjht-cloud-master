package com.sjht.cloud.entrance.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sjht.cloud.framework.common.entity.BaseEntity;
import lombok.Data;
import lombok.ToString;

/**
 * ***************************************************
 *
 * @ClassName ParentsInfoEntity
 * @Description 家长信息实体类
 * @Author 张弛
 * @Date 2020/4/1 9:28
 * @Version V1.0
 * ****************************************************
 **/
@TableName("sjht_entrance_parents_info")
@Data
@ToString
public class ParentsInfoEntity extends BaseEntity {
    private Long userId;//用户id
    private String name;//关系人姓名
    private String workUnits;//工作单位
    private String dep;//所属部门
    private String workUnitsTell;//工作单位电话
    private String tell;//个人电话
    private int relations;//关系

}
