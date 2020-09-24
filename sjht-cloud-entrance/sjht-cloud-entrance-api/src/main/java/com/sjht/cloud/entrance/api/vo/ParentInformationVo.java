package com.sjht.cloud.entrance.api.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * ***************************************************
 * @ClassName ParentInformationVo
 * @Description 家长信息
 * @Author 张弛
 * @Date 2020/3/25 10:50
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ToString
@ApiModel(value = "ParentInformationVo", description = "家长信息vo")
public class ParentInformationVo implements Serializable {
    @ApiModelProperty(name = "id", value = "id", required = true)
    private String id;
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
    @ApiModelProperty(name = "relations", value = "1父亲 2母亲 3爷爷 4奶奶 5外公 6外婆 7其他", required = true)
    private int relations;
}
