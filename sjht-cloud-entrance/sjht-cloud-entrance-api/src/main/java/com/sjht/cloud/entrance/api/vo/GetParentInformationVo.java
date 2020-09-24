package com.sjht.cloud.entrance.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * ***************************************************
 *
 * @ClassName GetParentInformationVo
 * @Description 得到家长信息list
 * @Author 张弛
 * @Date 2020/4/1 11:45
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ToString
@ApiModel(value = "GetParentInformationVo", description = "得到家长信息list")
public class GetParentInformationVo implements Serializable {
    @ApiModelProperty(name = "ParentInformationList", value = "家长信息list", required = true)
    List<ParentInformationVo> ParentInformationList = new ArrayList<>();
}
