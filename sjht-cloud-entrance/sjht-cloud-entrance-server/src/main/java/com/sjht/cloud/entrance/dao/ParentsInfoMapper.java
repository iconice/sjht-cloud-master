package com.sjht.cloud.entrance.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sjht.cloud.entrance.api.vo.GetParentInformationVo;
import com.sjht.cloud.entrance.api.vo.ParentInformationVo;
import com.sjht.cloud.entrance.entity.ParentsInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ***************************************************
 *
 * @ClassName parentsInfoMapper
 * @Description 家长信息
 * @Author 张弛
 * @Date 2020/4/1 9:40
 * @Version V1.0
 * ****************************************************
 **/
@Component
@Mapper
public interface ParentsInfoMapper extends BaseMapper<ParentsInfoEntity> {
    /**得到家长信息列表
     * @Author zhangchi
     * @Description
     * @Date 16:47 2020/4/1
     * @Param [userId]
     * @return com.sjht.cloud.entrance.api.vo.GetParentInformationVo
     **/
    List<ParentInformationVo> getParentInfo(@Param("userId") String userId);

    /*
     * @Author zhangchi
     * @Description 通过UserId删除全部父母信息
     * @Date 11:44 2020/4/27
     * @Param [userId]
     * @return int
     **/
    int delParentInfoByUserId(@Param("userId") String userId);
}
