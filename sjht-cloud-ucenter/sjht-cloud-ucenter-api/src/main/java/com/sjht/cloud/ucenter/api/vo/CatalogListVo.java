package com.sjht.cloud.ucenter.api.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName CatalogListVo
 * @Description 得到目录vo
 * @Author maojianyun
 * @Date 2019/12/23 10:41
 * @Version V1.0
 * ****************************************************
 **/
@ToString
@Data
@ApiModel(value = "CatalogListVo", description = "目录VO、不包含按钮")
public class CatalogListVo implements Serializable{

    private static final long serialVersionUID = -1114880588907604914L;

    private String id;

    private String name;

    private String parentId;

    private Integer type;
}
