package com.sjht.cloud.entrance.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName CreateEntranceHouseFileDto
 * @Description 描述
 * @Author maojianyun
 * @Date 2020/3/5 14:13
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ToString
@ApiModel(value = "CreateEntranceHouseFileDto", description = "房产文件dto")
public class CreateEntranceHouseFileDto implements Serializable {

    private static final long serialVersionUID = -1285849030273832152L;

    @ApiModelProperty(name = "houseId", value = "房产id", required = true)
    private String houseId;

    @ApiModelProperty(name = "fileId", value = "文件id", required = true)
    private String fileId;

    @ApiModelProperty(name = "type", value = "类型：1-房产证、2-没有房产证、3-结婚证、4-出生证明", required = true)
    private int type;

    @ApiModelProperty(name = "subType", value = "子类型：5-购房合同、6-贷款抵押合同、7-房屋登记证明（在type=2时使用）", required = false)
    private int subType;

    @ApiModelProperty(name = "sortNum", value = "排序", required = true)
    private int sortNum;
}
