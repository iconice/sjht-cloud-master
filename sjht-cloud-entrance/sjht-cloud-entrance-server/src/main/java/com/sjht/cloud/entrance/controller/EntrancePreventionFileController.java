//package com.sjht.cloud.entrance.controller;
//
//import com.sjht.cloud.entrance.api.dto.CreateEntrancePreventionFileDto;
//import com.sjht.cloud.entrance.service.EntrancePreventionFileService;
//import com.sjht.cloud.framework.common.entity.response.Response;
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
// * @ClassName EntrancePreventionFileController
// * @Description 描述
// * @Author maojianyun
// * @Date 2020/3/5 17:21
// * @Version V1.0
// * ****************************************************
// **/
//@RestController
//@RequestMapping("entrancePreventionFile")
//@Api(value = "入学申请管理-查验证明", tags = {"入学申请管理-查验证明"})
//public class EntrancePreventionFileController {
//
//    @Autowired
//    private EntrancePreventionFileService preventionFileService;
//
//    /**
//     * 创建检验、查验文件
//     * @param preventionFileDto
//     * @return
//     */
//    @PostMapping("createEntrancePreventionFile")
//    @ApiOperation(value = "查验证明-创建")
//    public ResponseResult createEntrancePreventionFile(@RequestBody List<CreateEntrancePreventionFileDto> preventionFileDto){
//        return preventionFileService.createEntrancePreventionFile(preventionFileDto);
//    }
//
//    /**
//     * 创建检验、查验文件
//     * @param preventionFileDto
//     * @return
//     */
//    @PostMapping("updateEntrancePreventionFile")
//    @ApiOperation(value = "查验证明-更新查验证明、新增文件是只传新增的照片")
//    public ResponseResult updateEntrancePreventionFile(@RequestBody List<CreateEntrancePreventionFileDto> preventionFileDto){
//        return preventionFileService.createEntrancePreventionFile(preventionFileDto);
//    }
//
//    /**
//     * 得到列表
//     * @param appliId
//     * @return
//     */
//    @PostMapping("getEntrancePreventionFile")
//    @ApiOperation(value = "查验证明-得到")
//    public ResponseDataResult getEntrancePreventionFile(@RequestParam String appliId){
//        return preventionFileService.getEntrancePreventionFile(appliId);
//    }
//
//
//    /**
//     * 删除
//     * @param id
//     * @return
//     */
//    @PostMapping("deleteEntrancePreventionFile")
//    @ApiOperation(value = "查验证明-删除")
//    public Response deleteEntrancePreventionFile(@RequestParam String id){
//        return preventionFileService.deleteEntrancePreventionFile(id);
//    }
//
//    @PostMapping("modifyEntrancePreventionStatus/{id}/{status}")
//    @ApiOperation(value = "查验证明-审核修改状态")
//    public Response modifyEntrancePreventionStatus(@PathVariable String id, @PathVariable int status) {
//        return preventionFileService.modifyEntrancePreventionStatus(id, status);
//    }
//}
