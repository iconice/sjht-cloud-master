package com.sjht.cloud.entrance.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.sjht.cloud.entrance.api.dto.CreateEntranceHousePeopleDto;
import com.sjht.cloud.entrance.api.vo.EntranceHousePeopleVo;
import com.sjht.cloud.entrance.dao.EntranceHousePeopleMapper;
import com.sjht.cloud.entrance.entity.EntranceHousePeopleEntity;
import com.sjht.cloud.entrance.service.EntranceHousePeopleService;
import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import com.sjht.cloud.framework.common.entity.response.ResponseResult;
import com.sjht.cloud.framework.common.entity.response.ResponseUtil;
import com.sjht.cloud.framework.common.enums.CommonCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ***************************************************
 *
 * @ClassName EntranceHousePeopleServiceImpl
 * @Description 描述
 * @Author maojianyun
 * @Date 2020/3/5 16:49
 * @Version V1.0
 * ****************************************************
 **/
@Service
public class EntranceHousePeopleServiceImpl implements EntranceHousePeopleService {

    @Autowired
    private EntranceHousePeopleMapper housePeopleMapper;

    @Override
    public ResponseDataResult getEntranceHousePeopleList(String houseId) {
        List<EntranceHousePeopleVo> peopleVos = housePeopleMapper.getEntranceHousePeopleList(Long.valueOf(houseId));
        if (peopleVos != null) {
            return ResponseUtil.SUCCESS(peopleVos);
        }
        return ResponseUtil.SUCCESS(CommonCode.NULL, null);
    }

    @Override
    public ResponseResult createEntranceHousePeople(CreateEntranceHousePeopleDto peopleDto) {
        EntranceHousePeopleEntity entity = new EntranceHousePeopleEntity();
        long id = IdWorker.getId();
        entity.setId(id);
        entity.setHouseId(Long.valueOf(peopleDto.getHouseId()));
        entity.setName(peopleDto.getName());
        entity.setRelation(peopleDto.getRelation());
        int n = housePeopleMapper.insert(entity);
        if (n > 0) {
            return ResponseUtil.SUCCESS();
        }
        return ResponseUtil.FAIL();
    }

    @Override
    public ResponseResult deleteEntranceHousePeople(String id) {
        int n = housePeopleMapper.deleteById(id);
        if (n > 0) {
            return ResponseUtil.SUCCESS();
        }
        return ResponseUtil.FAIL();
    }
}
