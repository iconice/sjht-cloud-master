package com.sjht.cloud.ucenter.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * ***************************************************
 *
 * @ClassName UpdateUserDto
 * @Description 更新用户头像信息
 * @Author 张弛
 * @Date 2020/4/29 11:16
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ToString
@ApiModel(value = "UpdateUserHeadDto", description = "更新用户头像dto")
public class UpdateUserHeadDto implements Serializable {

    private static final long serialVersionUID = 7190859835209685538L;

    @ApiModelProperty(name = "id", value = "用户id",required = false)
    @NotNull (message = "id 不能为空")
    private String id;

    @ApiModelProperty(name = "fileId", value = "头像id",required=false)
    @NotNull (message = "头像地址 不能为空")
    private String fileId;
}
