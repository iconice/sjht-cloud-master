package com.sjht.cloud.entrance.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * ***************************************************
 *
 * @ClassName EntranceStudentDto
 * @Description
 * @Author 张弛
 * @Date 2020/4/13 11:22
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ToString
@ApiModel(value = "EntranceStudentDto", description = "转学儿童信息dto")
public class EntranceStudentDto implements Serializable {

    @ApiModelProperty(name = "appliId", value = "申请ID", required = true)
    private String appliId;

    @ApiModelProperty(name = "outSchoolName", value = "转出学校名", required = true)
    private String outSchoolName;

    @ApiModelProperty(name = "studentNum", value = "学籍号", required = true)
    private String studentNum;

    @ApiModelProperty(name = "isHealth", value = "是否健康", required = true,notes = "1健康 2残疾")
    private int isHealth;

    @ApiModelProperty(name = "isHealthForm", value = "是否有健康证明", required = true,notes = "1有 2无")
    private int isHealthForm;

    @ApiModelProperty(name = "remark", value = "备注", required = false)
    private String remark;

    @ApiModelProperty(name = "fileDtos", value = "文件列表；1素质报告、成绩单、评语\\n\" +\n" +
            "            \"     2转出学校学籍卡\\n\" +\n" +
            "            \"     3体检报告", required = true)
    private List<EntranceStudentFileDto> fileDtos;

}
