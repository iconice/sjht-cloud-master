package com.sjht.cloud.entrance.controller;

import com.sjht.cloud.entrance.api.dto.UpdateParentInfoListDto;
import com.sjht.cloud.entrance.api.vo.GetParentInformationVo;
import com.sjht.cloud.entrance.service.ParentInformationService;
import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import com.sjht.cloud.framework.common.entity.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ***************************************************
 *
 * @ClassName ParentInformationController
 * @Description 家长信息
 * @Author 张弛
 * @Date 2020/3/25 11:29
 * @Version V1.0
 * ****************************************************
 **/
@RestController
@RequestMapping("parentInformation")
@Api(value = "关联家长信息接口", tags = {"关联家长信息接口"})
public class ParentInformationController {
    @Autowired
    private ParentInformationService parentInfoService;

    /**
     * 创建学生家长信息
     * @param createParentInfoDto
     * @return
     */
//    @PostMapping("createParentInformation")
//    @ApiOperation(value = "家长信息-创建家长信息")
//    public ResponseResult createParentInformation(@RequestBody CreateParentInfoDto createParentInfoDto){
//        return parentInfoService.createParentInformation(createParentInfoDto);
//    }

    /**
     * 创建或者修改学生家长信息
     * @param updateParentInformationDto
     * @return
     */
    @PostMapping("updateParentInformation")
    @ApiOperation(value = "家长信息-新增或者修改家长信息",notes = "创建和更改合并")//修改改为json数组，id为非必填
    public ResponseResult updateParentInformation(@RequestBody UpdateParentInfoListDto updateParentInformationDto){
        return parentInfoService.updateParentInformation(updateParentInformationDto);
    }

    /**
     * 查看学生家长信息
     * @param userId
     * @return
     */
    @PostMapping("getParentInformation")
    @ApiOperation(value = "家长信息-通过userId查看家长信息")
    public ResponseDataResult<GetParentInformationVo> getParentInformation(@RequestParam String userId)
    {
        return parentInfoService.getParentInformation(userId);
    }

    /**
     * 删除学生家长信息
     * @param id
     * @return
     */
    @PostMapping("deleteParentInformation")
    @ApiOperation(value = "家长信息-删除家长信息")
    public ResponseResult deleteParentInformations(@RequestParam String id){

        return parentInfoService.deleteParentInformation(id);
    }
}
