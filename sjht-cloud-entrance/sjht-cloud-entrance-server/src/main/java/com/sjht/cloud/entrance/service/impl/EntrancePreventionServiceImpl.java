package com.sjht.cloud.entrance.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.sjht.cloud.entrance.api.dto.CreateEntrancePreventionFileDto;
import com.sjht.cloud.entrance.api.dto.CreatePreventionDto;
import com.sjht.cloud.entrance.api.dto.UpdatePreventionDto;
import com.sjht.cloud.entrance.api.vo.EntrancePreventionVO;
import com.sjht.cloud.entrance.api.vo.GetEntrancePreventionFileVo;
import com.sjht.cloud.entrance.constant.EntranceConstant;
import com.sjht.cloud.entrance.dao.EntrancePreventionFileMapper;
import com.sjht.cloud.entrance.dao.EntrancePreventionMapper;
import com.sjht.cloud.entrance.entity.EntrancePreventionEntity;
import com.sjht.cloud.entrance.entity.EntrancePreventionFileEntity;
import com.sjht.cloud.entrance.service.EntranceFileInfoService;
import com.sjht.cloud.entrance.service.EntrancePreventionService;
import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import com.sjht.cloud.framework.common.entity.response.ResponseResult;
import com.sjht.cloud.framework.common.entity.response.ResponseUtil;
import com.sjht.cloud.framework.common.enums.CommonCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ***************************************************
 * @ClassName EntrancePreventionServiceImpl
 * @Description 描述
 * @Author maojianyun
 * @Date 2020/3/18 16:10
 * @Version V1.0
 * ****************************************************
 **/
@Service
public class EntrancePreventionServiceImpl implements EntrancePreventionService {

    @Autowired
    private EntrancePreventionMapper entrancePreventionMapper;

    @Autowired
    private EntrancePreventionFileMapper entrancePreventionFileMapper;

    @Autowired
    private EntranceFileInfoService fileInfoService;

    @Transactional
    @Override
    public ResponseResult createPrevention(CreatePreventionDto preventionDto) { //从申请ID和文件列表得到实体
        EntrancePreventionEntity entity = new EntrancePreventionEntity();   //new entrance_prevention       申请ID和状态
        long id = IdWorker.getId();//工具类生成主键
        entity.setId(id);//设置主键
        entity.setAppliId(Long.valueOf(preventionDto.getAppliId()));//设置申请ID
        entity.setStatus(1);//设置状态为草稿
        entrancePreventionMapper.insert(entity);//插入entrance_prevention
        for (CreateEntrancePreventionFileDto fileDto: preventionDto.getFileDtos()){//遍历上传的文件
            EntrancePreventionFileEntity entity1 = new EntrancePreventionFileEntity();//new entrance_prevention_file
            entity1.setId(IdWorker.getId()); //工具内生成主键
            entity1.setPreId(id);//设置接种ID
            entity1.setFileId(fileDto.getFileId());//设置文件ID
            entity1.setType(fileDto.getType());//设置接种类型
            entity1.setSortNum(fileDto.getSortNum());//设置上传序列
            entrancePreventionFileMapper.insert(entity1);//插入 entrance_prevention_file
        }
        return ResponseUtil.SUCCESS();
    }

    @Override
    public ResponseDataResult<EntrancePreventionVO> getEntrancePreventionInfo(String appliId) {
        EntrancePreventionVO preventionVO = new EntrancePreventionVO();
        // 得到接种信息
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("appli_id", appliId);
        EntrancePreventionEntity entity = entrancePreventionMapper.selectOne(wrapper);
        preventionVO.setId(String.valueOf(entity.getId()));
        preventionVO.setAppliId(String.valueOf(entity.getAppliId()));
        preventionVO.setStatus(entity.getStatus());
        preventionVO.setFeedback(entity.getFeedback());
        // 得到文件列表
        QueryWrapper wrapper2 = new QueryWrapper();
        wrapper2.eq("pre_id", entity.getId());
        List<EntrancePreventionFileEntity> list = entrancePreventionFileMapper.selectList(wrapper2);
        List<GetEntrancePreventionFileVo> fileVos = new ArrayList<>();
        for (EntrancePreventionFileEntity entity1: list){
            GetEntrancePreventionFileVo fileVo = new GetEntrancePreventionFileVo();
            fileVo.setId(String.valueOf(entity1.getId()));
            fileVo.setFileId(entity1.getFileId());
            fileVo.setSortNum(entity1.getSortNum());
            fileVo.setType(entity1.getType());
            fileVos.add(fileVo);
        }
        preventionVO.setFileList(fileVos);
        return ResponseUtil.SUCCESS(preventionVO);
    }

    @Transactional
    @Override
    public ResponseResult updatePrevention(UpdatePreventionDto preventionDto) {
        EntrancePreventionEntity entity = new EntrancePreventionEntity();
        entity.setId(Long.valueOf(preventionDto.getId()));
        entity.setAppliId(Long.valueOf(preventionDto.getAppliId()));
        entity.setStatus(EntranceConstant.CommonConstant.status_draft);//修改后改为 待提交
        entrancePreventionMapper.updateById(entity);
        for (CreateEntrancePreventionFileDto fileDto: preventionDto.getFileDtos()){
            EntrancePreventionFileEntity entity1 = new EntrancePreventionFileEntity();
            entity1.setId(IdWorker.getId());
            entity1.setPreId(Long.valueOf(preventionDto.getId()));
            entity1.setFileId(fileDto.getFileId());
            entity1.setType(fileDto.getType());
            entity1.setSortNum(fileDto.getSortNum());
            entrancePreventionFileMapper.insert(entity1);
        }
        return ResponseUtil.SUCCESS();
    }

    @Override
    public ResponseDataResult getEntrancePreventionStatus(String appliId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("appli_id", appliId);
        EntrancePreventionEntity entity = entrancePreventionMapper.selectOne(wrapper); //在实体中根据申请ID获取一条记录
        if (null == entity){
            return ResponseUtil.FAILDATA(CommonCode.NULL);
        }
        Map<String, Integer> data = new HashMap<>();
        data.put("status", entity.getStatus());//放入中
        return ResponseUtil.SUCCESS(data);//返回数据
    }

    @Override
    public ResponseResult updateStatus(long id, int status) {
        entrancePreventionMapper.updateStatus(id, status);
        return ResponseUtil.SUCCESS();
    }

    @Transactional
    @Override
    public ResponseResult deleteEntrancePreventionFile(String id) {
        EntrancePreventionFileEntity entity = entrancePreventionFileMapper.selectById(id);
        int n = entrancePreventionFileMapper.deleteById(id);
        if (n > 0) {
            fileInfoService.deleFile(entity.getFileId());
        }
        return ResponseUtil.SUCCESS();
    }
}
