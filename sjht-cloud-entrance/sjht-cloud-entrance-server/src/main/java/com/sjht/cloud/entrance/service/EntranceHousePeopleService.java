package com.sjht.cloud.entrance.service;

import com.sjht.cloud.entrance.api.dto.CreateEntranceHousePeopleDto;
import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import com.sjht.cloud.framework.common.entity.response.ResponseResult;

/**
 * ***************************************************
 *
 * @ClassName EntranceHousePeopleService
 * @Description 描述
 * @Author maojianyun
 * @Date 2020/3/5 16:49
 * @Version V1.0
 * ****************************************************
 **/
public interface EntranceHousePeopleService {

    ResponseDataResult getEntranceHousePeopleList(String houseId);

    ResponseResult createEntranceHousePeople(CreateEntranceHousePeopleDto peopleDto);

    ResponseResult deleteEntranceHousePeople(String id);
}
