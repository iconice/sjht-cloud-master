package com.sjht.cloud.ucenter.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sjht.cloud.ucenter.entity.SysConRolePermissionEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ***************************************************
 * @ClassName SysConRolePermissionMapper
 * @Description 角色权限关联
 * @Author maojianyun
 * @Date 2019/12/23 14:52
 * @Version V1.0
 * ****************************************************
 **/
@Component
@Mapper
public interface SysConRolePermissionMapper extends BaseMapper<SysConRolePermissionEntity> {
    /**
     * 批量插入
     * @param entitys
     * @return
     */
    int batchInsert(@Param("params") List<SysConRolePermissionEntity> entitys);
}
