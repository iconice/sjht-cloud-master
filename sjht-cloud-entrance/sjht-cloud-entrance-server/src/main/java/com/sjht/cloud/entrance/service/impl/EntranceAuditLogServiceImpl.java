package com.sjht.cloud.entrance.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.sjht.cloud.entrance.api.dto.AuditAppDetailDto;
import com.sjht.cloud.entrance.api.dto.CreateAuditLogDto;
import com.sjht.cloud.entrance.api.dto.GetAppDetailDto;
import com.sjht.cloud.entrance.api.dto.GetAppListDto;
import com.sjht.cloud.entrance.api.vo.*;
import com.sjht.cloud.entrance.constant.EntranceConstant;
import com.sjht.cloud.entrance.dao.*;
import com.sjht.cloud.entrance.entity.*;
import com.sjht.cloud.entrance.dao.EntranceApplicationMapper;
import com.sjht.cloud.entrance.dao.EntranceAuditLogMapper;
import com.sjht.cloud.entrance.entity.EntranceApplicationEntity;
import com.sjht.cloud.entrance.entity.EntranceAuditLogEntity;
import com.sjht.cloud.entrance.entity.extend.TempPOJO;
import com.sjht.cloud.entrance.service.EntranceAuditLogService;
import com.sjht.cloud.framework.common.constant.CommonCanstant;
import com.sjht.cloud.framework.common.entity.response.PageResult;
import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import com.sjht.cloud.framework.common.entity.response.ResponseResult;
import com.sjht.cloud.framework.common.entity.response.ResponseUtil;
import com.sjht.cloud.framework.common.enums.CommonCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ***************************************************
 * @ClassName EntranceAuditLogServiceImpl
 * @Description 描述
 * @Author maojianyun
 * @Date 2020/3/9 13:27
 * @Version V1.0
 * ****************************************************
 **/
@Slf4j
@Service
public class EntranceAuditLogServiceImpl implements EntranceAuditLogService {

    @Autowired
    private EntranceAuditLogMapper auditLogMapper;

    @Autowired
    private EntranceApplicationMapper entranceApplicationMapper;

    @Autowired
    private EntranceBaseMapper entranceBaseMapper;

    @Autowired
    private EntranceHouseMapper entranceHouseMapper;

    @Autowired
    private EntrancePreventionMapper entrancePreventionMapper;

    @Autowired
    private EntranceStudentMapper entranceStudentMapper;

    @Autowired
    private EntrancePreventionFileMapper entrancePreventionFileMapper;

    @Autowired
    EntranceHouseServiceImpl entranceHouseService;

    @Autowired
    EntrancePreventionServiceImpl entrancePreventionService;

    @Autowired
    EntranceStudentServiceImpl entranceStudentService;


    @Override
    public ResponseResult createAuditLog(CreateAuditLogDto auditLogDto) {
        EntranceAuditLogEntity entity = new EntranceAuditLogEntity();
        entity.setId(IdWorker.getId());
        entity.setContent(auditLogDto.getContent());
        entity.setStatus(auditLogDto.getStatus());
        int n = auditLogMapper.insert(entity);
        if (n > 0) {
            return ResponseUtil.SUCCESS();
        }
        return ResponseUtil.FAIL();
    }

    @Override
    public ResponseResult updateAuditLogStatus(String id, int status) {
        int n = auditLogMapper.updateAuditLogStatus(Long.valueOf(id), status);
        if (n > 0) {
            return ResponseUtil.SUCCESS();
        }
        return ResponseUtil.FAIL();
    }

    @Override
    public ResponseDataResult getAuditLogContent(String appliId, int status) {
        String countent = auditLogMapper.getAuditLogContent(Long.valueOf(appliId), status);
        if (countent != null) {
            return ResponseUtil.SUCCESS(countent);
        }
        return ResponseUtil.SUCCESS(CommonCode.NULL, null);
    }

    @Override
    public ResponseDataResult getAuditStatus(String id) {
        EntranceApplicationEntity appEntity =entranceApplicationMapper.selectById(id);
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("appli_id", id);
        if (1 == appEntity.getType()) {
            EntranceBaseEntity baseEntity = entranceBaseMapper.selectOne(wrapper);
            EntranceHouseEntity houseEntity = entranceHouseMapper.selectOne(wrapper);
            EntrancePreventionEntity preventionEntity = entrancePreventionMapper.selectOne(wrapper);
            if (EntranceConstant.CommonConstant.status_audit_yes == baseEntity.getStatus()
                    && EntranceConstant.CommonConstant.status_audit_yes ==houseEntity.getStatus()
                    && EntranceConstant.CommonConstant.status_audit_yes ==preventionEntity.getStatus() ){
                auditLogMapper.updateAuditLogStatus(Long.valueOf(id), EntranceConstant.CommonConstant.status_audit_yes);
            }
        }
        if (2 == appEntity.getType()){
            EntranceBaseEntity baseEntity = entranceBaseMapper.selectOne(wrapper);
            EntranceHouseEntity houseEntity = entranceHouseMapper.selectOne(wrapper);
            EntrancePreventionEntity preventionEntity = entrancePreventionMapper.selectOne(wrapper);
            EntranceStudentEntity studentEntity= entranceStudentMapper.selectOne(wrapper);
            if (EntranceConstant.CommonConstant.status_audit_yes == baseEntity.getStatus()
                    && EntranceConstant.CommonConstant.status_audit_yes ==houseEntity.getStatus()
                    && EntranceConstant.CommonConstant.status_audit_yes ==preventionEntity.getStatus()
                    && EntranceConstant.CommonConstant.status_audit_yes ==studentEntity.getStatus()){
                auditLogMapper.updateAuditLogStatus(Long.valueOf(id), EntranceConstant.CommonConstant.status_audit_yes);
            }
        }
        Map<String, String> data = new HashMap<>();
        String status = auditLogMapper.getAuditStatus(id);
        data.put("status", status);
        return ResponseUtil.SUCCESS(data);
    }
//  得到申请列表
    @Override
    public ResponseDataResult getAppList(GetAppListDto getAppListDto) {
        PageResult<EntranceApplication2Vo> result = new PageResult<EntranceApplication2Vo>();
        //查询总数
        int total=entranceApplicationMapper.getTotalNum(getAppListDto);

        //重新计算偏移量
        getAppListDto.setOffset((getAppListDto.getOffset()-1)*getAppListDto.getPageSize());
        List<EntranceApplication2Vo> list = entranceApplicationMapper.getAppListByCondition( getAppListDto);

        result.setList(list);
        result.setTotal(total);
        return ResponseUtil.SUCCESS(result);
    }

//   得到申请详情
    @Override
    public ResponseDataResult getAppDetail(GetAppDetailDto getAppDetailDto) {
        int type=getAppDetailDto.getType();
        //0-户籍申请详情 1-房产详情 2-疫苗详情 3-转学详情
        if(type==0){
            EntranceBaseVo entranceBaseVo= entranceBaseMapper.getEntranceBaseInfo(getAppDetailDto.getAppid());
            return ResponseUtil.SUCCESS(entranceBaseVo);
        }else if(type==1){
            return entranceHouseService.getEntranceHouseInfo(getAppDetailDto.getAppid());
        }else if(type==2){
            return entrancePreventionService.getEntrancePreventionInfo(getAppDetailDto.getAppid());
        }else if(type==3){
            return entranceStudentService.queryApply(getAppDetailDto.getAppid());
        }else{
            return ResponseUtil.FAILDATA(CommonCode.INVALID_PARAM);
        }

    }
//  写入申请结果及反馈
    @Override
    public ResponseResult auditAppDetail(AuditAppDetailDto auditAppDetailDto) {
        String appid=auditAppDetailDto.getAppid();
        if(0 ==auditAppDetailDto.getType()){
            entranceBaseMapper.updateAudit(auditAppDetailDto);
            updateLastStatus(appid);
            return ResponseUtil.SUCCESS();
        }
        if(1 ==auditAppDetailDto.getType()){
            entranceHouseMapper.updateAudit(auditAppDetailDto);
            updateLastStatus(appid);
            return ResponseUtil.SUCCESS();
        }
        if(2 ==auditAppDetailDto.getType()){
            entrancePreventionMapper.updateAudit(auditAppDetailDto);
            updateLastStatus(appid);
            return ResponseUtil.SUCCESS();
        }
        if(3 ==auditAppDetailDto.getType()){
            entranceStudentMapper.updateAudit(auditAppDetailDto);
            updateLastStatus(appid);
            return ResponseUtil.SUCCESS();
        }
        else {
            return ResponseUtil.FAIL();
        }
    }

    /**根据申请编号查询对应的子申请信息审核状态，汇总所有状态后根据情况更新申请状态*/
    public void updateLastStatus(String appId){
        log.info("开始更新主申请状态...");
        TempPOJO tempPOJO =entranceApplicationMapper.getSubStatusesById(Long.valueOf(appId));
        if(tempPOJO==null){
            log.error("找不到该申请记录{}",appId);
            return;
        }
        log.info("{} {} {} {} {} {}",tempPOJO.getStatus(),tempPOJO.getType(),tempPOJO.getStatusBase(),tempPOJO.getStatusHouse(),
                tempPOJO.getStatusPre(),tempPOJO.getStatusStu());

        int status=tempPOJO.getStatus();//申请主状态 2-待审核、3-审核不通过、4-审核通过
        int type=tempPOJO.getType();//申请类型 1-入学、2-转学',
        int status_base=tempPOJO.getStatusBase();//户籍申请状态
        int status_house=tempPOJO.getStatusHouse();//房产申请状态
        int status_pre=tempPOJO.getStatusPre();//疫苗申请状态
        int status_stu=tempPOJO.getStatusStu();//转学申请状态

        //审核不通过
        if(3==status_base||3==status_house||3==status_pre||3==status_stu){
            log.info("不通过");
            status=3;
        }
        //审核通过
        if("1".equals(type)){//入学只需要三个审批表
            if(4==status_base&&4==status_house&&4==status_pre){
                log.info("通过");
                status=4;
            }
        }else if("2".equals(type)) {//转学需要四个审批表
            if (4==status_base && 4==status_house && 4==status_pre && 4==status_stu) {
                log.info("通过");
                status = 4;
            }
        }

        if(3==status|| 4==status){//更新状态
            entranceApplicationMapper.updateStatus(Long.valueOf(appId),status);
        }
    }
}
