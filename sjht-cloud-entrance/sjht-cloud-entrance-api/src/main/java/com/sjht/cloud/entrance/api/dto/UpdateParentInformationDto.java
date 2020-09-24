package com.sjht.cloud.entrance.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * ***************************************************
 *
 * @ClassName UpdateParentInformationDto
 * @Description 描述
 * @Author 张弛
 * @Date 2020/3/25 16:10
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ToString
@JsonSerialize
@ApiModel(value = "UpdateParentInformationDto", description = "修改家长信息dto")
public class UpdateParentInformationDto {
    @ApiModelProperty(name = "id", value = "id", required = false)
    private String id;
    @ApiModelProperty(name = "name", value = "姓名", required = false)
    private String name;
    @ApiModelProperty(name = "workUnits", value = "工作单位", required = false)
    private String workUnits;
    @ApiModelProperty(name = "dep", value = "所属部门", required = false)
    private String dep;
    @ApiModelProperty(name = "workUnitsTell", value = "工作单位电话", required = false)
    private String workUnitsTell;
    @ApiModelProperty(name = "tell", value = "联系电话", required = false)
    private String tell;
    @ApiModelProperty(name = "relations", value = "1父亲 2母亲 3爷爷 4奶奶 5外公 6外婆 7其他", required = true)
    private int relations;
}
