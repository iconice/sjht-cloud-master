package com.sjht.cloud.entrance.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sjht.cloud.framework.common.entity.BaseEntity;
import lombok.Data;
import lombok.ToString;
/*
 * @Author zhangchi
 * @Description  转学学生实体
 * @Date 11:12 2020/4/13
 * @Param
 * @return
 **/
@TableName("sjht_entrance_student")
@Data
@ToString
public class EntranceStudentEntity extends BaseEntity {

    /**
     * 申请ID
     */
    private Long appliId;

    /**
    * 转出学校名
    */
    private String outSchoolName;
    /**
    * 学籍号
    */
    private Long studentNum;
    /**
    * 1健康 2残疾
    */
    private int isHealth;
    /**
    * 1有 2无
    */
    private int isHealthForm;

    private int status;

    private String feedback;//审核信息反馈
    


}