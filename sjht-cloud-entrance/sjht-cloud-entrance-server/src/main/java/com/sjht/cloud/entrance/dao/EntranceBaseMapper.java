package com.sjht.cloud.entrance.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sjht.cloud.entrance.api.dto.AuditAppDetailDto;
import com.sjht.cloud.entrance.api.dto.GetAppDetailDto;
import com.sjht.cloud.entrance.api.dto.UpdateEntranceBaseDto;
import com.sjht.cloud.entrance.api.vo.EntranceBaseVo;
import com.sjht.cloud.entrance.entity.EntranceBaseEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * ***************************************************
 * @ClassName EntranceBaseMapper
 * @Description 基本信息
 * @Author maojianyun
 * @Date 2020/3/3 21:55
 * @Version V1.0
 * ****************************************************
 **/
@Mapper
@Component
public interface EntranceBaseMapper extends BaseMapper<EntranceBaseEntity> {

    /**
     * 查询基本信息
     * @param appliId
     * @return
     */
    EntranceBaseVo getEntranceBaseInfo(@Param("appliId") String appliId);

    /**
     * 更新基本信息
     * @param baseDto
     * @return
     */
    int updateEntranceBaseInfo(@Param("ew")UpdateEntranceBaseDto baseDto);

    /**
     * 修改审核状态
     * @param id
     * @param status
     * @return
     */
    int modifyEntranceBaseStatus(@Param("id") long id, @Param("status") int status);

    int updateAudit(@Param("ew") AuditAppDetailDto auditAppDetailDto);

//    /*
//     * @Author zhangchi
//     * @Description 获取详情
//     * @Date 15:45 2020/5/14
//     * @Param
//     * @return
//     **/
//    String getAppDetail(@Param("ew") GetAppDetailDto getAppDetailDto);
    /*
     * @Author zhangchi
     * @Description  设置返回结果
     * @Date 15:45 2020/5/14
     * @Param []
     * @return java.lang.String
     **/
    int auditAppDetail(@Param("ew") AuditAppDetailDto auditAppDetailDto);
}
