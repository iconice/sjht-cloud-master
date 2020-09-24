package com.sjht.cloud.entrance.controller;

import com.sjht.cloud.entrance.api.dto.CreateEntraceAppliactionDto;
import com.sjht.cloud.entrance.api.dto.GetEntraceAppliactionListDto;
import com.sjht.cloud.entrance.service.EntranceApplicationService;
import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import com.sjht.cloud.framework.common.entity.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ***************************************************
 * @ClassName EntranceApplicationController
 * @Description 入学申请api
 * @Author maojianyun
 * @Date 2020/3/3 19:30
 * @Version V1.0
 * ****************************************************
 **/
@RestController
@RequestMapping("entranceApplication")
@Api(value = "入学申请管理-申请接口", tags = {"入学申请管理-申请接口"})
public class EntranceApplicationController {

    @Autowired
    private EntranceApplicationService applicationService;

    @PostMapping("createEntranceApplication")
    @ApiOperation(value = "入学申请-创建、在点击入学申请时使用")
    public ResponseDataResult createEntranceApplication(@RequestBody CreateEntraceAppliactionDto createEntraceAppliactionDto){
        return applicationService.createEntranceApplication(createEntraceAppliactionDto);
    }

    @PostMapping("getEntranceApplicationList")
    @ApiOperation(value = "入学申请-得到入学申请列表")
    public ResponseDataResult getEntranceApplicationList(@RequestBody GetEntraceAppliactionListDto entraceAppliactionListDto){
        return applicationService.getEntranceApplicationList(entraceAppliactionListDto);
    }

    @PostMapping("deleteEntranceApplication/{id}")
    @ApiOperation(value = "入学申请-删除申请-只能删除草稿的")
    public ResponseResult deleteEntranceApplication(@PathVariable String id){
        return applicationService.deleteEntranceApplication(id);
    }

    @PostMapping("updateTitle/{id}/{title}")
    @ApiOperation(value = "入学申请-修改申请标题")
    public ResponseResult updateTitle(@PathVariable String id, @PathVariable String title){
        return applicationService.updateTitle(id, title);
    }

    @PostMapping("updateStatus/{id}/{satus}")
    @ApiOperation(value = "入学申请-提交审核")
    public ResponseResult updateStatus(@PathVariable String id, @PathVariable int satus){
        return applicationService.updateStatus(id, satus);
    }

    @PostMapping("getApplicationStatus/{id}")
    @ApiOperation(value = "入学申请-得到申请的状态")
    public ResponseDataResult getApplicationStatus(@PathVariable String id){
        return applicationService.getApplicationStatus(id);
    }
}
