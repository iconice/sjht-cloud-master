package com.sjht.cloud.entrance.controller;

import com.sjht.cloud.entrance.api.dto.EntranceBaseDto;
import com.sjht.cloud.entrance.api.dto.UpdateEntranceBaseDto;
import com.sjht.cloud.entrance.service.EntranceBaseService;
import com.sjht.cloud.framework.common.entity.response.Response;
import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import com.sjht.cloud.framework.common.entity.response.ResponseResult;
import com.sjht.cloud.framework.common.enums.CommonCode;
import com.sjht.cloud.framework.common.exception.ExceptionCast;
import com.sjht.cloud.framework.common.utils.ValidationUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * ***************************************************
 * @ClassName EntranceBaseController
 * @Description 描述
 * @Author maojianyun
 * @Date 2020/3/4 10:43
 * @Version V1.0
 * ****************************************************
 **/
@RestController
@RequestMapping("entranceApplication")
@Api(value = "入学申请管理-户口基本信息接口", tags = {"入学申请管理-户口基本信息接口"})
public class EntranceBaseController {

    @Autowired
    private EntranceBaseService entranceBaseService;

    /**
     * 创建入学基本信息
     * @param baseDto
     * @return
     */
    @PostMapping("createEntranceBase")
    @ApiOperation(value = "入学申请-创建户口信息")
    public ResponseResult createEntranceBase(@RequestBody @Valid EntranceBaseDto baseDto, BindingResult result){
        if(result.hasErrors()){
            String msg = ValidationUtils.processErrorString(result);
            if (StringUtils.isNotBlank(msg)) {
                ExceptionCast.cast(CommonCode.VALIDATION_FALL);
            }
        }
        return entranceBaseService.createEntranceBase(baseDto);
    }

    /**
     * 查询户口信息
     * @param appliId
     * @return
     */
    @PostMapping("getEntranceBaseInfo")
    @ApiOperation(value = "入学申请-得到户口信息")
    public ResponseDataResult getEntranceBaseInfo(@RequestParam String appliId){
        return entranceBaseService.getEntranceBaseInfo(appliId);
    }

    /**
     * 删除基本信息
     * @param id
     * @return
     */
    @PostMapping("deleteEntranceBase")
    @ApiOperation(value = "入学申请-删除户口信息")
    public ResponseResult deleteEntranceBase(@RequestParam String id){
        return entranceBaseService.deleteEntranceBase(id);
    }

    /**
     * 更新基本信息
     * @param updateEntranceBaseDto
     * @return
     */
    @PostMapping("updateEntranceBaseInfo")
    @ApiOperation(value = "入学申请-修改户口信息")
    public Response updateEntranceBaseInfo(@RequestBody UpdateEntranceBaseDto updateEntranceBaseDto){
        return entranceBaseService.updateEntranceBaseInfo(updateEntranceBaseDto);
    }

    @PostMapping("modifyEntranceBaseStatus/{id}/{status}")
    @ApiOperation(value = "入学申请-审核-修改进户口的状态")
    public ResponseResult modifyEntranceBaseStatus(@PathVariable String id, @PathVariable int status){
        return entranceBaseService.modifyEntranceBaseStatus(id, status);
    }

    @PostMapping("getEntranceBaseStatus/{appliId}")
    @ApiOperation(value = "入学申请-得到户口信息审核的状态")
    public ResponseDataResult getEntranceBaseStatus(@PathVariable String appliId){
        return entranceBaseService.getEntranceBaseStatus(appliId);
    }

}
