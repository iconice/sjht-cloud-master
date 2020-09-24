package com.sjht.cloud.ucenter.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sjht.cloud.framework.common.entity.BaseEntity;

/**
 ************************************************
 * @ClassName SysRoleEntity
 * @Description 角色实体类
 * @Author maojianyun
 * @Date 2019/9/5 9:43
 * @Version V1.0
 *************************************************
 **/
@TableName("sys_role")
public class SysRoleEntity extends BaseEntity {

	private static final long serialVersionUID = 5121337792369190517L;

	/**
	 * 角色名称
	 */
	private String name;

	/**
	 * 角色描述
	 */
	private String description;

	/**
	 * 状态：1有效; 0无效
	 */
	private Integer status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
