package com.sjht.cloud.ucenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.sjht.cloud.framework.common.constant.CommonCanstant;
import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import com.sjht.cloud.framework.common.entity.response.ResponseResult;
import com.sjht.cloud.framework.common.entity.response.ResponseUtil;
import com.sjht.cloud.framework.common.enums.CommonCode;
import com.sjht.cloud.framework.common.exception.ExceptionCast;
import com.sjht.cloud.ucenter.api.dto.CreatePermissionDto;
import com.sjht.cloud.ucenter.api.dto.PermissionDto;
import com.sjht.cloud.ucenter.api.vo.CatalogListVo;
import com.sjht.cloud.ucenter.api.vo.PermissionVo;
import com.sjht.cloud.ucenter.constant.UcenterConstant;
import com.sjht.cloud.ucenter.dao.SysConRolePermissionMapper;
import com.sjht.cloud.ucenter.dao.SysPermissionMapper;
import com.sjht.cloud.ucenter.entity.SysConRolePermissionEntity;
import com.sjht.cloud.ucenter.entity.SysPermissionEntity;
import com.sjht.cloud.ucenter.service.SysPermissionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ***************************************************
 * @ClassName SysMenuServiceImpl
 * @Description SysMenuServiceImpl
 * @Author maojianyun
 * @Date 2019/12/23 8:56
 * @Version V1.0
 * ****************************************************
 **/
@Service
public class SysPermissionServiceImpl implements SysPermissionService {

    @Autowired
    private SysPermissionMapper sysMenuMapper;

    @Autowired
    private SysConRolePermissionMapper sysConRolePermissionMapper;

    @Override
    public ResponseResult createPermission(CreatePermissionDto permissionDto) {
        SysPermissionEntity entity = new SysPermissionEntity();
        BeanUtils.copyProperties(permissionDto, entity);
        entity.setStatus(UcenterConstant.PermissionCode.STATUS_1);
        entity.setId(IdWorker.getId());
        entity.setDeletec(UcenterConstant.cmmonCode.delete_0);
        int n = sysMenuMapper.insert(entity);
        if (n > 0) {
            return ResponseUtil.SUCCESS();
        }
        return ResponseUtil.FAIL();
    }

    @Override
    public ResponseDataResult<List<CatalogListVo>> getCatalogPermissionList() {
        List<CatalogListVo> permissionDtos = sysMenuMapper.getCatalogPermissionList();
        return ResponseUtil.SUCCESS(permissionDtos);
    }

    @Override
    public ResponseDataResult<List<PermissionVo>> getPermissionList() {
        List<PermissionVo> permissionDtos = sysMenuMapper.getPermissionList();
        return ResponseUtil.SUCCESS(permissionDtos);
    }

    @Override
    public ResponseDataResult<List<CreatePermissionDto>> getPermissionListById(long userId) {
        List<CreatePermissionDto> permissionDtos = sysMenuMapper.getPermissionListById(userId);
        return ResponseUtil.SUCCESS(permissionDtos);
    }

    @Override
    public ResponseDataResult<PermissionVo> getPermissionInfo(long permissionId) {
        PermissionVo permissionVo = sysMenuMapper.getPermissionInfo(permissionId);
        if(null!=permissionVo){
            if(permissionVo.getParentId().equals(UcenterConstant.PermissionCode.TOP_MENU_ID)){
                permissionVo.setParentName(UcenterConstant.PermissionCode.TOP_MENU_NAME);
            }else{
                PermissionVo parent = sysMenuMapper.getPermissionInfo(Long.valueOf(permissionVo.getParentId()));
                permissionVo.setParentName(parent.getName());
            }
        }
        return ResponseUtil.SUCCESS(permissionVo);
    }

    @Override
    public ResponseResult permissionEditSubmit(PermissionDto permissionDto) {
        SysPermissionEntity entity = new SysPermissionEntity();
        BeanUtils.copyProperties(permissionDto, entity);
        int n = sysMenuMapper.updateById(entity);
        if (n > 0) {
            return ResponseUtil.SUCCESS();
        }
        return ResponseUtil.FAIL();
    }

    @Override
    public ResponseResult deletePermission(long id) {
        // 判断是否具有权限
        QueryWrapper<SysPermissionEntity> wrapper1 = new QueryWrapper<>();
        QueryWrapper<SysConRolePermissionEntity> wrapper2 = new QueryWrapper<>();
        wrapper1.eq("parent_id", id).eq("deletec", CommonCanstant.cmmonCode.delete_0);
        wrapper2.eq("permission_id", id).eq("deletec", CommonCanstant.cmmonCode.delete_0);
        int n1 = sysMenuMapper.selectCount(wrapper1);
        int n2 = sysConRolePermissionMapper.selectCount(wrapper2);
        // 删除权限
        if (n1 > 0 || n2 > 0) {
            ExceptionCast.cast(CommonCode.CANT_NOT_DELETE);
        } else {
            sysMenuMapper.deleteById(id);
        }
        return ResponseUtil.SUCCESS();
    }
}
