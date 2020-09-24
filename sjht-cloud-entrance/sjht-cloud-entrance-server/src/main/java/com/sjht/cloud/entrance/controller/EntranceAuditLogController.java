package com.sjht.cloud.entrance.controller;

import com.sjht.cloud.entrance.api.dto.AuditAppDetailDto;
import com.sjht.cloud.entrance.api.dto.CreateAuditLogDto;
import com.sjht.cloud.entrance.api.dto.GetAppDetailDto;
import com.sjht.cloud.entrance.api.dto.GetAppListDto;
import com.sjht.cloud.entrance.service.EntranceAuditLogService;
import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import com.sjht.cloud.framework.common.entity.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ***************************************************
 * @ClassName EntranceAuditLogController
 * @Description 审核日志api
 * @Author maojianyun
 * @Date 2020/3/9 13:28
 * @Version V1.0
 * ****************************************************
 **/
@RestController
@RequestMapping("entranceAuditLog")
@Api(value = "入学申请管理-审核接口", tags = {"入学/转学申请管理-申请审核接口"})
public class EntranceAuditLogController {

    @Autowired
    private EntranceAuditLogService auditLogService;

    @PostMapping("getAppList")
    @ApiOperation(value = "入学申请-获取列表-带分页")
    public ResponseDataResult getAppList(@RequestBody GetAppListDto getAppListDto){
        return auditLogService.getAppList(getAppListDto);
    }

    @PostMapping("getAppDetail")
    @ApiOperation(value = "入学申请-根据申请编号获取请求明细")
    public ResponseDataResult getAppDetail(@RequestBody GetAppDetailDto getAppDetailDto){
        return auditLogService.getAppDetail(getAppDetailDto);
    }

    @PostMapping("auditApp")
    @ApiOperation(value = "入学申请-对申请进行审批")
    public ResponseResult auditApp(@RequestBody AuditAppDetailDto auditAppDetailDto){
        return auditLogService.auditAppDetail(auditAppDetailDto);
    }

//小程序用    就是用户点击确定申请后，使审核的初始草稿状态变为审核状态     可能需要优化下
    @PostMapping("updateAuditLogStatus/{id}/{status}")
    @ApiOperation(value = "入学申请-修改审核日志状态")
    public ResponseResult updateAuditLogStatus(@PathVariable String id, @PathVariable int status){
        return auditLogService.updateAuditLogStatus(id, status);
    }
// 小程序用   得到标题  例如 xxxx的入学申请    xxxxx的转学申请
    @PostMapping("getAuditLogContent/{appliId}/{status}")
    @ApiOperation(value = "入学申请-得到申请的审核内容")
    public ResponseDataResult getAuditLogContent(@PathVariable String appliId, @PathVariable int status){
        return auditLogService.getAuditLogContent(appliId, status);
    }
//  小程序用   根据申请id 获取当前审核状态
    @PostMapping("getAuditStatus/{id}")
    @ApiOperation(value = "入学申请-得到审核的状态")
    public ResponseDataResult getAuditStatus(@PathVariable String id){
        return auditLogService.getAuditStatus(id);
    }
}
