package com.sjht.cloud.entrance.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * ***************************************************
 * @ClassName CreatePreventionDto
 * @Description 描述
 * @Author maojianyun
 * @Date 2020/3/18 16:14
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ApiModel(value = "CreatePreventionDto", description = "新增接种证明dto")
public class CreatePreventionDto implements Serializable {


    @ApiModelProperty(name = "appliId", value = "申请id", required = true)
    private String appliId;

    @ApiModelProperty(name = "fileDtos", value = "文件列表", required = true)
    private List<CreateEntrancePreventionFileDto> fileDtos;
}
