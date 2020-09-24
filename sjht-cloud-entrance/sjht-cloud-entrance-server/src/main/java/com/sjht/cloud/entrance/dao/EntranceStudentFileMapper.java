package com.sjht.cloud.entrance.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sjht.cloud.entrance.api.vo.EntranceStudentFileVo;
import com.sjht.cloud.entrance.entity.EntranceStudentFileEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface EntranceStudentFileMapper extends BaseMapper<EntranceStudentFileEntity> {
    /**
     * 获取转学儿童文件信息
     * @param studentId
     * @return
     */
    List<EntranceStudentFileVo> getEntranceStudentFileList(@Param("studentId") Long studentId);

    /*
     * @Author zhangchi
     * @Description 逻辑删除保存的文件
     * @Date 11:15 2020/4/21
     * @Param
     * @return
     **/
    int delEntranceStudentFile(@Param("studentId") String studentId);
}
