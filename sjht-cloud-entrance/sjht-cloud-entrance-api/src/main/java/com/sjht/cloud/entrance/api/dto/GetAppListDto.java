package com.sjht.cloud.entrance.api.dto;

import com.sjht.cloud.framework.common.entity.request.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName CreateAuditLogDto
 * @Description 描述
 * @Author maojianyun
 * @Date 2020/3/9 13:31
 * @Version V1.0
 * ****************************************************
 **/
@Data
@ToString
@ApiModel(value = "GetAppListDto", description = "获取待审核申请列表DTO")
public class GetAppListDto extends PageDto implements Serializable {

    /**申请人名字-用于条件模糊查询*/
    @ApiModelProperty(name = "userName", value = "申请人名字-用于条件模糊查询", example = "小仙女", required = false)
    private String userName;

    /**审核状态-用于条件查询：2-待审核、3-审核不通过、4-审核通过*/
    @ApiModelProperty(name = "status", value = "审核状态-用于条件查询：2-待审核、3-审核不通过、4-审核通过", example = "2", required = false)
    private int status;

    /**审核类型-用于条件查询：1-入学、2-转学*/
    @ApiModelProperty(name = "type", value = "审核类型-用于条件查询：1-入学、2-转学", example = "2", required = false)
    private int type;
}
