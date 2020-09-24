package com.sjht.cloud.framework.common.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * ***************************************************
 * @ClassName BaseEntity
 * @Description 基础实体类
 * @Author maojianyun
 * @Date 2019/12/1 23:12
 * @Version V1.0
 * ****************************************************
 **/
@Data
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final Integer DELETE_STATUS = 1;//删除状态

    public static final Integer UNDELETE_STATUS = 0;//未删除状态

    @TableId
    @NotNull(message = "id不能为空")
    private long id;
    /**
     * 标识是否删除；0-false,逻辑未删除，1-true逻辑已删除，默认0
     */
    private Integer deletec;
    /**
     * 默认值为CURRENT_TIMESTAMP，创建时间不会改变
     */
    private Date createTime;
    /**
     * 默认值为CURRENT_TIMESTAMP，数据修改后就改变
     */
    private Date updateTime;
    /**
     * 备注
     */
    @TableField(strategy = FieldStrategy.IGNORED)
    private String remark;
}

