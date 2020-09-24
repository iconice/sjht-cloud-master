package com.sjht.cloud.ucenter.service;

import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import com.sjht.cloud.framework.common.entity.response.ResponseResult;
import com.sjht.cloud.ucenter.api.dto.*;

/**
 * ***************************************************
 * @ClassName SysRoleService
 * @Description 角色接口
 * @Author maojianyun
 * @Date 2019/12/23 11:10
 * @Version V1.0
 * ****************************************************
 **/
public interface SysRoleService {

    /**
     * 创建校色
     * @param roleDto
     * @return ResponseResult
     */
    ResponseResult createRole(CreateRoleDto roleDto);

    /**
     * 角色分页查询
     * @param listDto
     * @return
     */
    ResponseDataResult pageRoleList(PageRoleListDto listDto);

    /**
     * 得到角色信息
     * @param id
     * @return ResponseDataResult
     */
    ResponseDataResult getRoleInfo(long id);

    /**
     * 提交编辑角色
     * @param infoDto
     * @return
     */
    ResponseResult editeRoleSubmit(RoleInfoDto infoDto);

    /**
     * 为角色分配权限
     * @param roleId
     * @return
     */
    ResponseDataResult  assignPermissionForRole(long roleId);

    /**
     * 提交分配的权限
     * @param permissionDto
     * @return ResponseResult
     */
    public ResponseResult assignPermissionForRoleSubmit(AssignPermissionDto permissionDto);

    /**
     * 得到所有的角色
     * @return
     */
    ResponseDataResult getRoleList(long userId);

    /**
     * 分配角色提交
     * @param assignRoleDto
     * @return
     */
    ResponseResult assignRoleSubmit(AssignRoleDto assignRoleDto);

    /**
     * 删除角色
     * @param id
     * @return
     */
    ResponseResult deleteRole(long id);
}
