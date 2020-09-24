package com.sjht.cloud.entrance.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName EntranceHousePeopleVo
 * @Description 描述
 * @Author maojianyun
 * @Date 2020/3/5 14:39
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ToString
@ApiModel(value = "EntranceHousePeopleDto", description = "房产权利人dto")
public class EntranceHousePeopleDto implements Serializable {

    private static final long serialVersionUID = 3094122350529956958L;

    @ApiModelProperty(name = "name", value = "姓名", required = true)
    private String name;

    @ApiModelProperty(name = "relation", value = "关系", required = true)
    private String relation;
}
