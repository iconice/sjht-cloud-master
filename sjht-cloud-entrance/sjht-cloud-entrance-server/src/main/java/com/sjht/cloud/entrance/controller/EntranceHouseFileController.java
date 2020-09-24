//package com.sjht.cloud.entrance.controller;
//
//import com.sjht.cloud.entrance.api.dto.CreateEntranceHouseFileDto;
//import com.sjht.cloud.entrance.service.EntranceHouseFileService;
//import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
//import com.sjht.cloud.framework.common.entity.response.ResponseResult;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * ***************************************************
// * @ClassName EntranceHouseFileController
// * @Description 房产文件
// * @Author maojianyun
// * @Date 2020/3/5 16:38
// * @Version V1.0
// * ****************************************************
// **/
//@RestController
//@RequestMapping("entranceHouseFile")
//@Api(value = "入学申请管理-房产文件", tags = {"入学申请管理-房产文件"})
//public class EntranceHouseFileController {
//
//    @Autowired
//    private EntranceHouseFileService houseFileService;
//
//    /**
//     * 删除文件
//     * @param id
//     * @return
//     */
//    @PostMapping("deleteHouseFile")
//    @ApiOperation(value = "房产文件-删除房产文件")
//    public ResponseResult deleteHouseFile(String id){
//        return houseFileService.deleteHouseFile(id);
//    }
//
//    /**
//     * 创建文件
//     * @param houseFileDto
//     * @return
//     */
//    @PostMapping("createHouseFile")
//    @ApiOperation(value = "房产文件-添加房产文件")
//    public ResponseDataResult createHouseFile(@RequestBody CreateEntranceHouseFileDto houseFileDto){
//        return houseFileService.createHouseFile(houseFileDto);
//    }
//}
