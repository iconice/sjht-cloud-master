package com.sjht.cloud.entrance.controller;

import com.sjht.cloud.entrance.api.dto.CreatePreventionDto;
import com.sjht.cloud.entrance.api.dto.EntranceStudentDto;
import com.sjht.cloud.entrance.api.dto.UpdateEntranceStudentDto;
import com.sjht.cloud.entrance.api.vo.EntrancePreventionVO;
import com.sjht.cloud.entrance.service.EntranceStudentService;
import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import com.sjht.cloud.framework.common.entity.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ***************************************************
 *
 * @ClassName EntranceStudentController
 * @Description 转学儿童申请管理
 * @Author 张弛
 * @Date 2020/4/14 15:37
 * @Version V1.0
 * ****************************************************
 **/
@RestController
@RequestMapping("entranceStudent")
@Api(value = "转学儿童申请管理", tags = {"转学儿童申请管理"})
public class EntranceStudentController {
    @Autowired
    private  EntranceStudentService entranceStudentService;

    @PostMapping("apply")
    @ApiOperation(value = "申请转学")
    public ResponseResult apply(@RequestBody EntranceStudentDto entranceStudentDto){
        return entranceStudentService.apply(entranceStudentDto);
    }

    @PostMapping("updateApply")
    @ApiOperation(value = "更改申请转学")
    public ResponseResult updateApply(@RequestBody UpdateEntranceStudentDto updateEntranceStudentDto){
        return entranceStudentService.updateApply(updateEntranceStudentDto);
    }

    @PostMapping("queryApply")
    @ApiOperation(value = "查询申请转学信息")
    public ResponseDataResult queryApply(String studentId){
        return entranceStudentService.queryApply(studentId);
    }

    @PostMapping("modifyStatus")
    @ApiOperation(value = "更改转学状态")
    public ResponseResult modifyStatus(String id,int status){
        return entranceStudentService.modifyStatus(id,status);
    }

    @PostMapping("queryStatus/{appliId}")
    @ApiOperation(value = "查看转学申请状态")
    public ResponseDataResult queryStatus(@PathVariable String appliId){
        return entranceStudentService.queryStatus(appliId);
    }


}
