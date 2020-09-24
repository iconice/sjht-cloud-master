package com.sjht.cloud.entrance.api.dto;

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
@ApiModel(value = "CreateAuditLogDto", description = "创建审核日志Dto")
public class CreateAuditLogDto implements Serializable {

    private static final long serialVersionUID = -1811081876076628579L;

    private long appliId;

    private String content;

    private int status;
}
