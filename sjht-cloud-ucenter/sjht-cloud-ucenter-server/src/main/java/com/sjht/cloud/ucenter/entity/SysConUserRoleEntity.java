package com.sjht.cloud.ucenter.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sjht.cloud.framework.common.entity.BaseEntity;
import lombok.Data;

/**
 ************************************************
 *@ClassName SysConUserRoleEntity
 *@Description 角色和用户关联实体类
 *@Author maojianyun
 *@Date 2019/9/5 9:43
 *@Version V1.0
 *************************************************
 **/
@Data
@TableName("sys_con_user_role")
public class SysConUserRoleEntity extends BaseEntity {

	private static final long serialVersionUID = -7648931839935590493L;

	private long roleId;

    private long userId;
}
