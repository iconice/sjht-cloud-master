package com.sjht.cloud.entrance.service;

import com.sjht.cloud.entrance.api.dto.CreateRegionAddDto;
import com.sjht.cloud.entrance.api.dto.UpdateRegionAddDto;
import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import com.sjht.cloud.framework.common.entity.response.ResponseResult;

/**
 * ***************************************************
 * @ClassName ThreeCounterpartRegionService
 * @Description 三对口区域
 * @Author maojianyun
 * @Date 2020/1/8 10:56
 * @Version V1.0
 * ****************************************************
 **/
public interface ThreeCounterpartRegionService {

    /**
     * 创建区域地址
     * @param regionAddDto
     * @return
     */
    ResponseResult createRegionAdd(CreateRegionAddDto regionAddDto);

    /**
     * 删除小区
     * @param id
     * @return
     */
    ResponseResult deleteRegionAdd(long id);

    /**
     * 得到列表
     * @return
     */
    ResponseDataResult getRegionAddList();

    /**
     * 更新提交
     * @param regionAddDto
     * @return
     */
    ResponseResult updateRegionAdd(UpdateRegionAddDto regionAddDto);
}
