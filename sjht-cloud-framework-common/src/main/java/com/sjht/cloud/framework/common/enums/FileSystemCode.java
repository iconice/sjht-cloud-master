package com.sjht.cloud.framework.common.enums;

import com.google.common.collect.ImmutableMap;
import com.sjht.cloud.framework.common.entity.response.ResultCode;
import lombok.ToString;


/**
 * ***************************************************
 * @ClassName AuthCode
 * @Description 系统文件code
 * @Author maojianyun
 * @Date 2019/12/1 23:12
 * @Version V1.0
 * ****************************************************
 **/
@ToString
public enum FileSystemCode implements ResultCode {

    FS_UPLOADFILE_FILEISNULL(false,30001,"上传文件为空！"),
    FS_UPLOADFILE_BUSINESSISNULL(false,30002,"业务Id为空！"),
    FS_UPLOADFILE_SERVERFAIL(false,30003,"上传文件服务器失败！"),
    FS_DELETEFILE_NOTEXISTS(false,30004,"删除的文件不存在！"),
    FS_DELETEFILE_DBFAIL(false,30005,"删除文件信息失败！"),
    FS_DELETEFILE_SERVERFAIL(false,30006,"删除文件失败！"),
    FS_UPLOADFILE_METAERROR(false,30007,"上传文件的元信息请使用json格式！"),
    FS_UPLOADFILE_USERISNULL(false,30008,"上传文件用户为空！"),
    FS_INITFDFSERROR(false,30009,"初始化fastDFS环境出错！");

    //操作代码
    boolean success;

    //操作代码
    int code;
    //提示信息
    String message;
    private FileSystemCode(boolean success, int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }
    private static final ImmutableMap<Integer, FileSystemCode> CACHE;

    static {
        final ImmutableMap.Builder<Integer, FileSystemCode> builder = ImmutableMap.builder();
        for (FileSystemCode commonCode : values()) {
            builder.put(commonCode.code(), commonCode);
        }
        CACHE = builder.build();
    }

    @Override
    public boolean success() {
        return success;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
