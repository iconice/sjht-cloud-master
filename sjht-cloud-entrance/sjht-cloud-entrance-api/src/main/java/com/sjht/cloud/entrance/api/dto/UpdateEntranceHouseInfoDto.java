package com.sjht.cloud.entrance.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * ***************************************************
 *
 * @ClassName UpdateEntranceHouseInfoDto
 * @Description 更新入学房产信息
 * @Author 张弛
 * @Date 2020/3/17 11:46
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ToString
@ApiModel(value = "UpdateEntranceHouseInfoDto", description = "更新入学房产信息dto")
public class UpdateEntranceHouseInfoDto implements Serializable {
    @ApiModelProperty(name = "id", value = "入学房产ID",required = true)
    private String id;
    @ApiModelProperty(name = "communityId", value = "小区ID")
    private String communityId;
    @ApiModelProperty(name = "streetId", value = "街道ID")
    private String streetId;
    @ApiModelProperty(name = "address", value = "街道地址")
    private String address;
    private Date inTime;
    @ApiModelProperty(name = "type", value = "类型：1-有房产证、2-没有房产证（默认为1）")
    private int type;




}
