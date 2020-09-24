package com.sjht.cloud.entrance.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName CreateEntraceAppliactionDto
 * @Description 创建入学申请
 * @Author maojianyun
 * @Date 2020/3/3 20:01
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ToString
@ApiModel(value = "CreateEntraceAppliactionDto", description = "创建入学申请Dto")
public class CreateEntraceAppliactionDto implements Serializable {

    private static final long serialVersionUID = -302721645393011700L;

    @NotBlank(message = "用户id不能为空")
    @ApiModelProperty(name = "userId", value = "用户id", required = true)
    private String userId;

    @NotBlank(message = "类型不能为空")
    @ApiModelProperty(name = "type", value = "申请类型：1-入学、2-转学", required = true)
    private int type;
}
