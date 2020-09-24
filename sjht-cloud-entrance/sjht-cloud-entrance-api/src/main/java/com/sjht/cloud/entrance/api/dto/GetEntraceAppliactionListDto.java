package com.sjht.cloud.entrance.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName GetEntraceAppliactionListDto
 * @Description 得到申请列表
 * @Author maojianyun
 * @Date 2020/3/3 20:01
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ToString
@ApiModel(value = "GetEntraceAppliactionListDto", description = "得到申请列表Dto")
public class GetEntraceAppliactionListDto implements Serializable {

    private static final long serialVersionUID = -302721645393011700L;

    @NotBlank(message = "用户id不能为空")
    @ApiModelProperty(name = "userId", value = "用户id", required = true)
    private String userId;
}
