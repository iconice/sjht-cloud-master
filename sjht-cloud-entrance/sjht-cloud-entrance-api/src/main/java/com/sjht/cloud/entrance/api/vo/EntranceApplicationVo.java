package com.sjht.cloud.entrance.api.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * ***************************************************
 * @ClassName EntranceApplicationVo
 * @Description 入学申请vo
 * @Author maojianyun
 * @Date 2020/3/3 20:26
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ToString
public class EntranceApplicationVo implements Serializable {

    @ApiModelProperty(name = "id", value = "id")
    private String id;

    @ApiModelProperty(name = "title", value = "标题")
    private String title;

    @ApiModelProperty(name = "type", value = "状态：1-入学、2-转学")
    private int type;

    @ApiModelProperty(name = "status", value = "状态：1-草稿、2-待审核、3-审核不通过、4-审核通过、5-完成")
    private int status;

    @ApiModelProperty(name = "createTime", value = "创建时间")
    private Date createTime;

    @ApiModelProperty(name = "updateTime", value = "更新时间")
    private Date updateTime;
}
