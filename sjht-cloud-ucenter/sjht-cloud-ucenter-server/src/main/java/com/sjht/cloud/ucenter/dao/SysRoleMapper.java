package com.sjht.cloud.ucenter.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sjht.cloud.ucenter.api.dto.PageRoleListDto;
import com.sjht.cloud.ucenter.api.vo.AssignRoleVo;
import com.sjht.cloud.ucenter.api.vo.RoleVo;
import com.sjht.cloud.ucenter.entity.SysRoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ***************************************************
 * @ClassName SysRoleMapper
 * @Description SysRoleMapper
 * @Author maojianyun
 * @Date 2019/12/23 11:11
 * @Version V1.0
 * ****************************************************
 **/
@Component
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRoleEntity> {

    /**
     * 分页查询角色
     * @param page
     * @param listDto
     * @return
     */
    List<RoleVo> pageRoleList(Page<RoleVo> page, @Param("params")PageRoleListDto listDto);

    /**
     * 得到角色信息
     * @param roleId
     * @return RoleInfoDto
     */
    RoleVo getRoleInfo(@Param("roleId")long roleId);

    /**
     * 得到角色的权限
     * @param roleId
     * @return
     */
    List<String> getRolePermission(@Param("roleId")long roleId);

    /**
     * 得到所有的角色
     * @return
     */
    List<AssignRoleVo> getRoleList();

    /**
     * 得到用户的叫色id
     * @param userId
     * @return
     */
    List<String> getRoleIds(@Param("userId")long userId);
}
