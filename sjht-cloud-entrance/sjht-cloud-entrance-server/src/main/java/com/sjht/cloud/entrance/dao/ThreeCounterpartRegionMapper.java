package com.sjht.cloud.entrance.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sjht.cloud.entrance.api.vo.RegionAddListVo;
import com.sjht.cloud.entrance.entity.ThreeCounterpartRegionEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ***************************************************
 * @ClassName ThreeCounterpartRegionMapper
 * @Description 学区房区域mapper
 * @Author maojianyun
 * @Date 2020/1/8 10:36
 * @Version V1.0
 * ****************************************************
 **/
@Component
@Mapper
public interface ThreeCounterpartRegionMapper extends BaseMapper<ThreeCounterpartRegionEntity> {

    /**
     * 得到列表
     * @return
     */
    List<RegionAddListVo> getRegionAddList();
}
