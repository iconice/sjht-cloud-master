package com.sjht.cloud.entrance.service;

import com.sjht.cloud.entrance.api.dto.CreatePreventionDto;
import com.sjht.cloud.entrance.api.dto.UpdatePreventionDto;
import com.sjht.cloud.entrance.api.vo.EntrancePreventionVO;
import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import com.sjht.cloud.framework.common.entity.response.ResponseResult;
import org.apache.ibatis.annotations.Param;

/**
 * ***************************************************
 * @ClassName EntrancePreventionService
 * @Description 描述
 * @Author maojianyun
 * @Date 2020/3/18 16:10
 * @Version V1.0
 * ****************************************************
 **/
public interface EntrancePreventionService {

    /**
     * 添加
     * @param preventionDto
     * @return
     */
    ResponseResult createPrevention(CreatePreventionDto preventionDto);

    /**
     * 得到信息
     * @param appliId
     * @return
     */
    ResponseDataResult<EntrancePreventionVO> getEntrancePreventionInfo(String appliId);

    /**
     * 得到其状态
     * @param appliId
     * @return
     */
    ResponseDataResult getEntrancePreventionStatus(String appliId);

    /**
     * 更新接种证明
     * @param preventionDto
     * @return
     */
    ResponseResult updatePrevention(UpdatePreventionDto preventionDto);

    /**
     * 删除文件
     * @param id
     * @return
     */
    ResponseResult deleteEntrancePreventionFile(String id);

    /**
     * 修改状态
     * @param id
     * @param status
     * @return
     */
    ResponseResult updateStatus(@Param("id")long id, @Param("status")int status);
}
