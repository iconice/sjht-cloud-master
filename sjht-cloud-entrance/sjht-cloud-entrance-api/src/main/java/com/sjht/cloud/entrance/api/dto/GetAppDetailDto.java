package com.sjht.cloud.entrance.api.dto;

import com.sjht.cloud.framework.common.entity.request.PageDto;
import io.swagger.annotations.ApiModel;
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
@ApiModel(value = "GetAppDetailDto", description = "获取待审核申请详情DTO")
public class GetAppDetailDto implements Serializable {

    /**申请编号*/
    private String appid;

    /**申请类型：0-户籍申请详情 1-房产详情 2-疫苗详情 3-转学详情*/
    private int type;

}
