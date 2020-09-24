package com.sjht.cloud.entrance.service;

import com.sjht.cloud.entrance.api.dto.AuditAppDetailDto;
import com.sjht.cloud.entrance.api.dto.CreateAuditLogDto;
import com.sjht.cloud.entrance.api.dto.GetAppDetailDto;
import com.sjht.cloud.entrance.api.dto.GetAppListDto;
import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import com.sjht.cloud.framework.common.entity.response.ResponseResult;

/**
 * ***************************************************
 * @ClassName EntranceAuditLogService
 * @Description 审核日志
 * @Author maojianyun
 * @Date 2020/3/9 13:27
 * @Version V1.0
 * ****************************************************
 **/
public interface EntranceAuditLogService {
    //入学申请-获取列表-带分页"
    ResponseDataResult getAppList(GetAppListDto getAppListDto);

    //入学申请-获取详情"
    ResponseDataResult getAppDetail(GetAppDetailDto getAppDetailDto);

    //入学申请-审批结果录入"
    ResponseResult auditAppDetail(AuditAppDetailDto auditAppDetailDto);

    /**
     * 创建审核日志
     * @param auditLogDto
     * @return
     */
    ResponseResult createAuditLog(CreateAuditLogDto auditLogDto);

    /**
     * 修改状态
     * @param id
     * @param status
     * @return
     */
    ResponseResult updateAuditLogStatus(String id, int status);

    /**
     * 根据申请id到审核的内容
     * @param appliId
     * @param status
     * @return
     */
    ResponseDataResult getAuditLogContent(String appliId, int status);

    /**
     * 得到审核的状态
     * @param id
     * @return
     */
    ResponseDataResult getAuditStatus(String id);
}
