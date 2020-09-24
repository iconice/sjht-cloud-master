package com.sjht.cloud.entrance.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName RegionAddListVo
 * @Description RegionAddListVo
 * @Author maojianyun
 * @Date 2020/1/8 11:43
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ToString
@ApiModel(value = "RegionAddListVo", description = "区域地址vo")
public class RegionAddListVo implements Serializable {

    @ApiModelProperty(name = "id", value = "id")
    private String id;

    @ApiModelProperty(name = "parentId", value = "父id")
    private String parentId;

    @ApiModelProperty(name = "name", value = "名称")
    private String name;

    @ApiModelProperty(name = "type", value = "1-小区、2-地址")
    private int type;

    @ApiModelProperty(name = "createTime", value = "创建时间")
    private Data createTime;

    @ApiModelProperty(name = "updateTime", value = "更新时间")
    private Data updateTime;

    @ApiModelProperty(name = "remark", value = "备注")
    private String remark;
}
