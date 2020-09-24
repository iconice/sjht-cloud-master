package com.sjht.cloud.entrance.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName GetEntrancePreventionFileVo
 * @Description 创建查验证明
 * @Author maojianyun
 * @Date 2020/3/2 19:12
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ToString
@ApiModel(value = "CreateEntrancePreventionFileDto", description = "创建查验证明dto")
public class CreateEntrancePreventionFileDto implements Serializable {

    private static final long serialVersionUID = -8665027671112685287L;

    @ApiModelProperty(name = "type", value = "类型：1-查验证明、2-接种证明", required = true)
    private int type;

    @ApiModelProperty(name = "fileId", value = "文件id", required = true)
    private String fileId;

    @ApiModelProperty(name = "sortNum", value = "排序", required = false)
    private int sortNum;
}
