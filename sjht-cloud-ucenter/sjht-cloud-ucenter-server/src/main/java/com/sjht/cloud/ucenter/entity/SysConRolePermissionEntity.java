package com.sjht.cloud.ucenter.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sjht.cloud.framework.common.entity.BaseEntity;
import lombok.Data;

/**
 ************************************************
 * @ClassName SysConRolePermissionEntity
 * @Description 角色和资源关联实体类
 * @Author maojianyun
 * @Date 2019/9/5 9:43
 * @Version V1.0
 *************************************************
 **/
@Data
@TableName("sys_con_role_permission")
public class SysConRolePermissionEntity extends BaseEntity {

	private static final long serialVersionUID = -7414604368062436400L;

	private long roleId;

	private long permissionId;
}
