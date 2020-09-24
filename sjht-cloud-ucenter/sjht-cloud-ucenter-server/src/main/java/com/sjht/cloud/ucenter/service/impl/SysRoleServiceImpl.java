package com.sjht.cloud.ucenter.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sjht.cloud.framework.common.entity.response.PageResult;
import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import com.sjht.cloud.framework.common.entity.response.ResponseResult;
import com.sjht.cloud.framework.common.entity.response.ResponseUtil;
import com.sjht.cloud.framework.common.enums.CommonCode;
import com.sjht.cloud.framework.common.exception.ExceptionCast;
import com.sjht.cloud.framework.common.utils.PageUtil;
import com.sjht.cloud.ucenter.api.dto.*;
import com.sjht.cloud.ucenter.api.vo.AssignPermissionVo;
import com.sjht.cloud.ucenter.api.vo.AssignRoleVo;
import com.sjht.cloud.ucenter.api.vo.PermissionVo;
import com.sjht.cloud.ucenter.api.vo.RoleVo;
import com.sjht.cloud.ucenter.constant.UcenterConstant;
import com.sjht.cloud.ucenter.dao.SysConRolePermissionMapper;
import com.sjht.cloud.ucenter.dao.SysConUserRoleMapper;
import com.sjht.cloud.ucenter.dao.SysPermissionMapper;
import com.sjht.cloud.ucenter.dao.SysRoleMapper;
import com.sjht.cloud.ucenter.entity.SysConRolePermissionEntity;
import com.sjht.cloud.ucenter.entity.SysConUserRoleEntity;
import com.sjht.cloud.ucenter.entity.SysRoleEntity;
import com.sjht.cloud.ucenter.service.SysRoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * ***************************************************
 * @ClassName SysRoleServiceImpl
 * @Description SysRoleServiceImpl
 * @Author maojianyun
 * @Date 2019/12/23 11:11
 * @Version V1.0
 * ****************************************************
 **/
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysPermissionMapper permissionMapper;

    @Autowired
    private SysConRolePermissionMapper sysConRolePermissionMapper;

    @Autowired
    private SysConUserRoleMapper sysConUserRoleMapper;

    @Override
    public ResponseResult createRole(CreateRoleDto roleDto) {
        SysRoleEntity entity = new SysRoleEntity();
        entity.setId(IdWorker.getId());
        entity.setName(roleDto.getName());
        entity.setDescription(roleDto.getDescription());
        entity.setStatus(UcenterConstant.PermissionCode.STATUS_1);
        entity.setDeletec(UcenterConstant.cmmonCode.delete_0);
        int n = sysRoleMapper.insert(entity);
        if (n > 0) {
            return ResponseUtil.SUCCESS();
        }
        return ResponseUtil.FAIL();
    }

    @Override
    public ResponseDataResult pageRoleList(PageRoleListDto listDto) {
        if(listDto.getPageSize() <= 0 || listDto.getOffset() < 0){
            ExceptionCast.cast(CommonCode.INVALID_PARAM);
        }
        PageResult<RoleVo> result = new PageResult<>();
        Integer pageNo = PageUtil.getPageNo(listDto.getPageSize(), listDto.getOffset());
        Integer pageSize = listDto.getPageSize();
        Page<RoleVo> page = new Page<>(pageNo, pageSize);
        List<RoleVo> list = sysRoleMapper.pageRoleList(page, listDto);
        result.setList(list);
        result.setTotal(page.getTotal());
        return ResponseUtil.SUCCESS(result);
    }

    @Override
    public ResponseDataResult getRoleInfo(long id) {
        RoleVo roleVo = sysRoleMapper.getRoleInfo(id);
        return ResponseUtil.SUCCESS(roleVo);
    }

    @Override
    public ResponseResult editeRoleSubmit(RoleInfoDto infoDto) {
        SysRoleEntity entity = new SysRoleEntity();
        entity.setId(infoDto.getId());
        entity.setStatus(infoDto.getStatus());
        entity.setDescription(infoDto.getDescription());
        entity.setName(infoDto.getName());
        entity.setUpdateTime(new Date());
        int n = sysRoleMapper.updateById(entity);
        if (n > 0) {
            return ResponseUtil.SUCCESS();
        }
        return ResponseUtil.FAIL();
    }

    @Override
    public ResponseDataResult assignPermissionForRole(long roleId) {
        List<AssignPermissionVo> list = new ArrayList<>();
        // 得到角色已经授权的权限
        List<String> rolePermission = sysRoleMapper.getRolePermission(roleId);
        // 得到多有权限
        List<PermissionVo>  permissionVos = permissionMapper.getPermissionList();
        if (permissionVos  != null && !permissionVos.isEmpty()) {
            permissionVos.forEach(e ->{
                if (UcenterConstant.PermissionCode.STATUS_2 != e.getStatus()) {
                    AssignPermissionVo permissionVo = new AssignPermissionVo();
                    permissionVo.setId(e.getId());
                    permissionVo.setParentId(e.getParentId());
                    permissionVo.setName(e.getName());
                    if (rolePermission.contains(e.getId())) {
                        permissionVo.setChecked(true);
                    }
                    list.add(permissionVo);
                }
            });
        }
        return ResponseUtil.SUCCESS(list);
    }

    @Transactional
    @Override
    public ResponseResult assignPermissionForRoleSubmit(AssignPermissionDto permissionDto) {
        if(permissionDto.getRoleId() <= 0 || permissionDto.getPermissionIdStr() == null){
            ExceptionCast.cast(CommonCode.INVALID_PARAM);
        }
        List<SysConRolePermissionEntity> entitys = new ArrayList<>();
        long roleId = permissionDto.getRoleId();
        String[] permissionIds = permissionDto.getPermissionIdStr().split(",");
        List<String> permissionIdsList = Arrays.asList(permissionIds);
        // 删除以前的权限
        QueryWrapper<SysConRolePermissionEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("role_id", permissionDto.getRoleId());
        sysConRolePermissionMapper.delete(wrapper);
        // 加入新的权限
        permissionIdsList.forEach(e -> {
            SysConRolePermissionEntity entity = new SysConRolePermissionEntity();
            entity.setId(IdWorker.getId());
            entity.setRoleId(permissionDto.getRoleId());
            entity.setPermissionId(Long.valueOf(e));
            entitys.add(entity);
        });
        int n = sysConRolePermissionMapper.batchInsert(entitys);
        if (n > 0) {
            return ResponseUtil.SUCCESS();
        }
        return ResponseUtil.FAIL();
    }

    @Override
    public ResponseDataResult getRoleList(long userId) {
        // 得到角色列表
        List<AssignRoleVo> roleVos = sysRoleMapper.getRoleList();
        // 得到已经分配的权限
        List<String> hasRoles = sysRoleMapper.getRoleIds(userId);
        if (hasRoles != null && !hasRoles.isEmpty()) {
            roleVos.forEach(e -> {
                if (hasRoles.contains(e.getId())) {
                    e.setChecked(true);
                }
            });
        }
        return ResponseUtil.SUCCESS(roleVos);
    }

    @Override
    public ResponseResult assignRoleSubmit(AssignRoleDto assignRoleDto) {
        if (assignRoleDto.getUserId() <= 0 || StringUtils.isBlank(assignRoleDto.getRoleIdStr())) {
            ExceptionCast.cast(CommonCode.INVALID_PARAM);
        }
        List<SysConUserRoleEntity> entitys = new ArrayList<>();
        long roleId = assignRoleDto.getUserId();
        String[] roleIds = assignRoleDto.getRoleIdStr().split(",");
        List<String> roleIdsList = Arrays.asList(roleIds);
        // 删除以前的权限
        QueryWrapper<SysConUserRoleEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", assignRoleDto.getUserId());
        sysConUserRoleMapper.delete(wrapper);
        // 加入新的权限
        roleIdsList.forEach(e -> {
            SysConUserRoleEntity entity = new SysConUserRoleEntity();
            entity.setId(IdWorker.getId());
            entity.setUserId(assignRoleDto.getUserId());
            entity.setRoleId(Long.valueOf(e));
            entitys.add(entity);
        });
        int n = sysConUserRoleMapper.batchInsert(entitys);
        if (n > 0) {
            return ResponseUtil.SUCCESS();
        }
        return ResponseUtil.FAIL();
    }

    @Override
    public ResponseResult deleteRole(long id) {

        QueryWrapper<SysConUserRoleEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("role_id", id);
        int n = sysConUserRoleMapper.selectCount(wrapper);
        if (n > 0) {
            ExceptionCast.cast(CommonCode.CANT_NOT_DELETE);
        } else {
            sysRoleMapper.deleteById(id);
        }
        return ResponseUtil.SUCCESS();
    }
}
