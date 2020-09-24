package com.sjht.cloud.entrance.service;

import com.sjht.cloud.entrance.api.dto.EntranceStudentDto;
import com.sjht.cloud.entrance.api.dto.UpdateEntranceStudentDto;
import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import com.sjht.cloud.framework.common.entity.response.ResponseResult;

/**
 * ***************************************************
 *
 * @ClassName EntranceStudentService
 * @Description
 * @Author 张弛
 * @Date 2020/4/14 15:53
 * @Version V1.0
 * ****************************************************
 **/
public interface EntranceStudentService {
    /*
     * @Author zhangchi
     * @Description 申请转学信息
     * @Date 15:55 2020/4/14
     * @Param [entranceStudentDto]
     * @return com.sjht.cloud.framework.common.entity.response.ResponseResult
     **/
    ResponseResult apply(EntranceStudentDto entranceStudentDto);

    /*
     * @Author zhangchi
     * @Description  更新转学信息
     * @Date 9:07 2020/4/16
     * @Param [entranceStudentDto]
     * @return com.sjht.cloud.framework.common.entity.response.ResponseResult
     **/
    ResponseResult updateApply(UpdateEntranceStudentDto updateEntranceStudentDto);

    /*
     * @Author zhangchi
     * @Description 查询申请信息
     * @Date 9:09 2020/4/16
     * @Param [entranceStudentDto]
     * @return com.sjht.cloud.framework.common.entity.response.ResponseResult
     **/
    ResponseDataResult queryApply(String appliId);

    /*
     * @Author zhangchi
     * @Description 更改转学申请状态
     * @Date 9:46 2020/4/21
     * @Param
     * @return
     **/
    ResponseResult modifyStatus(String id,int status);

    /*
     * @Author zhangchi
     * @Description 查询转学儿童的状态
     * @Date 15:18 2020/4/23
     * @Param
     * @return
     **/
    ResponseDataResult queryStatus(String appliId);
}
