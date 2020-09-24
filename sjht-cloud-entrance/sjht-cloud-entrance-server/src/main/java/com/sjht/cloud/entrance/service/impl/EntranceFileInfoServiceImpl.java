package com.sjht.cloud.entrance.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.sjht.cloud.entrance.service.EntranceFileInfoService;
import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import com.sjht.cloud.framework.common.entity.response.ResponseResult;
import com.sjht.cloud.framework.common.entity.response.ResponseUtil;
import com.sjht.cloud.framework.common.enums.FileSystemCode;
import com.sjht.cloud.framework.common.exception.ExceptionCast;
import io.netty.util.internal.StringUtil;
import org.csource.fastdfs.StorageClient1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * ***************************************************
 * @ClassName EntranceFileInfoServiceImpl
 * @Description 描述
 * @Author maojianyun
 * @Date 2020/3/5 10:22
 * @Version V1.0
 * ****************************************************
 **/
@Service
public class EntranceFileInfoServiceImpl implements EntranceFileInfoService {

    @Autowired
    private StorageClient1 storageClient1;

    @Override
    public ResponseDataResult fileUpload(MultipartFile multipartFile) {
        Map<String, String> stringStringMap =new HashMap<>(2);
        String fileId=fdfsUpload(multipartFile);
        if(StringUtil.isNullOrEmpty(fileId)){
            ExceptionCast.cast(FileSystemCode.FS_UPLOADFILE_SERVERFAIL);
        }
        stringStringMap.put("fileId",fileId);
        return ResponseUtil.SUCCESS(stringStringMap);
    }

    @Override
    public String fileUpload2(MultipartFile multipartFile) {
        return fdfsUpload(multipartFile);
    }

    @Override
    public ResponseResult deleFile(String fileId) {
        try {
            storageClient1.delete_file1(fileId);
        } catch (Exception e){
            ExceptionCast.cast(FileSystemCode.FS_DELETEFILE_DBFAIL);
        }
        return ResponseUtil.SUCCESS();
    }

    /**
     * 上传文件
     * @param multipartFile
     * @return
     */
    private String fdfsUpload(MultipartFile multipartFile){
        try {
            if(multipartFile ==null){
                ExceptionCast.cast(FileSystemCode.FS_UPLOADFILE_FILEISNULL);
            }
            //得到文件字节
            byte[] bytes = multipartFile.getBytes();
            //得到文件的原始名称
            java.lang.String originalFilename = multipartFile.getOriginalFilename();
            //得到文件扩展名
            java.lang.String ext = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            java.lang.String fileId = storageClient1.upload_file1(bytes, ext, null);
            if(StringUtils.isEmpty(fileId)){
                ExceptionCast.cast(FileSystemCode.FS_UPLOADFILE_SERVERFAIL);
            }
            return  fileId;
        } catch (Exception e) {
            e.printStackTrace();
            ExceptionCast.cast(FileSystemCode.FS_INITFDFSERROR);
        }
        return null;
    }
}
