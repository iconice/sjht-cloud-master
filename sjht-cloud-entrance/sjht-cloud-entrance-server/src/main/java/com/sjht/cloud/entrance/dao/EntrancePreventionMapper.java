package com.sjht.cloud.entrance.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sjht.cloud.entrance.api.dto.AuditAppDetailDto;
import com.sjht.cloud.entrance.entity.EntrancePreventionEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * ***************************************************
 * @ClassName EntrancePreventionMapper
 * @Description 描述
 * @Author maojianyun
 * @Date 2020/3/18 16:08
 * @Version V1.0
 * ****************************************************
 **/
@Mapper
@Component
public interface EntrancePreventionMapper extends BaseMapper<EntrancePreventionEntity> {

    /**
     * 修改状态
     * @param id
     * @param status
     * @return
     */
    int updateStatus(@Param("id")long id, @Param("status")int status);

    int updateAudit(@Param("ew") AuditAppDetailDto auditAppDetailDto);


}
