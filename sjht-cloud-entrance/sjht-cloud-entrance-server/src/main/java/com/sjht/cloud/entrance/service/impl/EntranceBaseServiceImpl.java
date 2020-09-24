package com.sjht.cloud.entrance.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.sjht.cloud.entrance.api.dto.EntranceBaseDto;
import com.sjht.cloud.entrance.api.dto.UpdateEntranceBaseDto;
import com.sjht.cloud.entrance.api.vo.EntranceBaseVo;
import com.sjht.cloud.entrance.constant.EntranceConstant;
import com.sjht.cloud.entrance.dao.EntranceBaseMapper;
import com.sjht.cloud.entrance.entity.EntranceBaseEntity;
import com.sjht.cloud.entrance.service.EntranceBaseService;
import com.sjht.cloud.entrance.service.EntranceFileInfoService;
import com.sjht.cloud.framework.common.entity.response.Response;
import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import com.sjht.cloud.framework.common.entity.response.ResponseResult;
import com.sjht.cloud.framework.common.entity.response.ResponseUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * ***************************************************
 * @ClassName EntranceBaseServiceImpl
 * @Description 描述
 * @Author maojianyun
 * @Date 2020/3/3 21:57
 * @Version V1.0
 * ****************************************************
 **/
@Service
public class EntranceBaseServiceImpl implements EntranceBaseService {

    @Autowired
    private EntranceBaseMapper entranceBaseMapper;

    @Autowired
    EntranceFileInfoService fileInfoService;

    @Override
    public ResponseResult createEntranceBase(EntranceBaseDto baseDto) {
        EntranceBaseEntity entity = new EntranceBaseEntity();
        BeanUtils.copyProperties(baseDto, entity);
        entity.setId(IdWorker.getId());
        entity.setAppliId(Long.valueOf(baseDto.getAppliId()));
        entity.setStatus(EntranceConstant.CommonConstant.status_draft);
        int n = entranceBaseMapper.insert(entity);
        if (n > 0) {
            ResponseUtil.SUCCESS();
        }
        else{
            return ResponseUtil.FAIL();
        }
        return ResponseUtil.SUCCESS();
    }

    @Override
    public ResponseDataResult getEntranceBaseInfo(String appliId) {
        //QueryWrapper wrapper = new QueryWrapper();
        // wrapper.eq("appli_id", appliId);
        EntranceBaseVo baseVo = entranceBaseMapper.getEntranceBaseInfo(appliId);
        // EntranceBaseEntity baseVo = entranceBaseMapper.selectOne(wrapper); //通过申请id获取唯一一条入学基础信息
        return  ResponseUtil.SUCCESS(baseVo);
    }

    @Override
    public ResponseResult deleteEntranceBase(String id) {
        int n = entranceBaseMapper.deleteById(id);
        if (n > 0) {
           return ResponseUtil.SUCCESS();
        }
        else{
            return ResponseUtil.FAIL();
        }
    }

    @Transactional
    @Override
    public Response updateEntranceBaseInfo(UpdateEntranceBaseDto baseDto) {
        baseDto.setStatus(EntranceConstant.CommonConstant.status_draft);//只要更改，状态都改为待提交
        int n = entranceBaseMapper.updateEntranceBaseInfo(baseDto);
        if (n > 0) {
            //entranceBaseMapper.modifyEntranceBaseStatus(Long.valueOf(baseDto.getId()),EntranceConstant.CommonConstant.status_draft);
            return ResponseUtil.SUCCESS();
        }
        return ResponseUtil.FAIL();
    }

    @Override
    public ResponseResult modifyEntranceBaseStatus(String id, int status) {
        int n = entranceBaseMapper.modifyEntranceBaseStatus(Long.valueOf(id), status);
        if (n > 0) {
            return ResponseUtil.SUCCESS();
        }
        return ResponseUtil.FAIL();
    }

    @Override
    public ResponseDataResult getEntranceBaseStatus(String appliId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("appli_id", appliId);
        EntranceBaseEntity entity = entranceBaseMapper.selectOne(wrapper);
        Map<String, Integer> data = new HashMap<>();
        data.put("status", entity != null?entity.getStatus(): 0);
        return ResponseUtil.SUCCESS(data);
    }
}
