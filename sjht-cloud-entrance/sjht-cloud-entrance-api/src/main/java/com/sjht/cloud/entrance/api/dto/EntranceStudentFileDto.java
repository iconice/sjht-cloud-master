package com.sjht.cloud.entrance.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * ***************************************************
 *
 * @ClassName EntranceStudentFileDto
 * @Description 转学学生文件Dto
 * @Author 张弛
 * @Date 2020/4/14 14:55
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ToString
@ApiModel(value = "EntranceStudentFileDto", description = "转学学生文件Dto")
public class EntranceStudentFileDto implements Serializable {
    @ApiModelProperty(name = "id", value = "id", required = false)
    private String id;
    /**
     * 文件ID
     */
    @ApiModelProperty(name = "fileId", value = "fileId", required = true)
    private String fileId;
    /**
     * 1素质报告、成绩单、评语
     2转出学校学籍卡
     3体检报告
     */
    @ApiModelProperty(name = "type", value = "type", required = true,notes = "1素质报告、成绩单、评语\n" +
            "     2转出学校学籍卡\n" +
            "     3体检报告")
    private int type;
}
