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
@ApiModel(value = "AuditAppDetailDto", description = "审核详情返回")
public class AuditAppDetailDto implements Serializable {

    /**申请编号*/
    private String appid;

    /**申请子编号-如产品编号、疫苗接种编号等*/
    private String subAppid;

    /**审批结果:3-审核不通过、4-审核通过*/
    private int result;

    /**审批结果：审批不通过时需要*/
    private String resultMsg;

    /**申请类型：0-户籍申请详情 1-房产详情 2-疫苗详情 3-转学详情*/
    private int type;

}
