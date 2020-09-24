package com.sjht.cloud.entrance.service;

import com.sjht.cloud.entrance.api.dto.CreateEntranceHouseDto;
import com.sjht.cloud.entrance.api.dto.UpdateEntranceHouseDto;
import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import com.sjht.cloud.framework.common.entity.response.ResponseResult;

/**
 * ***************************************************
 * @ClassName EntranceHouseService
 * @Description 入学房产
 * @Author maojianyun
 * @Date 2020/3/5 13:49
 * @Version V1.0
 * ****************************************************
 **/
public interface EntranceHouseService {

    /**
     * 创建房产
     * @param entranceHouseDto
     * @return
     */
    ResponseResult createEntranceHouse(CreateEntranceHouseDto entranceHouseDto);

    ResponseResult updateEntranceHouse(UpdateEntranceHouseDto entranceHouseDto);

    /**
     * 得到房产id
     * @param appliId
     * @return
     */
    ResponseDataResult getEntranceHouseInfo(String appliId);

    /**
     * 审核修改房产状态
     * @param id
     * @param status
     * @return
     */
    ResponseResult modifyEntranceHouseStatus(String id, int status);

    /**
     * 查询申请的转台
     * @param appliId
     * @return
     */
    ResponseDataResult getEntranceHouseStatus(String appliId);
}
