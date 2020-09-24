package com.sjht.cloud.entrance.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sjht.cloud.entrance.api.dto.GetAppListDto;
import com.sjht.cloud.entrance.api.dto.GetEntraceAppliactionListDto;
import com.sjht.cloud.entrance.api.vo.EntranceApplication2Vo;
import com.sjht.cloud.entrance.api.vo.EntranceApplicationVo;
import com.sjht.cloud.entrance.entity.EntranceApplicationEntity;
import com.sjht.cloud.entrance.entity.extend.TempPOJO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * ***************************************************
 * @ClassName EntranceApplicationMapper
 * @Description 入学申请mapper
 * @Author maojianyun
 * @Date 2020/3/3 19:23
 * @Version V1.0
 * ****************************************************
 **/
@Mapper
@Component
public interface EntranceApplicationMapper extends BaseMapper<EntranceApplicationEntity> {

    /**
     * 得到申请列表
     * @param entraceAppliactionListDto
     * @return
     */
    List<EntranceApplicationVo> getEntranceApplicationList(@Param("ew") GetEntraceAppliactionListDto entraceAppliactionListDto);

    /**
     * 更新申请的标题
     * @param id
     * @param title
     * @return
     */
    int updateTitle(@Param("id") long id, @Param("title") String title);

    /**
     * 修改状态
     * @param status
     * @param status
     * @return
     */
    int updateStatus(@Param("id") long id, @Param("status") int status);

    /**
     * 根据各种条件获取申请列表*/
    List<EntranceApplication2Vo> getAppListByCondition(@Param("params") GetAppListDto getAppListDto);

    /**
     * 获取总数*/
    int getTotalNum(@Param("params") GetAppListDto getAppListDto);

    /**根据申请id查询所有子申请状态*/
    TempPOJO getSubStatusesById(@Param("id") long id);
}
