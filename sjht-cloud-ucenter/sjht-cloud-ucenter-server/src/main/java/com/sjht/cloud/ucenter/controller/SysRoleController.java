package com.sjht.cloud.ucenter.controller;

import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import com.sjht.cloud.framework.common.entity.response.ResponseResult;
import com.sjht.cloud.ucenter.api.dto.*;
import com.sjht.cloud.ucenter.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ***************************************************
 * @ClassName SysRoleController
 * @Description 角色接口
 * @Author maojianyun
 * @Date 2019/12/23 11:07
 * @Version V1.0
 * ****************************************************
 **/
@RestController
@RequestMapping("/role")
@Api(value = "角色管理-角色接口", tags = {"角色管理-角色接口"})
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 创建角色
     * @param roleDto
     * @return ResponseResult
     */
    @PostMapping("/createRole")
    @ApiOperation(value = "角色管理-创建角色")
    ResponseResult createRole(@RequestBody CreateRoleDto roleDto){
        return  sysRoleService.createRole(roleDto);
    }

    /**
     * 分页查询角色
     * @param listDto
     * @return
     */
    @PostMapping("/pageRoleList")
    @ApiOperation(value = "角色管理-分页查询角色")
    public ResponseDataResult pageRoleList(@RequestBody PageRoleListDto listDto){
        return sysRoleService.pageRoleList(listDto);
    }

    /**
     * 得到角色信息
     * @param id
     * @return
     */
    @GetMapping("/getRoleInfo/{id}")
    @ApiOperation(value = "角色管理-得到角色信息")
    public ResponseDataResult getRoleInfo(@PathVariable("id") long id){
        return sysRoleService.getRoleInfo(id);
    }


    @PostMapping("/editeRoleSubmit")
    @ApiOperation(value = "角色管理-提交编辑角色")
    ResponseResult editeRoleSubmit(@RequestBody RoleInfoDto infoDto){
        return sysRoleService.editeRoleSubmit(infoDto);
    }

    @GetMapping("/assignPermissionForRole/{roleId}")
    @ApiOperation(value = "角色管理-为角色分配权限")
    ResponseDataResult  assignPermissionForRole(@PathVariable("roleId") long roleId){
        return sysRoleService.assignPermissionForRole(roleId);
    }

    @PostMapping("/assignPermissionForRoleSubmit")
    @ApiOperation(value = "角色管理-提交分配的权限")
    public ResponseResult assignPermissionForRoleSubmit(@RequestBody AssignPermissionDto permissionDto){
        // 需要清空权限、后面做
        return sysRoleService.assignPermissionForRoleSubmit(permissionDto);
    }

    @GetMapping("/assignRoleList/{userId}")
    @ApiOperation(value = "角色管理-分配角色列表")
    ResponseDataResult assignRoleList(@PathVariable("userId") long userId){
        return sysRoleService.getRoleList(userId);
    }

    @PostMapping("/assignRoleSubmit")
    @ApiOperation(value = "角色管理-分配角色提交")
    ResponseResult assignRoleSubmit(@RequestBody AssignRoleDto assignRoleDto){
        return sysRoleService.assignRoleSubmit(assignRoleDto);
    }

    @PostMapping("/deleteRole/{id}")
    @ApiOperation(value = "角色管理-删除角色")
    ResponseResult deleteRole(@PathVariable("id") long id){
        return sysRoleService.deleteRole(id);
    }
}
