package com.sjht.cloud.entrance.controller;

import com.sjht.cloud.entrance.service.EntranceFileInfoService;
import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import com.sjht.cloud.framework.common.entity.response.ResponseResult;
import com.sjht.cloud.framework.common.entity.response.ResponseUtil;
import com.sjht.cloud.framework.common.enums.FileSystemCode;
import com.sjht.cloud.framework.common.exception.ExceptionCast;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * ***************************************************
 * @ClassName EntranceFileInfoController
 * @Description 文件api
 * @Author maojianyun
 * @Date 2020/3/5 10:42
 * @Version V1.0
 * ****************************************************
 **/
@Slf4j
@RestController
@RequestMapping("file")
@Api(value = "入学申请管理-文件接口", tags = {"入学申请管理-文件接口"})
public class EntranceFileInfoController {

    @Autowired
    private EntranceFileInfoService fileInfoService;

    /**
     * 文件上传
     * @param multipartFile
     * @return
     */
    @PostMapping("fileUpload")
    @ApiOperation(value = "入学申请-删除已有的文件")
    public ResponseDataResult fileUpload(@RequestParam MultipartFile multipartFile){
        return fileInfoService.fileUpload(multipartFile);
    }

    @ApiOperation(value = "文件上传接口-多文件传输返回原文件名-fileId对应关系")
    @RequestMapping(value = "/uploadMultipleFiles",method = RequestMethod.POST)
    public ResponseDataResult uploadMultipleFiles(@RequestParam(name = "file") MultipartFile[] multipartFiles){
        Map<String,String> result=new HashMap<>(8);
        for(MultipartFile multipartFile:multipartFiles) {
            String fileId = fileInfoService.fileUpload2( multipartFile);
            if (fileId == null) {
                //网关直接上传文件，这样可以减少网络流量，然后将文件信息和fileId传给service进行保存到数据库或其他操作。
                String orgName = multipartFile.getOriginalFilename();
                log.error("原文件名{}上传失败", orgName);
                ExceptionCast.cast(FileSystemCode.FS_UPLOADFILE_SERVERFAIL);
            }
            result.put(multipartFile.getOriginalFilename(),fileId);
        }
        return ResponseUtil.SUCCESS(result);
    }

    @PostMapping("upload")
    @ApiOperation(value = "入学申请-上传接口")
    public ResponseDataResult upload(HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        return fileInfoService.fileUpload(file);
    }

    /**
     * 删除文件
     * @param fileId
     * @return
     */
    @PostMapping("deleFile")
    @ApiOperation(value = "入学申请-新文件上传")
    public ResponseResult deleFile(@RequestParam String fileId){
        return fileInfoService.deleFile(fileId);
    }



}
