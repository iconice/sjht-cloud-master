package com.sjht.cloud.entrance.service;

import com.sjht.cloud.entrance.api.dto.CreateEntraceAppliactionDto;
import com.sjht.cloud.entrance.api.dto.GetEntraceAppliactionListDto;
import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import com.sjht.cloud.framework.common.entity.response.ResponseResult;

/**
 * ***************************************************
 * @ClassName EntranceApplicationService
 * @Description 入学申请api
 * @Author maojianyun
 * @Date 2020/3/3 19:32
 * @Version V1.0
 * ****************************************************
 **/
public interface EntranceApplicationService {

    /**
     * 创建申请
     * @param createEntraceAppliactionDto
     * @return
     */
    ResponseDataResult createEntranceApplication(CreateEntraceAppliactionDto createEntraceAppliactionDto);

    /**
     * 得到入学申请列表
     * @param entraceAppliactionListDto
     * @return
     */
    ResponseDataResult getEntranceApplicationList(GetEntraceAppliactionListDto entraceAppliactionListDto);

    /**
     * 删除申请、只能删除草稿类型的
     * @param id
     * @return
     */
    ResponseResult deleteEntranceApplication(String id);

    /**
     * 更新申请标题
     * @param id
     * @param title
     * @return
     */
    ResponseResult updateTitle(String id, String title);

    /**
     * 修改申请的总的状态
     * @param id
     * @param status
     * @return
     */
    ResponseResult updateStatus(String id, int status);

    /**
     * 查询申请的状态
     * @param appliId
     * @return
     */
    ResponseDataResult getApplicationStatus(String appliId);
}
