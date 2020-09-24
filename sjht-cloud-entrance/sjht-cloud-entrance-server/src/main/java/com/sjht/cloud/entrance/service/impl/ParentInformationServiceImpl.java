package com.sjht.cloud.entrance.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.sjht.cloud.entrance.api.dto.UpdateParentInfoListDto;
import com.sjht.cloud.entrance.api.dto.UpdateParentInformationDto;
import com.sjht.cloud.entrance.api.vo.ParentInformationVo;
import com.sjht.cloud.entrance.dao.ParentsInfoMapper;
import com.sjht.cloud.entrance.entity.ParentsInfoEntity;
import com.sjht.cloud.entrance.service.ParentInformationService;
import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import com.sjht.cloud.framework.common.entity.response.ResponseResult;
import com.sjht.cloud.framework.common.entity.response.ResponseUtil;
import com.sjht.cloud.framework.common.enums.CommonCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * ***************************************************
 *
 * @ClassName ParentInformationServiceImpl
 * @Description 描述
 * @Author 张弛
 * @Date 2020/3/25 16:47
 * @Version V1.0
 * ****************************************************
 **/
@Service
public class ParentInformationServiceImpl implements ParentInformationService {
    @Autowired
    private ParentsInfoMapper parentsInfoMapper;

    @Transactional
    @Override
    public ResponseResult updateParentInformation(UpdateParentInfoListDto updateParentInfoListDto) {
        parentsInfoMapper.delParentInfoByUserId(updateParentInfoListDto.getUserId());
        for (UpdateParentInformationDto list : updateParentInfoListDto.getParentInfoList()) {
            ParentsInfoEntity entity = new ParentsInfoEntity();
            if (null == list) {
               return ResponseUtil.FAIL(CommonCode.NULL);
            }
            entity.setId(IdWorker.getId());
            entity.setRelations(list.getRelations());//字符串转整型
            entity.setUserId(Long.parseLong(updateParentInfoListDto.getUserId()));//字符串转Long
            entity.setName(list.getName());
            entity.setWorkUnits(list.getWorkUnits());
            entity.setDep(list.getDep());
            entity.setWorkUnitsTell(list.getWorkUnitsTell());
            entity.setTell(list.getTell());
            parentsInfoMapper.insert(entity);
        }
        return ResponseUtil.SUCCESS();
    }

    @Transactional
    @Override
    public ResponseDataResult getParentInformation(String userId) {
        List<ParentInformationVo> parentInformationVo=parentsInfoMapper.getParentInfo(userId);
        if (null == parentInformationVo || 0==parentInformationVo.size()){
            return ResponseUtil.FAILDATA(CommonCode.NULL);
        }
        return ResponseUtil.SUCCESS(parentInformationVo);
    }

    @Transactional
    @Override
    public ResponseResult deleteParentInformation(String id) {
        ParentsInfoEntity parentsInfoEntity=parentsInfoMapper.selectById(id);
        if (null == parentsInfoEntity){
        return ResponseUtil.FAIL(CommonCode.NULL);
        }
        parentsInfoMapper.deleteById(id);
        return ResponseUtil.SUCCESS();
    }



}
