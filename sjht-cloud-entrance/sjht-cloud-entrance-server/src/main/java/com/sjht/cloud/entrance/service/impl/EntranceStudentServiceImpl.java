package com.sjht.cloud.entrance.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.sjht.cloud.entrance.api.dto.EntranceStudentDto;
import com.sjht.cloud.entrance.api.dto.EntranceStudentFileDto;
import com.sjht.cloud.entrance.api.dto.UpdateEntranceStudentDto;
import com.sjht.cloud.entrance.api.vo.EntranceStudentFileVo;
import com.sjht.cloud.entrance.api.vo.EntranceStudentVo;
import com.sjht.cloud.entrance.constant.EntranceConstant;
import com.sjht.cloud.entrance.dao.EntranceStudentFileMapper;
import com.sjht.cloud.entrance.dao.EntranceStudentMapper;
import com.sjht.cloud.entrance.entity.EntranceHouseEntity;
import com.sjht.cloud.entrance.entity.EntranceStudentEntity;
import com.sjht.cloud.entrance.entity.EntranceStudentFileEntity;
import com.sjht.cloud.entrance.service.EntranceStudentService;
import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import com.sjht.cloud.framework.common.entity.response.ResponseResult;
import com.sjht.cloud.framework.common.entity.response.ResponseUtil;
import com.sjht.cloud.framework.common.enums.CommonCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ***************************************************
 *
 * @ClassName EntranceStudentServiceImpl
 * @Description
 * @Author 张弛
 * @Date 2020/4/15 9:30
 * @Version V1.0
 * ****************************************************
 **/
@Service
public class EntranceStudentServiceImpl implements EntranceStudentService {
    @Autowired
    private EntranceStudentMapper entranceStudentMapper;
    @Autowired
    private EntranceStudentFileMapper entranceStudentFileMapper;

    @Transactional
    @Override
    public ResponseResult apply(EntranceStudentDto entranceStudentDto) {
        EntranceStudentEntity es=new EntranceStudentEntity();
        long StudentId =IdWorker.getId();
        es.setId(StudentId);//设置主键
        es.setAppliId(Long.valueOf(entranceStudentDto.getAppliId()));
        es.setOutSchoolName(entranceStudentDto.getOutSchoolName());//转出学校名
        es.setStudentNum(Long.parseLong(entranceStudentDto.getStudentNum()));//学籍号
        es.setIsHealth(entranceStudentDto.getIsHealth());//是否健康
        es.setIsHealthForm(entranceStudentDto.getIsHealthForm());//是否有转出学校的健康证明
        es.setCreateTime(new Date());
        es.setUpdateTime(new Date());
        es.setStatus(EntranceConstant.CommonConstant.status_draft);

        for (EntranceStudentFileDto esfd:entranceStudentDto.getFileDtos()){
            EntranceStudentFileEntity file=new EntranceStudentFileEntity();
            file.setId(IdWorker.getId());
            file.setFileId(esfd.getFileId());
            file.setType(esfd.getType());
            file.setStudentId(StudentId);
            file.setCreateTime(new Date());
            entranceStudentFileMapper.insert(file);
        }
        entranceStudentMapper.insert(es);
        //String id =String.valueOf(StudentId);//避免精度丢失
        return ResponseUtil.SUCCESS();
    }

    @Override
    @Transactional
    public ResponseResult updateApply(UpdateEntranceStudentDto updateEntranceStudentDto) {
        EntranceStudentEntity es=new EntranceStudentEntity();
        es.setId(Long.parseLong(updateEntranceStudentDto.getId()));//设置主键
        es.setOutSchoolName(updateEntranceStudentDto.getOutSchoolName());//转出学校名
        es.setStudentNum(Long.parseLong(updateEntranceStudentDto.getStudentNum()));//学籍号
        es.setIsHealth(updateEntranceStudentDto.getIsHealth());//是否健康
        es.setIsHealthForm(updateEntranceStudentDto.getIsHealthForm());//是否有转出学校的健康证明
        es.setStatus(EntranceConstant.CommonConstant.status_draft);//只要生更改了信息，状态都改为待提交
        entranceStudentFileMapper.delEntranceStudentFile(updateEntranceStudentDto.getId());//设置关联文件为删除
        for (EntranceStudentFileDto esfd:updateEntranceStudentDto.getFileDtos()){
            EntranceStudentFileEntity file=new EntranceStudentFileEntity();
            file.setId(IdWorker.getId());
            file.setFileId(esfd.getFileId());
            file.setType(esfd.getType());
            file.setStudentId(Long.parseLong(updateEntranceStudentDto.getId()));
            file.setCreateTime(new Date());
            entranceStudentFileMapper.insert(file);
        }
        entranceStudentMapper.updateById(es);
        return ResponseUtil.SUCCESS();
    }

    @Override
    @Transactional
    public ResponseDataResult queryApply(String appliId) {
        //通过appliId 获取 entrance_student 全部信息
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("appli_id", appliId);
        EntranceStudentEntity entity =entranceStudentMapper.selectOne(wrapper);
        if(null == entity){
            return  ResponseUtil.FAILDATA(CommonCode.NULL);
        }
        EntranceStudentVo entranceStudentVo=entranceStudentMapper.getEntranceStudentInfo(entity.getId());
        if(null == entranceStudentVo){
            return  ResponseUtil.FAILDATA(CommonCode.NULL);
        }
        //通过主键ID获取关联文件信息 order by type
        List<EntranceStudentFileVo> entranceStudentFileList= entranceStudentFileMapper.getEntranceStudentFileList(entity.getId());
        //set 关联信息
        entranceStudentVo.setEntranceStudentFileList(entranceStudentFileList);
        return ResponseUtil.SUCCESS(entranceStudentVo);
    }
    @Override
    @Transactional
    public ResponseResult modifyStatus(String id, int status) {
        entranceStudentMapper.modifyStatus(id,status);
        return ResponseUtil.SUCCESS();
    }

    @Override
    @Transactional
    public ResponseDataResult queryStatus(String appliId) {
        //通过appliId 获取 entrance_student 全部信息
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("appli_id", appliId);
        EntranceStudentEntity entity =entranceStudentMapper.selectOne(wrapper);
        Map<String, Integer> data = new HashMap<>();
        data.put("status", entity != null?entity.getStatus(): 0);
        return ResponseUtil.SUCCESS(data);
    }
}
