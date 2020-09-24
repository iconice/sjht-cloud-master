package com.sjht.cloud.entrance.service;

import com.sjht.cloud.entrance.api.dto.EntranceBaseDto;
import com.sjht.cloud.entrance.api.dto.UpdateEntranceBaseDto;
import com.sjht.cloud.framework.common.entity.response.Response;
import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import com.sjht.cloud.framework.common.entity.response.ResponseResult;

/**
 * ***************************************************
 * @ClassName EntranceBaseService
 * @Description 基本信息
 * @Author maojianyun
 * @Date 2020/3/3 21:57
 * @Version V1.0
 * ****************************************************
 **/
public interface EntranceBaseService {

    /**
     * 创建入学基本信息
     * @param baseDto
     * @return
     */
    ResponseResult createEntranceBase(EntranceBaseDto baseDto);

    /**
     * 查询户口信息
     * @param appliId
     * @return
     */
    ResponseDataResult getEntranceBaseInfo(String appliId);

    /**
     * 删除基本信息
     * @param id
     * @return
     */
    ResponseResult deleteEntranceBase(String id);

    /**
     * 更新基本信息
     * @param baseDto
     * @return
     */
    Response updateEntranceBaseInfo(UpdateEntranceBaseDto baseDto);

    /**
     * 审核修改状态
     * @param id
     * @param status
     * @return
     */
    ResponseResult modifyEntranceBaseStatus(String id, int status);

    /**
     * 查询状态
     * @param appliId
     * @return
     */
    ResponseDataResult getEntranceBaseStatus(String appliId);
}
