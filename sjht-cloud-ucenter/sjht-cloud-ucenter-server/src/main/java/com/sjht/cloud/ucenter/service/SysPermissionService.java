package com.sjht.cloud.ucenter.service;

import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import com.sjht.cloud.framework.common.entity.response.ResponseResult;
import com.sjht.cloud.ucenter.api.dto.CreatePermissionDto;
import com.sjht.cloud.ucenter.api.dto.PermissionDto;
import com.sjht.cloud.ucenter.api.vo.CatalogListVo;
import com.sjht.cloud.ucenter.api.vo.PermissionVo;

import java.util.List;

/**
 * ***************************************************
 *
 * @ClassName SysPermissionService
 * @Description 菜单接口
 * @Author maojianyun
 * @Date 2019/12/23 8:56
 * @Version V1.0
 * ****************************************************
 **/
public interface SysPermissionService {

    /**
     * 创建菜单
     *
     * @param permissionDto
     * @return ResponseResult
     */
    ResponseResult createPermission(CreatePermissionDto permissionDto);

    /**
     * 得到所有目录权限列表、不包含按钮
     *
     * @return ResponseDataResult<List<CreatePermissionDto>>
     */
    ResponseDataResult<List<CatalogListVo>> getCatalogPermissionList();

    /**
     * 得到所有的权限列表
     * @return ResponseDataResult<List<PermissionDto>>
     */
    ResponseDataResult getPermissionList();

    /**
     * 得到用户的权限列表
     *
     * @param userId 用户id
     * @return ResponseDataResult<List<CreatePermissionDto>>
     */
    ResponseDataResult<List<CreatePermissionDto>> getPermissionListById(long userId);

    /**
     * 得到权限信息
     * @param permissionId
     * @return
     */
    ResponseDataResult<PermissionVo> getPermissionInfo(long permissionId);

    /**
     * 权限编辑提交
     * @param permissionDto
     * @return
     */
    ResponseResult permissionEditSubmit(PermissionDto permissionDto);

    /**
     * 删除权限
     * @param id
     * @return
     */
    ResponseResult deletePermission(long id);
}
