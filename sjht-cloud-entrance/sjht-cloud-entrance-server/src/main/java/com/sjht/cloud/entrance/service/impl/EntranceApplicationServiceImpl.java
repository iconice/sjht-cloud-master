package com.sjht.cloud.entrance.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.sjht.cloud.entrance.api.dto.CreateEntraceAppliactionDto;
import com.sjht.cloud.entrance.api.dto.GetEntraceAppliactionListDto;
import com.sjht.cloud.entrance.api.vo.EntranceApplicationVo;
import com.sjht.cloud.entrance.constant.EntranceConstant;
import com.sjht.cloud.entrance.dao.*;
import com.sjht.cloud.entrance.entity.EntranceApplicationEntity;
import com.sjht.cloud.entrance.service.EntranceApplicationService;
import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import com.sjht.cloud.framework.common.entity.response.ResponseResult;
import com.sjht.cloud.framework.common.entity.response.ResponseUtil;
import com.sjht.cloud.framework.common.enums.CommonCode;
import com.sjht.cloud.framework.common.exception.ExceptionCast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ***************************************************
 * @ClassName EntranceApplicationServiceImpl
 * @Description 入学接口实现类
 * @Author maojianyun
 * @Date 2020/3/3 19:41
 * @Version V1.0
 * ****************************************************
 **/
@Service
public class EntranceApplicationServiceImpl implements EntranceApplicationService {

    @Autowired
    private EntranceApplicationMapper applicationMapper;
    @Autowired
    private EntranceBaseMapper entranceBaseMapper;
    @Autowired
    private EntranceHouseMapper entranceHouseMapper;
    @Autowired
    private EntrancePreventionMapper entrancePreventionMapper;
    @Autowired
    private EntranceStudentMapper entranceStudentMapper;

    @Override
    public ResponseDataResult createEntranceApplication(CreateEntraceAppliactionDto createEntraceAppliactionDto) {
        Map<String, String> data = new HashMap<>();
        EntranceApplicationEntity entity = new EntranceApplicationEntity();
        long id = IdWorker.getId();
        entity.setId(id);
        entity.setUserId(Long.valueOf(createEntraceAppliactionDto.getUserId()));
        entity.setStatus(EntranceConstant.CommonConstant.status_draft);
        entity.setType(createEntraceAppliactionDto.getType());
        int n = applicationMapper.insert(entity);
        if (n > 0) {
            data.put("id", String.valueOf(id));
        } else {
            ExceptionCast.cast(CommonCode.FAIL);
        }
        return ResponseUtil.SUCCESS(data);
    }

    @Override
    public ResponseDataResult getEntranceApplicationList(GetEntraceAppliactionListDto entraceAppliactionListDto) {
        Map<String, String> data = new HashMap<>();
        List<EntranceApplicationVo> applicationVos = applicationMapper.getEntranceApplicationList(entraceAppliactionListDto);
        if (applicationVos.size() == 0 || null ==applicationVos) {
            ResponseUtil.SUCCESS(CommonCode.NULL);
        }
        return ResponseUtil.SUCCESS(applicationVos);
    }

    @Transactional
    @Override
    public ResponseResult deleteEntranceApplication(String id) {
        // 删除申请
        int n = applicationMapper.deleteById(id);
        // 删除房产、删除房产文件；删除基本信息、删除节本信息文件；删除查验证明、证明文件
        if (n > 0) {
            return ResponseUtil.SUCCESS();
        }
        return ResponseUtil.FAIL();
    }

    @Override
    public ResponseResult updateTitle(String id, String title) {
        int n = applicationMapper.updateTitle(Long.valueOf(id), title);
        if (n > 0) {
            return ResponseUtil.SUCCESS();
        }
        return ResponseUtil.FAIL();
    }

    @Override
    public ResponseResult updateStatus(String id, int status) {
        EntranceApplicationEntity entity = applicationMapper.selectById(id);
        int n = applicationMapper.updateStatus(Long.valueOf(id), status);
        entranceBaseMapper.modifyEntranceBaseStatus(Long.valueOf(id),2);
        entranceHouseMapper.modifyEntranceHouseStatus(Long.valueOf(id),2);
        entrancePreventionMapper.updateStatus(Long.valueOf(id),2);
        if (2==entity.getType()){
            entranceStudentMapper.modifyStatus(id,2);
        }

        if (n > 0) {
            return ResponseUtil.SUCCESS();
        }
        return ResponseUtil.FAIL();
    }

    @Override
    public ResponseDataResult getApplicationStatus(String appliId) {
        EntranceApplicationEntity entity = applicationMapper.selectById(appliId);
        Map<String, Integer> data = new HashMap<>();
        data.put("status", entity.getStatus());
        return ResponseUtil.SUCCESS(data);
    }
}
