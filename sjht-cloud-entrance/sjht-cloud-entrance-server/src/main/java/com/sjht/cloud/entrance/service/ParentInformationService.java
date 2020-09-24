package com.sjht.cloud.entrance.service;

import com.sjht.cloud.entrance.api.dto.UpdateParentInfoListDto;
import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import com.sjht.cloud.framework.common.entity.response.ResponseResult;

/**
 * ***************************************************
 * @ClassName ParentInformationService
 * @Description 家长信息服务
 * @Author 张弛
 * @Date 2020/3/25 19:32
 * @Version V1.0
 * ****************************************************
 **/
public interface ParentInformationService {
    /**
     * 创建家长信息
     * @param
     * @return
     */
//    ResponseResult createParentInformation(CreateParentInfoDto createParentInfoDto);

    /**
     * 创建或者修改家长信息
     * @param updateParentInfoListDto
     * @return
     */
    ResponseResult updateParentInformation(UpdateParentInfoListDto updateParentInfoListDto);

    /**
     * 查看父母信息
     * @param userId
     * @return
     */
    ResponseDataResult getParentInformation(String userId);

    /**
     * 删除信息、只能删除草稿类型的
     * @param id
     * @return
     */
    ResponseResult deleteParentInformation(String id);
}
