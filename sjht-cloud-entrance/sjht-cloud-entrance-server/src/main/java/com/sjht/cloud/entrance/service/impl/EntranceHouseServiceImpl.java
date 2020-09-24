package com.sjht.cloud.entrance.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.sjht.cloud.entrance.api.dto.*;
import com.sjht.cloud.entrance.api.vo.EntranceHouseVo;
import com.sjht.cloud.entrance.constant.EntranceConstant;
import com.sjht.cloud.entrance.dao.EntranceHouseFileMapper;
import com.sjht.cloud.entrance.dao.EntranceHouseMapper;
import com.sjht.cloud.entrance.dao.EntranceHousePeopleMapper;
import com.sjht.cloud.entrance.entity.EntranceHouseEntity;
import com.sjht.cloud.entrance.entity.EntranceHouseFileEntity;
import com.sjht.cloud.entrance.entity.EntranceHousePeopleEntity;
import com.sjht.cloud.entrance.service.EntranceHouseService;
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
 * @ClassName EntranceHouseServiceImpl
 * @Description 描述
 * @Author maojianyun
 * @Date 2020/3/5 13:49
 * @Version V1.0
 * ****************************************************
 **/
@Service
public class EntranceHouseServiceImpl implements EntranceHouseService {

    @Autowired
    private EntranceHouseMapper entranceHouseMapper;

    @Autowired
    private EntranceHouseFileMapper houseFileMapper;

    @Autowired
    private EntranceHousePeopleMapper housePeopleMapper;

    @Transactional
    @Override
    public ResponseResult createEntranceHouse(CreateEntranceHouseDto entranceHouseDto) {
        EntranceHouseEntity entity = new EntranceHouseEntity();
        long id = IdWorker.getId();
        entity.setId(id);
        entity.setAppliId(Long.valueOf(entranceHouseDto.getAppliId()));
        entity.setCommunityId(Long.valueOf(entranceHouseDto.getCommunityId()));
        entity.setAddress(entranceHouseDto.getAddress());
        entity.setInTime(entranceHouseDto.getInTime());
        entity.setType(entranceHouseDto.getType());
        entity.setStatus(EntranceConstant.CommonConstant.status_draft);
        entity.setIsMulti(entranceHouseDto.getIsMulti());
        int n = entranceHouseMapper.insert(entity);
        if (n > 0) {
            this.insetHouseFiel(entranceHouseDto, id);
            this.insertHousePeople(entranceHouseDto, id);
        } else {
            ExceptionCast.cast(CommonCode.FAIL);
        }
        return ResponseUtil.SUCCESS();
    }

    @Transactional
    @Override
    public ResponseResult updateEntranceHouse(UpdateEntranceHouseDto entranceHouseDto) {
        EntranceHouseEntity entity = new EntranceHouseEntity();
        long id = Long.valueOf(entranceHouseDto.getId());
        entity.setId(id);
        entity.setAppliId(Long.valueOf(entranceHouseDto.getAppliId()));
        entity.setCommunityId(Long.valueOf(entranceHouseDto.getCommunityId()));
        entity.setAddress(entranceHouseDto.getAddress());
        entity.setInTime(entranceHouseDto.getInTime());
        entity.setType(entranceHouseDto.getType());
        entity.setStatus(EntranceConstant.CommonConstant.status_draft);
        entity.setIsMulti(entranceHouseDto.getIsMulti());
        int n = entranceHouseMapper.updateById(entity);
        if (n > 0) {
            this.insetHouseFiel(entranceHouseDto, id);
            this.insertHousePeople(entranceHouseDto, id);
        } else {
            ExceptionCast.cast(CommonCode.FAIL);
        }
        return ResponseUtil.SUCCESS();
    }

    public void insertHousePeople(UpdateEntranceHouseDto entranceHouseDto, long houseId){
        for(EntranceHousePeopleDto peopleDto: entranceHouseDto.getHousePeopleList()){
            EntranceHousePeopleEntity entity = new EntranceHousePeopleEntity();
            entity.setId(IdWorker.getId());
            entity.setHouseId(houseId);
            entity.setName(peopleDto.getName());
            entity.setRelation(peopleDto.getRelation());
            housePeopleMapper.insert(entity);
        }
    }

    public void insertHousePeople(CreateEntranceHouseDto entranceHouseDto, long houseId){
        for(EntranceHousePeopleDto peopleDto: entranceHouseDto.getHousePeopleList()){
            EntranceHousePeopleEntity entity = new EntranceHousePeopleEntity();
            entity.setId(IdWorker.getId());
            entity.setHouseId(houseId);
            entity.setName(peopleDto.getName());
            entity.setRelation(peopleDto.getRelation());
            housePeopleMapper.insert(entity);
        }
    }

    /**
     * 插入文件
     * @param entranceHouseDto
     * @param houseId
     */
    public void insetHouseFiel(CreateEntranceHouseDto entranceHouseDto, long houseId){
        for(EntranceHouseFileDto fileDto: entranceHouseDto.getFileList()){
            EntranceHouseFileEntity entity = new EntranceHouseFileEntity();
            entity.setId(IdWorker.getId());
            entity.setHouseId(houseId);
            entity.setFileId(fileDto.getFileId());
            entity.setType(fileDto.getType());
            entity.setSubType(fileDto.getSubType());
            entity.setChildType(fileDto.getChildType());
            entity.setSortNum(fileDto.getSortNum());
            houseFileMapper.insert(entity);
        }
    }

    /**
     * 插入文件
     * @param entranceHouseDto
     * @param houseId
     */
    public void insetHouseFiel(UpdateEntranceHouseDto entranceHouseDto, long houseId){
        for(EntranceHouseFileDto fileDto: entranceHouseDto.getFileList()){
            EntranceHouseFileEntity entity = new EntranceHouseFileEntity();
            entity.setId(IdWorker.getId());
            entity.setHouseId(houseId);
            entity.setFileId(fileDto.getFileId());
            entity.setType(fileDto.getType());
            entity.setSubType(fileDto.getSubType());
            entity.setChildType(fileDto.getChildType());
            entity.setSortNum(fileDto.getSortNum());
            houseFileMapper.insert(entity);
        }
    }

    @Override
    public ResponseDataResult getEntranceHouseInfo(String appliId) {
        EntranceHouseVo entranceHouseInfo = entranceHouseMapper.getEntranceHouseInfo(appliId);
        if(null == entranceHouseInfo){
            return  ResponseUtil.SUCCESS("查询数据为空");
        }
        GetHouseFileListDto fileListDto = new GetHouseFileListDto();
        entranceHouseInfo.setHouseFileList(houseFileMapper.getHouseFileList(entranceHouseInfo.getId()));
        entranceHouseInfo.setHousePeopleList(housePeopleMapper.getEntranceHousePeopleList(Long.valueOf(entranceHouseInfo.getId())));
        return ResponseUtil.SUCCESS(entranceHouseInfo);
    }

    @Override
    public ResponseResult modifyEntranceHouseStatus(String id, int status) {
        int n = entranceHouseMapper.modifyEntranceHouseStatus(Long.valueOf(id), status);
        if (n > 0) {
            return ResponseUtil.SUCCESS();
        }
        return ResponseUtil.FAIL();
    }

    @Override
    public ResponseDataResult getEntranceHouseStatus(String appliId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("appli_id", appliId);
        EntranceHouseEntity entity = entranceHouseMapper.selectOne(wrapper);
        Map<String, Integer> data = new HashMap<>();
        data.put("status", entity != null?entity.getStatus(): 0);
        return ResponseUtil.SUCCESS(data);
    }
}
