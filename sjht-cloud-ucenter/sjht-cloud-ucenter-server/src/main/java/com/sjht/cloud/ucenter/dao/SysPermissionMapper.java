package com.sjht.cloud.ucenter.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sjht.cloud.ucenter.api.dto.CreatePermissionDto;
import com.sjht.cloud.ucenter.api.vo.CatalogListVo;
import com.sjht.cloud.ucenter.api.vo.PermissionVo;
import com.sjht.cloud.ucenter.entity.SysPermissionEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ***************************************************
 *
 * @ClassName SysMenuMapper
 * @Description 描述
 * @Author maojianyun
 * @Date 2019/12/23 8:57
 * @Version V1.0
 * ****************************************************
 **/
@Component
@Mapper
public interface SysPermissionMapper extends BaseMapper<SysPermissionEntity> {

    /**
     * 得到所有目录权限列表、不包含按钮
     * @return List<CatalogListVo>
     */
    List<CatalogListVo> getCatalogPermissionList();

    /**
     * 得到所有的权限
     * @return List<PermissionDto>
     */
    List<PermissionVo>  getPermissionList();

    /**
     * 得到用户的权限列表
     * @param userId 用户id
     * @return List<CreatePermissionDto>
     */
    List<CreatePermissionDto> getPermissionListById(@Param("userId") long userId);

    /**
     * 得到用户权限信息
     * @param permissionId
     * @return PermissionDto
     */
    PermissionVo getPermissionInfo(@Param("permissionId") long permissionId);
}
