package com.sjht.cloud.entrance.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

/**
 * ***************************************************
 * @ClassName ParentInformationDto
 * @Description 家长信息
 * @Author 张弛
 * @Date 2020/3/17 16:27
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ToString
@JsonSerialize
@ApiModel(value = "ParentInformationDto", description = "家长信息dto")
public class ParentInformationDto {

    @ApiModelProperty(name = "userId", value = "用户id", required = true)
    private String userId;
    @ApiModelProperty(name = "name", value = "姓名", required = true)
    private String name;
    @ApiModelProperty(name = "workUnits", value = "工作单位", required = false)
    private String workUnits;
    @ApiModelProperty(name = "dep", value = "所属部门", required = false)
    private String dep;
    @ApiModelProperty(name = "workUnitsTell", value = "工作单位电话", required = false)
    private String workUnitsTell;
    @ApiModelProperty(name = "tell", value = "联系电话", required = true)
    private String tell;
    @ApiModelProperty(name = "relations", value = "1父亲 2母亲 3爷爷 4奶奶 5外公 6外婆 8其他", required = true)
    private String relations;

}
