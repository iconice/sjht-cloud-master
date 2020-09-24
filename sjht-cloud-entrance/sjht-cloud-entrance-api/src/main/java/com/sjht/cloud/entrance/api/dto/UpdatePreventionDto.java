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
@ApiModel(value = "UpdatePreventionDto", description = "更新接种证明dto")
public class UpdatePreventionDto implements Serializable {


    @ApiModelProperty(name = "id", value = "接种证明id", required = true)
    private String id;

    @ApiModelProperty(name = "appliId", value = "申请id", required = true)
    private String appliId;

    @ApiModelProperty(name = "status", value = "状态：1-草稿、2-待审核、3-审核不通过、4-审核通过、5-完成", required = false)
    private int status;

    @ApiModelProperty(name = "fileDtos", value = "文件列表", required = true)
    private List<CreateEntrancePreventionFileDto> fileDtos;
}
