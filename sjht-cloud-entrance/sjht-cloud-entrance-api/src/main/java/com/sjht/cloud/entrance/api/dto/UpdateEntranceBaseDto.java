package com.sjht.cloud.entrance.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName UpdateEntranceBaseDto
 * @Description 创建户口基本信息
 * @Author maojianyun
 * @Date 2020/3/4 10:50
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ToString
@ApiModel(value = "UpdateEntranceBaseDto", description = "更新户口基本数据dto")
public class UpdateEntranceBaseDto implements Serializable {

    @ApiModelProperty(name = "id", value = "id", required = true)
    private long id;

    @ApiModelProperty(name = "childName", value = "入学孩子姓名", required = true)
    private String childName;

    @ApiModelProperty(name = "childSex", value = "入学孩子性别", required = true)
    private int childSex;

    @ApiModelProperty(name = "idCard", value = "入学孩子的身份证号码", required = true)
    private String idCard;

    @ApiModelProperty(name = "childHeadFileId", value = "学习孩纸的头像id", required = true)
    private String childHeadFileId;

    @ApiModelProperty(name = "masterName", value = "户主名字", required = true)
    private String masterName;

    @ApiModelProperty(name = "relation", value = "户主和入学孩子的关系", required = true)
    private int relation;

   @ApiModelProperty(name = "status", value = "状态：1-草稿、2-待审核、3-审核不通过、4-审核通过、5-完成", required = false)
   private int status;

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
}
