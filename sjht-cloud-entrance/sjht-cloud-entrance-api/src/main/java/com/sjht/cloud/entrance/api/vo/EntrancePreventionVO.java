package com.sjht.cloud.entrance.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * ***************************************************
 *
 * @ClassName EntrancePreventionVO
 * @Description 描述
 * @Author maojianyun
 * @Date 2020/3/18 20:58
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ApiModel(value = "EntrancePreventionVO", description = "接种证明vo")
public class EntrancePreventionVO implements Serializable {

    @ApiModelProperty(name = "id", value = "id")
    private String id;

    @ApiModelProperty(name = "appliId", value = "appliId")
    private String appliId;

    @ApiModelProperty(name = "status", value = "状态：1-草稿、2-待审核、3-审核不通过、4-审核通过、5-完成")
    private int status;

    @ApiModelProperty(name = "feedback", value = "审核反馈")
    private String feedback;

    @ApiModelProperty(name = "fileList", value = "文件列表")
    List<GetEntrancePreventionFileVo> fileList;
}
