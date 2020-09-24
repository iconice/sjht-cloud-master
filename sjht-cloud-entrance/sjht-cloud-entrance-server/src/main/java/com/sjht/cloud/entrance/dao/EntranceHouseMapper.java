package com.sjht.cloud.entrance.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sjht.cloud.entrance.api.dto.AuditAppDetailDto;
import com.sjht.cloud.entrance.api.vo.EntranceHouseVo;
import com.sjht.cloud.entrance.entity.EntranceHouseEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * ***************************************************
 * @ClassName EntranceHouseMapper
 * @Description 房产信息
 * @Author maojianyun
 * @Date 2020/3/5 13:46
 * @Version V1.0
 * ****************************************************
 **/
@Component
@Mapper
public interface EntranceHouseMapper extends BaseMapper<EntranceHouseEntity> {

    /**
     * 房产信息
     * @param appliId
     * @return
     */
    EntranceHouseVo getEntranceHouseInfo(@Param("appliId") String appliId);

    /**
     * 修改审核的状态
     * @param id
     * @param status
     * @return
     */
    int modifyEntranceHouseStatus(@Param("id") long id, @Param("status") int status);

    int updateAudit(@Param("ew") AuditAppDetailDto auditAppDetailDto);
}
