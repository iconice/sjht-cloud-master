package com.sjht.cloud.entrance.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sjht.cloud.framework.common.entity.BaseEntity;
import lombok.Data;
import lombok.ToString;

/**
 * ***************************************************
 * @ClassName EntranceAuditLogEntity
 * @Description 审核日志实体
 * @Author maojianyun
 * @Date 2020/3/9 13:23
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ToString
@TableName("sjht_entrance_audit_log")
public class EntranceAuditLogEntity extends BaseEntity {

   public long appliId;

   public String content;

   private int status;
}
