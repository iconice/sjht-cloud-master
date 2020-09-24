package com.sjht.cloud.entrance.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.sjht.cloud.entrance.api.dto.CreateEntrancePreventionFileDto;
import com.sjht.cloud.entrance.api.vo.GetEntrancePreventionFileVo;
import com.sjht.cloud.entrance.dao.EntrancePreventionFileMapper;
import com.sjht.cloud.entrance.entity.EntrancePreventionFileEntity;
import com.sjht.cloud.entrance.service.EntranceFileInfoService;
import com.sjht.cloud.entrance.service.EntrancePreventionFileService;
import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import com.sjht.cloud.framework.common.entity.response.ResponseResult;
import com.sjht.cloud.framework.common.entity.response.ResponseUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ***************************************************
 * @ClassName PreventionFileServiceImpl
 * @Description 描述
 * @Author maojianyun
 * @Date 2020/3/4 12:00
 * @Version V1.0
 * ****************************************************
 **/
@Service
public class EntrancePreventionFileServiceImpl implements EntrancePreventionFileService {

    @Autowired
    private EntrancePreventionFileMapper preventionFileMapper;

    @Autowired
    private EntranceFileInfoService fileInfoService;


    @Override
    public ResponseResult createEntrancePreventionFile(List<CreateEntrancePreventionFileDto> preventionFileDto) {

        for (CreateEntrancePreventionFileDto fileDto: preventionFileDto) {
            EntrancePreventionFileEntity entity = new EntrancePreventionFileEntity();
            BeanUtils.copyProperties(fileDto, entity);
            entity.setId(IdWorker.getId());
            int n = preventionFileMapper.insert(entity);
        }
        return ResponseUtil.SUCCESS();
    }

    @Override
    public ResponseDataResult getEntrancePreventionFile(String appliId) {
        List<GetEntrancePreventionFileVo> fileVos = preventionFileMapper.getEntrancePreventionFile(Long.valueOf(appliId));
        return  ResponseUtil.SUCCESS(fileVos);
    }

    @Transactional
    @Override
    public ResponseResult deleteEntrancePreventionFile(String id) {
        EntrancePreventionFileEntity entity = preventionFileMapper.selectById(Long.valueOf(id));
        int n = preventionFileMapper.deleteById(id);
        fileInfoService.deleFile(entity.getFileId());
        if (n > 0) {
            ResponseUtil.SUCCESS();
        }
        return ResponseUtil.FAIL();
    }

    @Override
    public ResponseResult modifyEntrancePreventionStatus(String id, int status) {
        int n = preventionFileMapper.modifyEntrancePreventionStatus(Long.valueOf(id), status);
        if (n > 0) {
            ResponseUtil.SUCCESS();
        }
        return ResponseUtil.FAIL();
    }
}
