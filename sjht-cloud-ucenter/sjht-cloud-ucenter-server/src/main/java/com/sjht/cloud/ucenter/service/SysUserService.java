package com.sjht.cloud.ucenter.service;

import com.baomidou.mybatisplus.core.injector.methods.Update;
import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import com.sjht.cloud.framework.common.entity.response.ResponseResult;
import com.sjht.cloud.ucenter.api.dto.*;

/**
 ************************************************
 *@ClassName SysUserService
 *@Description 系统用户服务接口
 *@Author maojianyun
 *@Date 2019/9/5 9:43
 *@Version V1.0
 *************************************************
 **/
public interface SysUserService {

	/**
	 * 根据用户名得到用户信息
	 * @param userName
	 * @return
	 */
	ResponseDataResult getUserInfoByUserNmae(String userName);

	/**
	 * 根据用户名得到用户信息-简要信息
	 * @param userName
	 * @return
	 */
	ResponseDataResult getUserInfoByUserNameSimple(String userName);

	/**
	 * 分页获取用户列表
	 * @param listDto
	 * @return
	 */
	ResponseDataResult pageUserList(PageUserListDto listDto);

	/**
	 * 创建用户
	 * @param userDto
	 * @return
	 */
	ResponseResult createUser(UserDto userDto);

	/**
	 * 用户编辑提交
	 * @param userDto
	 * @return
	 */
	ResponseResult userEditeSubmit(UserDto userDto);

	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	ResponseResult deleteUser(long id);

	/**
			* 用户注册
	 * @param registeredDto
	 * @return
			 */
	ResponseResult registered(RegisteredDto registeredDto);

	/*
	 * @Author zhangchi
	 * @Description 改密
	 * @Date 16:14 2020/4/3
	 * @Param [changePasswordDto]
	 * @return com.sjht.cloud.framework.common.entity.response.ResponseResult
	 **/
	ResponseResult changePassword(ChangePasswordDto changePasswordDto);

	/*
	 * @Author zhangchi
	 * @Description 修改用户头像
	 * @Date 11:29 2020/4/29
	 * @Param
	 * @return
	 **/
//	ResponseResult updateUserHead(UpdateUserHeadDto updateUserHeadDto);
	ResponseResult updateUserHead(String id,String fileId);
}
