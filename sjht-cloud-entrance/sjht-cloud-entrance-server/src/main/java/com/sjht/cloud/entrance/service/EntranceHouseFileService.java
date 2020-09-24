package com.sjht.cloud.entrance.service;

import com.sjht.cloud.entrance.api.dto.CreateEntranceHouseFileDto;
import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import com.sjht.cloud.framework.common.entity.response.ResponseResult;

/**
 * ***************************************************
 * @ClassName EntranceHouseFileService
 * @Description 描述
 * @Author maojianyun
 * @Date 2020/3/5 16:10
 * @Version V1.0
 * ****************************************************
 **/
public interface EntranceHouseFileService {

    /**
     * 删除文件
     * @param id
     * @return
     */
    ResponseResult deleteHouseFile(String id);

    /**
     * 创建文件
     * @param houseFileDto
     * @return
     */
    ResponseDataResult createHouseFile(CreateEntranceHouseFileDto houseFileDto);
}
