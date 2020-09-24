package com.sjht.cloud.ucenter.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sjht.cloud.framework.common.entity.BaseEntity;
import lombok.Data;
import lombok.ToString;

/**
 ************************************************
 * @ClassName SysRoleEntity
 * @Description 系统用户实体类
 * @Author maojianyun
 * @Date 2019/9/5 9:43
 * @Version V1.0
 *************************************************
 **/
@Data
@ToString
@TableName("sys_user")
public class SysUserEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String userName;

	private String password;

	private String name;

	private String email;

	private String tell;

	private String salt;

	private String userType;

	private  int status;

	private String createBy;

	private String fileId;

}
