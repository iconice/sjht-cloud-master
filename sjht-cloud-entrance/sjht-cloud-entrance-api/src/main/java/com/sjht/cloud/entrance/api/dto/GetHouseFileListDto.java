package com.sjht.cloud.entrance.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName GetHouseFileListDto
 * @Description 得到房产文件dto
 * @Author maojianyun
 * @Date 2020/3/5 16:11
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ToString
@ApiModel(value = "GetHouseFileListDto", description = "得到房产文件dto")
public class GetHouseFileListDto implements Serializable {

    private static final long serialVersionUID = -8920338584919395935L;

    @ApiModelProperty(name = "houseId", value = "房产id", required = true)
    private String houseId;

    @ApiModelProperty(name = "type", value = "类型：1-房产证、2-没有房产证、3-结婚证、4-出生证明", required = true)
    private int type;

    @ApiModelProperty(name = "subType", value = "子类型：5-购房合同(type=2)、6-贷款抵押合同(type=2)、7-房屋登记证明(type=2)、8-其他(type != 2)", required = true)
    private int subType;
}
