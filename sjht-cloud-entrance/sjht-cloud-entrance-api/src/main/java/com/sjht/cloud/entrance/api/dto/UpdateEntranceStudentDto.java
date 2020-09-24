package com.sjht.cloud.entrance.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * ***************************************************
 *
 * @ClassName UpdateEntranceStudentDto
 * @Description 更新申请转学信息
 * @Author 张弛
 * @Date 2020/4/16 9:15
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ToString
public class UpdateEntranceStudentDto implements Serializable {
    @ApiModelProperty(name = "id", value = "id", required = true)
    private String id;

    @ApiModelProperty(name = "appliId", value = "申请id", required = true)
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

    @ApiModelProperty(name = "fileDtos", value = "文件列表", required = true)
    private List<EntranceStudentFileDto> fileDtos;
}
