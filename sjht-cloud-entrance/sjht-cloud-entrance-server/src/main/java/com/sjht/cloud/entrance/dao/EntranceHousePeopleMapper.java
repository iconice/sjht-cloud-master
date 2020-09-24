package com.sjht.cloud.entrance.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sjht.cloud.entrance.api.vo.EntranceHousePeopleVo;
import com.sjht.cloud.entrance.entity.EntranceHousePeopleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ***************************************************
 * @ClassName EntranceHousePeopleMapper
 * @Description 描述
 * @Author maojianyun
 * @Date 2020/3/5 15:36
 * @Version V1.0
 * ****************************************************
 **/
@Mapper
@Component
public interface EntranceHousePeopleMapper extends BaseMapper<EntranceHousePeopleEntity> {

    List<EntranceHousePeopleVo> getEntranceHousePeopleList(@Param("houseId") long houseId);
}
