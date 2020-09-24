//package com.sjht.cloud.entrance.controller;
//
//import com.sjht.cloud.entrance.api.dto.CreateEntranceHousePeopleDto;
//import com.sjht.cloud.entrance.api.vo.EntranceHousePeopleVo;
//import com.sjht.cloud.entrance.service.EntranceHousePeopleService;
//import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
//import com.sjht.cloud.framework.common.entity.response.ResponseResult;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
///**
// * ***************************************************
// * @ClassName EntranceHousePeopleController
// * @Description 描述
// * @Author maojianyun
// * @Date 2020/3/5 17:09
// * @Version V1.0
// * ****************************************************
// **/
//@RestController
//@RequestMapping("entranceHousePeople")
//@Api(value = "入学申请管理-房产权利人", tags = {"入学申请管理-房产权利人"})
//public class EntranceHousePeopleController {
//
//    @Autowired
//    private EntranceHousePeopleService housePeopleService;
//
//
//    @PostMapping("getEntranceHousePeopleList")
//    @ApiOperation(value = "房产权利人-得到权利人列表")
//    public ResponseDataResult<List<EntranceHousePeopleVo>> getEntranceHousePeopleList(@RequestParam String houseId){
//        return housePeopleService.getEntranceHousePeopleList(houseId);
//    }
//
//    @PostMapping("createEntranceHousePeople")
//    @ApiOperation(value = "房产权利人-添加权利人")
//    public ResponseResult createEntranceHousePeople(@RequestBody CreateEntranceHousePeopleDto peopleDto){
//        return  housePeopleService.createEntranceHousePeople(peopleDto);
//    }
//
//    @PostMapping("deleteEntranceHousePeople")
//    @ApiOperation(value = "房产权利人-删除权利人")
//    public ResponseResult deleteEntranceHousePeople(@RequestParam String id){
//        return housePeopleService.deleteEntranceHousePeople(id);
//    }
//
//}
