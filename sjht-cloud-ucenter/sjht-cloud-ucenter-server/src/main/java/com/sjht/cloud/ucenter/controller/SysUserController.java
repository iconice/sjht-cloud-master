package com.sjht.cloud.ucenter.controller;

import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import com.sjht.cloud.framework.common.entity.response.ResponseResult;
import com.sjht.cloud.ucenter.api.dto.*;
import com.sjht.cloud.ucenter.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
@Api(value = "用户管理-用户接口", tags = {"用户管理-用户接口"})
public class SysUserController {
	@Autowired
	private SysUserService sysUserService;

	@GetMapping("getUserInfoByUserNmae")
	@ApiOperation(value = "用户管理-根据用户名得到用户信息")
	public ResponseDataResult getUserInfoByUserNmae(@RequestParam("userName") String userName) {
		return sysUserService.getUserInfoByUserNmae(userName);
	}

	@GetMapping("getUserInfoByUserNameSimple")
	@ApiOperation(value = "用户管理-根据用户id得到用户信息-简要信息")
	public ResponseDataResult getUserInfoByUserNameSimple(@RequestParam("userName") String userName) {
		return sysUserService.getUserInfoByUserNameSimple(userName);
	}

	@PostMapping("pageUserList")
	@ApiOperation(value = "用户管理-分页获取用户列表")
	public ResponseDataResult pageUserList(@RequestBody PageUserListDto listDto) {
		return sysUserService.pageUserList(listDto);
	}

	@PostMapping("createUser")
	@ApiOperation(value = "用户管理-创建用户")
	public ResponseResult createUser(@RequestBody UserDto userDto){
		return sysUserService.createUser(userDto);
	}

	@PostMapping("userEditeSubmit")
	@ApiOperation(value = "用户管理-用户编辑提交")
	public ResponseResult userEditeSubmit(@RequestBody UserDto userDto){
		return sysUserService.userEditeSubmit(userDto);
	}

	@GetMapping("deleteUser/{id}")
	@ApiOperation(value = "用户管理-删除用户")
	public ResponseResult deleteUser(@PathVariable("id") long id){
		return sysUserService.deleteUser(id);
	}

	@PostMapping("registered")
	@ApiOperation(value = "用户管理-手机端用户注册")
	public ResponseResult registered(@RequestBody RegisteredDto registeredDto){
		return sysUserService.registered(registeredDto);
	}

	@PostMapping("changePassword")
	@ApiOperation(value = "用户管理-改密")
	public ResponseResult changePassword(@RequestBody ChangePasswordDto changePasswordDto){
		log.info("进入/ucenter/user/changePassword密码修改");
		return sysUserService.changePassword(changePasswordDto);
	}

//	@PostMapping("updateUserHead")
//	@ApiOperation(value = "用户管理-更新用户头像")
//	public ResponseResult updateUserHead(@RequestBody UpdateUserHeadDto updateUserHeadDto){
//		return sysUserService.updateUserHead(updateUserHeadDto);
//	}

	@GetMapping("updateUserHead")
	@ApiOperation(value = "用户管理-更新用户头像")
	public ResponseResult updateUserHead(@RequestParam("id") String id,@RequestParam("fileId") String fileId){
		return sysUserService.updateUserHead(id,fileId);
	}
}
