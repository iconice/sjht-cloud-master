package com.sjht.cloud.entrance.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sjht.cloud.entrance.api.vo.GetEntrancePreventionFileVo;
import com.sjht.cloud.entrance.entity.EntrancePreventionFileEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ***************************************************
 * @ClassName PreventionFileMapper
 * @Description 查验证明
 * @Author maojianyun
 * @Date 2020/3/4 11:58
 * @Version V1.0
 * ****************************************************
 **/
@Component
@Mapper
public interface EntrancePreventionFileMapper extends BaseMapper<EntrancePreventionFileEntity> {

    /**
     * 得到列表
     * @param appliId
     * @return
     */
    List<GetEntrancePreventionFileVo> getEntrancePreventionFile(@Param("appliId") long appliId);

    /**
     * 审核检验证明修改状态
     * @param id
     * @param status
     * @return
     */
    int modifyEntrancePreventionStatus(@Param("id")long id, @Param("status")int status);
}
