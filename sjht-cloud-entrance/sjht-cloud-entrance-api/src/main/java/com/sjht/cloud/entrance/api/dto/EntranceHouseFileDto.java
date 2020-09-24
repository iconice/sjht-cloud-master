package com.sjht.cloud.entrance.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName EntranceHouseFileVo
 * @Description 描述
 * @Author maojianyun
 * @Date 2020/3/5 14:13
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ToString
@ApiModel(value = "EntranceHouseFileDto", description = "房产文件dto")
public class EntranceHouseFileDto implements Serializable {

    private static final long serialVersionUID = -1285849030273832152L;

    @ApiModelProperty(name = "fileId", value = "文件id", required = true)
    private String fileId;

    @ApiModelProperty(name = "type", value = "类型：1-房产证、2-没有房产证、3-结婚证、4-出生证明", required = true)
    private int type;

    @ApiModelProperty(name = "subType", value = "在type=2：5-购房合同、6-贷款抵押合同、7-房屋登记证明、type!=1为8）", required = false)
    private int subType;

    @ApiModelProperty(name = "childType", value = "sub_type=5的类型：1-封面、2-甲乙双反页面、3-坐落地址、4-结房日、5合同鲜页、6-签字页(sub_type!=5时为0)", required = false)
    private int childType;

    @ApiModelProperty(name = "sortNum", value = "排序", required = true)
    private int sortNum;
}
