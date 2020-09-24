package com.sjht.cloud.entrance.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sjht.cloud.framework.common.entity.BaseEntity;
import lombok.Data;
import lombok.ToString;
/*
 * @Author zhangchi
 * @Description
 * @Date 11:13 2020/4/13
 * @Param
 * @return
 **/
@Data
@ToString
@TableName("sjht_entrance_student_file")
public class EntranceStudentFileEntity extends BaseEntity {

    private Long studentId;
    /**
    * 1素质报告、成绩单、评语
      2转出学校学籍卡
      3体检报告
    */
    private int type;
    /**
    * 文件ID
    */
    private String fileId;
    }