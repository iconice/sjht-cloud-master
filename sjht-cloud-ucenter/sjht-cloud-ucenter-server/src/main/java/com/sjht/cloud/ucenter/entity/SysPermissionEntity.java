package com.sjht.cloud.ucenter.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sjht.cloud.framework.common.entity.BaseEntity;
import lombok.Data;

/**
 ************************************************
 *@ClassName SysPermissionEntity
 *@Description 资源实体类
 *@Author maojianyun
 *@Date 2019/9/5 9:43
 *@Version V1.0
 *************************************************
 **/
@Data
@TableName("sys_permission")
public class SysPermissionEntity extends BaseEntity {

	private static final long serialVersionUID = 2542880163978240770L;

	/**
     * 权限名称
     */
    private String name;

    /**
     * 权限描述
     */
    private String description;

    /**
     * 权限访问路径
     */
    private String url;

    /**
     * 权限标识
     */
    private String perms;

    /**
     * 父级权限id
     */
    private long parentId;

    /**
     * 类型   0：目录   1：菜单   2：按钮
     */
    private int type;

    /**
     * 排序
     */
    private Integer orderNum;

    /**
     * 图标
     */
    private String icon;
    /**
     * 状态：1有效; 0无效
     */
    private Integer status;
}
