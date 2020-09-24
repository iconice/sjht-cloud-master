package com.sjht.cloud.entrance.service;

import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import com.sjht.cloud.framework.common.entity.response.ResponseResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * ***************************************************
 * @ClassName EntranceFileInfoService
 * @Description 入学文件接口
 * @Author maojianyun
 * @Date 2020/3/5 10:21
 * @Version V1.0
 * ****************************************************
 **/
public interface EntranceFileInfoService {

    /**
     * 文件上传
     * @param multipartFile
     * @return
     */
    ResponseDataResult fileUpload(MultipartFile multipartFile);
    /**
     * 文件上传2
     * @param multipartFile
     * @return fileId
     */
    String fileUpload2(MultipartFile multipartFile);

    /**
     * 删除文件
     * @param fileId
     * @return
     */
    ResponseResult deleFile(String fileId);
}
