package com.sjht.cloud.entrance.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sjht.cloud.entrance.api.dto.AuditAppDetailDto;
import com.sjht.cloud.entrance.api.vo.EntranceStudentVo;
import com.sjht.cloud.entrance.entity.EntranceStudentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * ***************************************************
 *
 * @ClassName EntranceStudentMapper
 * @Description  转学学生
 * @Author 张弛
 * @Date 2020/4/15 10:41
 * @Version V1.0
 * ****************************************************
 **/
@Mapper
@Component
public interface EntranceStudentMapper extends BaseMapper<EntranceStudentEntity> {
    /**
     * 获取转学儿童信息
     * @param id
     * @return
     */
    EntranceStudentVo getEntranceStudentInfo(@Param("id") Long id);

    /**
     * 修改转学儿童审核信息的状态
     * @param id
     * @param status
     * @return
     */
    int modifyStatus(@Param("id") String id, @Param("status") int status);

    int updateAudit(@Param("ew") AuditAppDetailDto auditAppDetailDto);
}
