package com.sjht.cloud.entrance.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * ***************************************************
 *
 * @ClassName UpdateParentInfoListDto
 * @Description 更改或者新增
 * @Author 张弛
 * @Date 2020/4/7 15:24
 * @Version V1.0
 * ****************************************************
 **/
@ApiModel(value = "UpdateParentInfoListDto", description = "更改或新增家长信息dto")
@Data
@ToString
public class UpdateParentInfoListDto {
    @ApiModelProperty(name = "userId", value = "用户id", required = true)
    private String userId;

    @ApiModelProperty(name = "UpdateParentInfoList", value = "更改家长信息list", required = true)
    List<UpdateParentInformationDto> parentInfoList = new ArrayList<>();
}

