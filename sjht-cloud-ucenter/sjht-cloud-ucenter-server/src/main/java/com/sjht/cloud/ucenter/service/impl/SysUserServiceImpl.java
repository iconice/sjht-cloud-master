package com.sjht.cloud.ucenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sjht.cloud.framework.common.constant.CommonCanstant;
import com.sjht.cloud.framework.common.entity.response.*;
import com.sjht.cloud.framework.common.enums.AuthCode;
import com.sjht.cloud.framework.common.enums.CommonCode;
import com.sjht.cloud.framework.common.exception.ExceptionCast;
import com.sjht.cloud.framework.common.utils.PageUtil;
import com.sjht.cloud.ucenter.api.dto.*;
import com.sjht.cloud.ucenter.api.vo.AuthUserVo;
import com.sjht.cloud.ucenter.api.vo.UserVo;
import com.sjht.cloud.ucenter.constant.UcenterConstant;
import com.sjht.cloud.ucenter.dao.SysConUserRoleMapper;
import com.sjht.cloud.ucenter.dao.SysUserMapper;
import com.sjht.cloud.ucenter.entity.SysConUserRoleEntity;
import com.sjht.cloud.ucenter.entity.SysUserEntity;
import com.sjht.cloud.ucenter.service.SysUserService;
import com.sun.jdi.LongValue;
import com.sun.tools.javac.main.Main;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserMapper sysUserMapper;

	@Autowired
	private SysConUserRoleMapper sysConUserRoleMapper;

	@Override
	public ResponseDataResult getUserInfoByUserNmae(String userName) {
		AuthUserVo userPageVo = sysUserMapper.getUserInfoByUserNmae(userName);
		if (userPageVo == null) {
			ExceptionCast.cast(AuthCode.AUTH_ACCOUNT_NOTEXISTS);
		}
		List<String> perms = sysUserMapper.getPermsByUserId(userPageVo.getId());
		userPageVo.setPerms(perms);
		return ResponseUtil.SUCCESS(userPageVo);
	}

	@Override
	public ResponseDataResult getUserInfoByUserNameSimple(String userName) {
		log.info("userId={}",userName);
		AuthUserVo userPageVo = sysUserMapper.getUserInfoByUserNameSimple(userName);
		if (userPageVo == null) {
			ExceptionCast.cast(AuthCode.AUTH_ACCOUNT_NOTEXISTS);
		}
		List<String> perms = sysUserMapper.getPermsByUserId(userPageVo.getId());
		userPageVo.setPerms(perms);
		return ResponseUtil.SUCCESS(userPageVo);
	}

	@Override
	public ResponseDataResult pageUserList(PageUserListDto listDto) {
		if (listDto.getPageSize() <= 0 || listDto.getOffset() < 0) {
			ExceptionCast.cast(CommonCode.INVALID_PARAM);
		}
		PageResult<UserVo> result = new PageResult<>();
		Integer pageNo = PageUtil.getPageNo(listDto.getPageSize(), listDto.getOffset());
		Integer pageSize = listDto.getPageSize();
		Page<UserVo> page = new Page<>(pageNo, pageSize);
		List<UserVo> list = sysUserMapper.pageUserList(page, listDto);
		result.setList(list);
		result.setTotal(page.getTotal());
		return ResponseUtil.SUCCESS(result);
	}

	@Override
	public ResponseResult createUser(UserDto userDto) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		//使用BCrypt加密，每次加密使用一个随机盐
		String password = bCryptPasswordEncoder.encode(UcenterConstant.UserCode.DEFALT_PASSWD);
		SysUserEntity entity = new SysUserEntity();
		BeanUtils.copyProperties(userDto, entity);
		entity.setId(IdWorker.getId());
		entity.setStatus(UcenterConstant.UserCode.STATUS_1);
		entity.setDeletec(CommonCanstant.cmmonCode.delete_0);
		entity.setPassword(password);
		entity.setStatus(1);
		log.info("状态{}",entity.getStatus());
		System.out.println("状态="+entity.getStatus());
		int n = sysUserMapper.insert(entity);
		//int n = sysUserMapper.updateById(entity);
		if (n > 0) {
			return ResponseUtil.SUCCESS();
		}
		return ResponseUtil.FAIL();
	}

	@Transactional
	@Override
	public ResponseResult userEditeSubmit(UserDto userDto) {
		SysUserEntity entity = new SysUserEntity();
		BeanUtils.copyProperties(userDto, entity);
		entity.setUpdateTime(new Date());
		int n = sysUserMapper.updateById(entity);
		if (n > 0) {
			return ResponseUtil.SUCCESS();
		}
		return ResponseUtil.FAIL();
	}

	@Transactional
	@Override
	public ResponseResult deleteUser(long id) {
		// 删除头像
		// 删除角色
		QueryWrapper<SysConUserRoleEntity> wrapper = new QueryWrapper<>();
		wrapper.eq("user_id", id);
		sysConUserRoleMapper.delete(wrapper);
		// 删除数据
		sysUserMapper.deleteById(id);
		return ResponseUtil.SUCCESS();
	}

	@Override
	public ResponseResult registered(RegisteredDto registeredDto) {
		SysUserEntity userQuery=sysUserMapper.getByName(registeredDto.getTell());
		if(userQuery!=null){//用户已注册
			return new ResponseResult(CommonCode.ALREADY_REGISTED);
		}
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		SysUserEntity entity = new SysUserEntity();
		entity.setId(IdWorker.getId());
		entity.setTell(registeredDto.getTell());
		entity.setUserName(registeredDto.getTell());
		entity.setPassword(bCryptPasswordEncoder.encode(registeredDto.getPassword()));//加密
		entity.setUserType(String.valueOf(registeredDto.getType()));
		entity.setStatus(1);
		int n = sysUserMapper.insert(entity);
		if (n > 0) {
			return ResponseUtil.SUCCESS();
		}
		return ResponseUtil.FAIL();
	}

	@Override
	public ResponseResult changePassword(ChangePasswordDto changePasswordDto) {
		log.info("开始修改密码...{}",changePasswordDto.getId());
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		SysUserEntity entity = new SysUserEntity();
		entity = sysUserMapper.selectById(changePasswordDto.getId());
		log.info("查询用户得到[{}]",entity);
		boolean f = bCryptPasswordEncoder.matches(changePasswordDto.getOldpw(),entity.getPassword()); //对旧密码进行匹配
		if (f == false){
			return ResponseUtil.FAIL(AuthCode.AUTH_CREDENTIAL_ERROR);
		}
		if (f == true){
			entity.setPassword(bCryptPasswordEncoder.encode(changePasswordDto.getNewpw()));
			sysUserMapper.updateById(entity);
		}
		return ResponseUtil.SUCCESS();

/*
 	log.info("开始修改密码...{}",changePasswordDto.getId());
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		SysUserEntity entity = sysUserMapper.getByName(changePasswordDto.getId());
		log.info("查询用户得到[{}]",entity);
		boolean f = bCryptPasswordEncoder.matches(changePasswordDto.getOldpw(),entity.getPassword()); //对旧密码进行匹配
		if (f == false){
			return ResponseUtil.FAIL(AuthCode.AUTH_CREDENTIAL_ERROR);
		}
		if (f == true){
			entity.setPassword(bCryptPasswordEncoder.encode(changePasswordDto.getNewpw()));
			sysUserMapper.updateByName(entity.getUserName(),entity.getPassword());
		}
		return ResponseUtil.SUCCESS();
 **/
	}

	/*
	 * @Author zhangchi
	 * @Description 改头像
	 * @Date 11:31 2020/4/29
	 * @Param [updateUserHeadDto]
	 * @return com.sjht.cloud.framework.common.entity.response.ResponseResult
	 **/
	@Override
	@Transactional
	public ResponseResult updateUserHead(String id,String fileId) {
		SysUserEntity entity = new SysUserEntity();
		entity = sysUserMapper.selectById(id);
		if(null == entity){
			return ResponseUtil.FAIL();
		}
		entity.setFileId(fileId);
		entity.setUpdateTime(new Date());
		int n = sysUserMapper.updateById(entity);
		if (n > 0) {
			return ResponseUtil.SUCCESS();
		}
		return ResponseUtil.FAIL();
	}
}
