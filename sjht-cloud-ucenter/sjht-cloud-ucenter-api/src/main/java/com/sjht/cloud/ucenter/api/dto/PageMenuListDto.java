package com.sjht.cloud.ucenter.api.dto;

import com.sjht.cloud.framework.common.entity.request.PageDto;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

/**
 * ***************************************************
 * @ClassName PageMenuListDto
 * @Description 菜单分页查询
 * @Author maojianyun
 * @Date 2019/12/23 9:21
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ToString
@ApiModel(value = "PageMenuListDto", description = "菜单分页查询d'to")
public class PageMenuListDto extends PageDto {
}
