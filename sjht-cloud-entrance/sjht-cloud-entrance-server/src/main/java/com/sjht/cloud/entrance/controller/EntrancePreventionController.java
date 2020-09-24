package com.sjht.cloud.entrance.controller;

import com.sjht.cloud.entrance.api.dto.CreatePreventionDto;
import com.sjht.cloud.entrance.api.dto.UpdatePreventionDto;
import com.sjht.cloud.entrance.api.vo.EntrancePreventionVO;
import com.sjht.cloud.entrance.service.EntrancePreventionService;
import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import com.sjht.cloud.framework.common.entity.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ***************************************************
 * @ClassName EntrancePreventionController
 * @Description 描述
 * @Author maojianyun
 * @Date 2020/3/18 16:11
 * @Version V1.0
 * ****************************************************
 **/
@RestController
@RequestMapping("entrancePrevention")
@Api(value = "入学申请管理-查验证明息接口", tags = {"入学申请管理-查验证明息接口"})
public class EntrancePreventionController {

    @Autowired
    private EntrancePreventionService preventionService;

    @PostMapping("createPrevention")
    @ApiOperation(value = "接种查验证明-添加接种查验证明")
    public ResponseResult createPrevention(@RequestBody CreatePreventionDto preventionDto){
        return preventionService.createPrevention(preventionDto);
    }

    @PostMapping("getEntrancePreventionInfo/{appliId}")
    @ApiOperation(value = "接种查验证明-得到接种查验证明")
    public ResponseDataResult<EntrancePreventionVO> getEntrancePreventionInfo(@PathVariable String appliId){
        return preventionService.getEntrancePreventionInfo(appliId);
    }

    @PostMapping("updateEntrancePrevention")
    @ApiOperation(value = "接种查验证明-更新接种查验证明")
    public ResponseResult updateEntrancePrevention(@RequestBody UpdatePreventionDto preventionDto){
        return preventionService.updatePrevention(preventionDto);
    }

    @PostMapping("deleteEntrancePreventionFile/{id}")
    @ApiOperation(value = "接种查验证明-删除接种证明文件")
    public ResponseResult deleteEntrancePreventionFile(@PathVariable String id){
        return preventionService.deleteEntrancePreventionFile(id);
    }

    @PostMapping("getEntrancePreventionStatus/{appliId}")
    @ApiOperation(value = "入学申请-得到房产信息审核的状态")
    public ResponseDataResult getEntrancePreventionStatus(@PathVariable String appliId){
        return preventionService.getEntrancePreventionStatus(appliId);
    }

    @PostMapping("updateStatus/{id}/{status}")
    @ApiOperation(value = "入学申请-修改房产信息审核的状态")
    public ResponseResult updateStatus(@PathVariable long id, @PathVariable int status){
        return preventionService.updateStatus(id, status);
    }
}
