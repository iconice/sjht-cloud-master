package com.sjht.cloud.entrance.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

/**
 * ***************************************************
 * @ClassName EntranceBaseDto
 * @Description 入学基本信息
 * @Author 张弛
 * @Date 2020/3/17 16:27
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ToString
@JsonSerialize
@ApiModel(value = "EntranceBaseDto", description = "入学基本信息dto")
public class EntranceBaseDto {

    @NotBlank(message = "申请id不能为空")
    @ApiModelProperty(name = "appliId", value = "申请id", required = true)
    private String appliId;

    @ApiModelProperty(name = "childName", value = "入学孩子姓名", required = true)
    private String childName;

    @ApiModelProperty(name = "childSex", value = "入学孩子性别", required = true)
    private int childSex;

    @ApiModelProperty(name = "idCard", value = "入学孩子的身份证号码", required = true)
    private String idCard;

    @ApiModelProperty(name = "childHeadFileId", value = "孩子头像id", required = true)
    private String childHeadFileId;

    @ApiModelProperty(name = "masterName", value = "户主名字", required = true)
    private String masterName;

    @ApiModelProperty(name = "relation", value = "户主和入学孩子的关系", required = true)
    private int relation;

    @ApiModelProperty(name = "tell", value = "联系电话号码", required = true)
    private String tell;

    @ApiModelProperty(name = "address", value = "户口地址", required = true)
    private String address;

    @ApiModelProperty(name = "masterFileId", value = "户口本户主页图片id", required = true)
    private String masterFileId;

    @ApiModelProperty(name = "masterInfoFileId", value = "户口本户主信息页图片id", required = true)
    private String masterInfoFileId;

    @ApiModelProperty(name = "childInfoFileId", value = "户口本入学小孩信息页面图片id", required = true)
    private String childInfoFileId;

    @ApiModelProperty(name = "modifyFileId", value = "户口本增减页图片id", required = true)
    private String modifyFileId;

    @ApiModelProperty(name = "remark", value = "备注", required = false)
    private String remark;
}