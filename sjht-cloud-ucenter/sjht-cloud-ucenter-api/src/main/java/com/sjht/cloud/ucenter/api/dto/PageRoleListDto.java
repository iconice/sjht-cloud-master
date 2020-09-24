package com.sjht.cloud.ucenter.api.dto;

import com.sjht.cloud.framework.common.entity.request.PageDto;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

/**
 * ***************************************************
 * @ClassName PageRoleListDto
 * @Description 角色分页查询
 * @Author maojianyun
 * @Date 2019/12/23 11:24
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ToString
@ApiModel(value = "PageRoleListDto", description = "角色分页dto")
public class PageRoleListDto extends PageDto {
}
