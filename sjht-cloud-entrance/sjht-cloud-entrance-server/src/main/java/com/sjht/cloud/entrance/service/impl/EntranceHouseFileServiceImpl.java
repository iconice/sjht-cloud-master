package com.sjht.cloud.entrance.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.sjht.cloud.entrance.api.dto.CreateEntranceHouseFileDto;
import com.sjht.cloud.entrance.dao.EntranceHouseFileMapper;
import com.sjht.cloud.entrance.entity.EntranceHouseFileEntity;
import com.sjht.cloud.entrance.service.EntranceFileInfoService;
import com.sjht.cloud.entrance.service.EntranceHouseFileService;
import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import com.sjht.cloud.framework.common.entity.response.ResponseResult;
import com.sjht.cloud.framework.common.entity.response.ResponseUtil;
import com.sjht.cloud.framework.common.enums.CommonCode;
import com.sjht.cloud.framework.common.exception.ExceptionCast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * ***************************************************
 * @ClassName EntranceHouseFileServiceImpl
 * @Description 描述
 * @Author maojianyun
 * @Date 2020/3/5 16:11
 * @Version V1.0
 * ****************************************************
 **/
@Service
public class EntranceHouseFileServiceImpl implements EntranceHouseFileService {

    @Autowired
    private EntranceHouseFileMapper houseFileMapper;

    @Autowired
    EntranceFileInfoService fileInfoService;


    @Transactional
    @Override
    public ResponseResult deleteHouseFile(String id) {
        EntranceHouseFileEntity entity = houseFileMapper.selectById(Long.valueOf(id));
        int n = houseFileMapper.deleteById(id);
        fileInfoService.deleFile(entity.getFileId());
        if (n > 0) {
            return ResponseUtil.SUCCESS();
        }
        return ResponseUtil.FAIL();
    }

    @Override
    public ResponseDataResult createHouseFile(CreateEntranceHouseFileDto houseFileDto) {
        Map<String, String> data = new HashMap<>();
        EntranceHouseFileEntity entity = new EntranceHouseFileEntity();
        long id = IdWorker.getId();
        entity.setId(id);
        entity.setHouseId(Long.valueOf(houseFileDto.getHouseId()));
        entity.setFileId(houseFileDto.getFileId());
        entity.setSubType(houseFileDto.getSubType());
        entity.setSortNum(houseFileDto.getSortNum());
        int n = houseFileMapper.insert(entity);
        if (n > 0) {
            data.put("id", String.valueOf(id));
        } else {
            ExceptionCast.cast(CommonCode.FAIL);
        }
        return ResponseUtil.SUCCESS(data);
    }
}
