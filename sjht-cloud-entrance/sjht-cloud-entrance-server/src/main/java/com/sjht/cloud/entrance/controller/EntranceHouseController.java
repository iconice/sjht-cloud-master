package com.sjht.cloud.entrance.controller;

import com.sjht.cloud.entrance.api.dto.CreateEntranceHouseDto;
import com.sjht.cloud.entrance.api.dto.UpdateEntranceHouseDto;
import com.sjht.cloud.entrance.api.vo.EntranceHouseVo;
import com.sjht.cloud.entrance.service.EntranceHouseFileService;
import com.sjht.cloud.entrance.service.EntranceHousePeopleService;
import com.sjht.cloud.entrance.service.EntranceHouseService;
import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import com.sjht.cloud.framework.common.entity.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ***************************************************
 * @ClassName EntranceHouseController
 * @Description 描述
 * @Author maojianyun
 * @Date 2020/3/5 17:17
 * @Version V1.0
 * ****************************************************
 **/
@RestController
@RequestMapping("entranceHouse")
@Api(value = "入学申请管理-房产信息接口", tags = {"入学申请管理-房产信息接口"})
public class EntranceHouseController {

    @Autowired
    private EntranceHouseService houseService;

    @Autowired
    private EntranceHouseFileService houseFileService;

    @Autowired
    private EntranceHousePeopleService housePeopleService;

    /**
     * 创建房产
     * @param entranceHouseDto
     * @return
     */
    @PostMapping("createEntranceHouse")
    @ApiOperation(value = "房产信息-创建房产")
    public ResponseResult createEntranceHouse(@RequestBody CreateEntranceHouseDto entranceHouseDto){
        return houseService.createEntranceHouse(entranceHouseDto);
    }

    /**
     * 创建房产
     * @param entranceHouseDto
     * @return
     */
    @PostMapping("updateEntranceHouse")
    @ApiOperation(value = "房产信息-修改房产")
    public ResponseResult updateEntranceHouse(@RequestBody UpdateEntranceHouseDto entranceHouseDto){
        return houseService.updateEntranceHouse(entranceHouseDto);
    }

    /**
     * 删除文件
     * @param id
     * @return
     */
    @PostMapping("deleteHouseFile")
    @ApiOperation(value = "房产文件-删除房产文件")
    public ResponseResult deleteHouseFile(String id){
        return houseFileService.deleteHouseFile(id);
    }

    /**
     * 得到房产id
     * @param appliId
     * @return
     */
    @PostMapping("getEntranceHouseInfo")
    @ApiOperation(value = "房产信息-得到房产信息")
    public ResponseDataResult<EntranceHouseVo> getEntranceHouseInfo(@RequestParam String appliId){
       return houseService.getEntranceHouseInfo(appliId);
    }

    @PostMapping("modifyEntranceHouseStatus/{id}/{status}")
    @ApiOperation(value = "房产信息-审核房产信息的状态修改")
    public ResponseResult modifyEntranceHouseStatus(@PathVariable String id, @PathVariable int status){
        return houseService.modifyEntranceHouseStatus(id, status);
    }

    @PostMapping("getEntranceHouseStatus/{appliId}")
    @ApiOperation(value = "入学申请-得到房产信息审核的状态")
    public ResponseDataResult getEntranceHouseStatus(@PathVariable String appliId){
        return houseService.getEntranceHouseStatus(appliId);
    }

    @PostMapping("deleteEntranceHousePeople")
    @ApiOperation(value = "房产权利人-删除权利人")
    public ResponseResult deleteEntranceHousePeople(@RequestParam String id){
        return housePeopleService.deleteEntranceHousePeople(id);
    }
}
