package com.sjht.cloud.ucenter.controller;

import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import com.sjht.cloud.framework.common.entity.response.ResponseResult;
import com.sjht.cloud.ucenter.api.dto.CreatePermissionDto;
import com.sjht.cloud.ucenter.api.dto.PermissionDto;
import com.sjht.cloud.ucenter.api.vo.CatalogListVo;
import com.sjht.cloud.ucenter.api.vo.PermissionVo;
import com.sjht.cloud.ucenter.service.SysPermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ***************************************************
 * @ClassName SysPermissionController
 * @Description 权限接口
 * @Author maojianyun
 * @Date 2019/12/23 8:54
 * c **/
@RestController
@RequestMapping("/permission")
@Api(value = "权限管理-权限接口", tags = {"权限管理-权限接口"})
public class SysPermissionController {

    @Autowired
    private SysPermissionService sysMenuService;

    @PostMapping("/createPermission")
    @ApiOperation(value = "权限管理-创建菜单")
    public ResponseResult createPermission(@RequestBody CreatePermissionDto permissionDto){
        return sysMenuService.createPermission(permissionDto);
    }

    /**
     * 得到所有目录权限列表、不包含按钮
     * @return ResponseDataResult<List<CatalogListVo>>
     */
    @PostMapping("/getCatalogPermissionList")
    @ApiOperation(value = "权限管理-得到所有目录权限、不包含按钮")
    public ResponseDataResult<List<CatalogListVo>> getCatalogPermissionList(){
        return sysMenuService.getCatalogPermissionList();
    }

    /**
     * 得到所有目录权限列表、不包含按钮
     * @return ResponseDataResult<List<CatalogListVo>>
     */
    @PostMapping("/getPermissionList")
    @ApiOperation(value = "权限管理-得到所有目录权限")
    public ResponseDataResult<List<PermissionVo>> getPermissionList(){
        return sysMenuService.getPermissionList();
    }

    /**
     * 得到用户的权限列表
     * @param userId 用户id
     * @return ResponseDataResult<List<CreatePermissionDto>>
     */
    @GetMapping("/getPermissionListById/{userId}")
    @ApiOperation(value = "权限管理-得到用户的权限")
    public ResponseDataResult<List<CreatePermissionDto>> getPermissionListById(@PathVariable("userId") long userId){
        return sysMenuService.getPermissionListById(userId);
    }

    @PostMapping("/getPermissionInfo/{id}")
    @ApiOperation(value = "权限管理-得到权限详情")
    public ResponseDataResult<PermissionVo> getPermissionInfo(@PathVariable("id")long id){
        return sysMenuService.getPermissionInfo(id);
    }

    @PostMapping("/permissionEditSubmit")
    @ApiOperation(value = "权限管理-权限编辑提交")
    public ResponseResult permissionEditSubmit(@RequestBody PermissionDto permissionDto){
        return sysMenuService.permissionEditSubmit(permissionDto);
    }

    @GetMapping("/deletePermission/{id}")
    @ApiOperation(value = "权限管理-删除权限")
    public ResponseResult deletePermission(@PathVariable("id")long id){
        return sysMenuService.deletePermission(id);
    }
}
