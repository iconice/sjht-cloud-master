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
 * @ClassName CreateParentInfoDto
 * @Description 描述
 * @Author 张弛
 * @Date 2020/4/1 10:41
 * @Version V1.0
 * ****************************************************
 **/
@ApiModel(value = "CreateParentInfoDto", description = "创建家长信息dto")
@Data
@ToString
public class CreateParentInfoDto {
    @ApiModelProperty(name = "parentInfoList", value = "家长信息list", required = true)
    List<ParentInformationDto> parentInfoList = new ArrayList<>();
}
