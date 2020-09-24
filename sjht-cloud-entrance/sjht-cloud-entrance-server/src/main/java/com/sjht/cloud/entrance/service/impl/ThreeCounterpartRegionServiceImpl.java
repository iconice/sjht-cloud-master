package com.sjht.cloud.entrance.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.sjht.cloud.entrance.api.dto.CreateRegionAddDto;
import com.sjht.cloud.entrance.api.dto.UpdateRegionAddDto;
import com.sjht.cloud.entrance.api.vo.RegionAddListVo;
import com.sjht.cloud.entrance.dao.ThreeCounterpartRegionMapper;
import com.sjht.cloud.entrance.entity.ThreeCounterpartRegionEntity;
import com.sjht.cloud.entrance.service.ThreeCounterpartRegionService;
import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import com.sjht.cloud.framework.common.entity.response.ResponseResult;
import com.sjht.cloud.framework.common.entity.response.ResponseUtil;
import com.sjht.cloud.framework.common.enums.CommonCode;
import com.sjht.cloud.framework.common.exception.ExceptionCast;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * ***************************************************
 * @ClassName ThreeCounterpartRegionServiceImpl
 * @Description 描述
 * @Author maojianyun
 * @Date 2020/1/8 10:56
 * @Version V1.0
 * ****************************************************
 **/
@Service
public class ThreeCounterpartRegionServiceImpl implements ThreeCounterpartRegionService {

    @Autowired
    private ThreeCounterpartRegionMapper threeCounterpartRegionMapper;

    @Override
    public ResponseResult createRegionAdd(CreateRegionAddDto regionAddDto) {
        ThreeCounterpartRegionEntity entity = new ThreeCounterpartRegionEntity();
        BeanUtils.copyProperties(regionAddDto, entity);
        entity.setId(IdWorker.getId());
        int n = threeCounterpartRegionMapper.insert(entity);
        if (n <= 0){
            return ResponseUtil.FAIL();
        }
        return ResponseUtil.SUCCESS();
    }

    @Override
    public ResponseResult deleteRegionAdd(long id) {
        QueryWrapper<ThreeCounterpartRegionEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id", id);
        int count = threeCounterpartRegionMapper.selectCount(wrapper);
        if (count > 0) {
            ExceptionCast.cast(CommonCode.CANT_NOT_DELETE);
        }
        int n = threeCounterpartRegionMapper.deleteById(id);
        if (n <= 0){
            return ResponseUtil.FAIL();
        }
        return ResponseUtil.SUCCESS();
    }

    @Override
    public ResponseDataResult getRegionAddList() {
        List<RegionAddListVo> list = threeCounterpartRegionMapper.getRegionAddList();
        return ResponseUtil.SUCCESS(list);
    }

    @Override
    public ResponseResult updateRegionAdd(UpdateRegionAddDto regionAddDto) {
        ThreeCounterpartRegionEntity entity = new ThreeCounterpartRegionEntity();
        BeanUtils.copyProperties(regionAddDto, entity);
        entity.setUpdateTime(new Date());
        int n = threeCounterpartRegionMapper.updateById(entity);
        if (n <= 0){
            return ResponseUtil.FAIL();
        }
        return ResponseUtil.SUCCESS();
    }
}
