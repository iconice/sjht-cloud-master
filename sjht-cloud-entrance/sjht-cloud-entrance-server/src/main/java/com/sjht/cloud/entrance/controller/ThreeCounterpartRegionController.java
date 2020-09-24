package com.sjht.cloud.entrance.controller;

import com.sjht.cloud.entrance.api.dto.CreateRegionAddDto;
import com.sjht.cloud.entrance.api.dto.UpdateRegionAddDto;
import com.sjht.cloud.entrance.service.ThreeCounterpartRegionService;
import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import com.sjht.cloud.framework.common.entity.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ***************************************************
 * @ClassName ThreeCounterpartRegionController
 * @Description 三对口地址接口
 * @Author maojianyun
 * @Date 2020/1/8 10:53
 * @Version V1.0
 * ****************************************************
 **/
@RestController
@RequestMapping("/region")
@Api(value = "入学申请管理-小区、地址接口", tags = {"入学申请管理-小区、地址接口"})
public class ThreeCounterpartRegionController {

    @Autowired
    private ThreeCounterpartRegionService counterpartRegionService;

    @PostMapping("/createRegionAdd")
    @ApiOperation(value = "三对口区域管理-创建三对口区域地址")
    public ResponseResult createRegionAdd(@RequestBody CreateRegionAddDto regionAddDto) {
        return counterpartRegionService.createRegionAdd(regionAddDto);
    }

    @GetMapping("/deleteRegionAdd/{id}")
    @ApiOperation(value = "三对口区域管理-删除三对口区域地址")
    public ResponseResult deleteRegionAdd(@PathVariable("id") long id) {
        return counterpartRegionService.deleteRegionAdd(id);
    }

    @GetMapping("/getRegionAddList")
    @ApiOperation(value = "三对口区域管理-得到列表")
    public ResponseDataResult getRegionAddList(){
        return counterpartRegionService.getRegionAddList();
    }

    @PostMapping("/updateRegionAdd")
    @ApiOperation(value = "三对口区域管理-编辑提交")
    public ResponseResult updateRegionAdd(@RequestBody UpdateRegionAddDto regionAddDto){
        return counterpartRegionService.updateRegionAdd(regionAddDto);
    }
}
