package com.sjht.cloud.entrance.service;

import com.sjht.cloud.entrance.api.dto.CreateEntrancePreventionFileDto;
import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import com.sjht.cloud.framework.common.entity.response.ResponseResult;

import java.util.List;

/**
 * ***************************************************
 * @ClassName EntrancePreventionFileService
 * @Description 查验证明
 * @Author maojianyun
 * @Date 2020/3/4 11:59
 * @Version V1.0
 * ****************************************************
 **/
public interface EntrancePreventionFileService {

    /**
     * 创建检验、查验文件
     * @param preventionFileDto
     * @return
     */
    ResponseResult createEntrancePreventionFile(List<CreateEntrancePreventionFileDto> preventionFileDto);

    /**
     * 得到列表
     * @param appliId
     * @return
     */
    ResponseDataResult getEntrancePreventionFile(String appliId);

    /**
     * 删除
     * @param id
     * @return
     */
    ResponseResult deleteEntrancePreventionFile(String id);

    /**
     * 审核查验证明时修改状态
     * @param id
     * @param status
     * @return
     */
    ResponseResult modifyEntrancePreventionStatus(String id, int status);
}
