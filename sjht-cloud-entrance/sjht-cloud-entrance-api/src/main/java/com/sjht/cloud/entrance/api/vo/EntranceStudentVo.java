package com.sjht.cloud.entrance.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ***************************************************
 *
 * @ClassName EntranceStudentVo
 * @Description 得到申请转学vo
 * @Author 张弛
 * @Date 2020/4/16 11:18
 * @Version V1.0
 * ****************************************************
 **/
@ApiModel(value = "EntranceStudentVo", description = "得到申请转学vo")
@Data
@ToString
public class EntranceStudentVo implements Serializable{
    @ApiModelProperty(name = "id", value = "id", required = true)
    private String id;

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

    @ApiModelProperty(name = "status", value = "状态", required = false)
    private String status;

    @ApiModelProperty(name = "remark", value = "备注", required = false)
    private String remark;

    @ApiModelProperty(name = "feedback", value = "反馈", required = false)
    private String feedback;

    @ApiModelProperty(name = "entranceStudentFileList", value = "转学儿童文件信息", required = false)
    List<EntranceStudentFileVo> entranceStudentFileList =new ArrayList<>();
}
