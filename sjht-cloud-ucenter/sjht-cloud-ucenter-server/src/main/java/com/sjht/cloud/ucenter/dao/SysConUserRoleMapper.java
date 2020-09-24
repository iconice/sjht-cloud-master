package com.sjht.cloud.ucenter.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sjht.cloud.ucenter.entity.SysConUserRoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ***************************************************
 * @ClassName SysConUserRoleMapper
 * @Description SysConUserRoleMapper
 * @Author maojianyun
 * @Date 2019/12/24 10:49
 * @Version V1.0
 * ****************************************************
 **/
@Component
@Mapper
public interface SysConUserRoleMapper extends BaseMapper<SysConUserRoleEntity> {

    /**
     * 批量插入
     * @param entitys
     * @return
     */
    int batchInsert(@Param("params") List<SysConUserRoleEntity> entitys);
}
