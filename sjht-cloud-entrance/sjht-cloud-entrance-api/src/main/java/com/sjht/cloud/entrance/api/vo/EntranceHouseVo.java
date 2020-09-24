package com.sjht.cloud.entrance.api.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ***************************************************
 * @ClassName EntranceHouseVo
 * @Description 房产vo
 * @Author maojianyun
 * @Date 2020/3/5 14:05
 * @Version V1.0
 * ****************************************************
 **/
@ApiModel(value = "EntranceHouseVo", description = "房产vo")
@Data
@ToString
public class EntranceHouseVo implements Serializable {

    private static final long serialVersionUID = 2632101175636125610L;

    @ApiModelProperty(name = "id", value = "d", required = true)
    private String id;

    @ApiModelProperty(name = "communityId", value = "小区id", required = true)
    private String communityId;

    @ApiModelProperty(name = "streetId", value = "街道id", required = true, hidden = true)
    private String streetId;

    @ApiModelProperty(name = "address", value = "房产详细地址", required = true)
    private String address;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(name = "inTime", value = "入住时间", required = true)
    private Date inTime;

    @ApiModelProperty(name = "type", value = "类型：1-有房产证、2-没有房产证（默认为1）", required = true)
    private int type;

    @ApiModelProperty(name = "isMulti", value = "是否是多人：1-单人、2-多人", required = true)
    private int isMulti;

    @ApiModelProperty(name = "feedback", value = "审核反馈内容", required = false)
    private String feedback;

    @ApiModelProperty(name = "status", value = "状态：1-草稿、2-待审核、3-审核不通过、4-审核通过、5-完成", required = false)
    private String status;

    @ApiModelProperty(name = "houseFileList", value = "房产证list", required = false)
    List<EntranceHouseFileVo> houseFileList = new ArrayList<>();

    @ApiModelProperty(name = "housePeopleList", value = "房产权利人list", required = true)
    List<EntranceHousePeopleVo> housePeopleList = new ArrayList<>();
}
