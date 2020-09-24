package com.sjht.cloud.ucenter.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sjht.cloud.ucenter.api.dto.PageUserListDto;
import com.sjht.cloud.ucenter.api.vo.AuthUserVo;
import com.sjht.cloud.ucenter.api.vo.UserVo;
import com.sjht.cloud.ucenter.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 ************************************************
 *@ClassName SysUserMapper
 *@Description 系统用户数据层
 *@Author maojianyun
 *@Date 2019/9/5 9:43
 *@Version V1.0
 *************************************************
 **/
@Component
@Mapper
public interface SysUserMapper extends BaseMapper<SysUserEntity>{

    /**
     * 根据用户名得到用户信息
     * @param userName
     * @return
     */
    AuthUserVo getUserInfoByUserNmae(@Param("userName") String userName);

    /**
     * 根据用户名得到用户信息-简要信息-不含密码等
     * @param userName
     * @return
     */
    AuthUserVo getUserInfoByUserNameSimple(@Param("userName") String userName);


    /**
     * 根据用户id查询用户权限
    * @param userId
     * @return
     */
    List<String> getPermsByUserId(@Param("userId") String userId);

    /**
     * 分页得到用户列表
     * @param page
     * @param listDto
     * @return
     */
    List<UserVo> pageUserList(Page<UserVo> page, @Param("params")PageUserListDto listDto);

    @Select("        SELECT u.user_name AS userName,\n" +
            "            u.password,"+
            "            u.name,\n" +
            "            u.email,\n" +
            "            u.tell, u.salt,\n" +
            "            u.user_type AS userType,\n" +
            "            u.status,\n" +
            "            u.file_id AS fileId"+
            "        FROM sys_user u where user_name=#{userName}")
    SysUserEntity getByName(@Param("userName") String userName);

    @Update("        UPDATE sys_user SET password=#{password} where user_name=#{userName}")
    int updateByName(@Param("userName") String userName, @Param("password") String password);
}
