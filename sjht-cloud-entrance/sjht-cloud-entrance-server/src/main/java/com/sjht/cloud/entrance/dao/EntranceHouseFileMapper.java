package com.sjht.cloud.entrance.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sjht.cloud.entrance.api.vo.EntranceHouseFileVo;
import com.sjht.cloud.entrance.entity.EntranceHouseFileEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ***************************************************
 * @ClassName EntranceHouseFileMapper
 * @Description 描述
 * @Author maojianyun
 * @Date 2020/3/5 14:47
 * @Version V1.0
 * ****************************************************
 **/
@Mapper
@Component
public interface EntranceHouseFileMapper extends BaseMapper<EntranceHouseFileEntity> {

    int batchInsert(@Param("params") List<EntranceHouseFileEntity> entitys);

    List<EntranceHouseFileVo> getHouseFileList(@Param("houseId") String houseId);
}
