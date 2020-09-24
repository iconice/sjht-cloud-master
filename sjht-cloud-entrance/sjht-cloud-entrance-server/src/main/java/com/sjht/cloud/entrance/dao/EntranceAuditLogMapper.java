package com.sjht.cloud.entrance.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sjht.cloud.entrance.api.dto.GetAppListDto;
import com.sjht.cloud.entrance.entity.EntranceAuditLogEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * ***************************************************
 * @ClassName EntranceAuditLogMapper
 * @Description 审核日志mapper
 * @Author maojianyun
 * @Date 2020/3/9 13:24
 * @Version V1.0
 * ****************************************************
 **/
@Component
@Mapper
public interface EntranceAuditLogMapper extends BaseMapper<EntranceAuditLogEntity> {

    /**
     * 修改审核日志状态
     * @param id
     * @param status
     * @return
     */
    int updateAuditLogStatus(@Param("id") long id, @Param("status") int status);

    /**
     * 得到审核的内容
     * @param appliId
     * @param status
     * @return
     */
    String getAuditLogContent(@Param("appliId") long appliId, @Param("status") int status);

    /**
     * 得到审核的状态
     * @param id
     * @return
     */
    String  getAuditStatus(@Param("id")String id);

    /*
     * @Author zhangchi
     * @Description //得到审核列表支持多条件查询
     * @Date 15:38 2020/5/14
     * @Param
     * @return
     **/
    String getAppList(@Param("ew") GetAppListDto getAppListDto);

}
