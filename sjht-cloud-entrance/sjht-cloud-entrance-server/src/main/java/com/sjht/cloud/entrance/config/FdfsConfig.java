package com.sjht.cloud.entrance.config;

import com.sjht.cloud.framework.common.enums.FileSystemCode;
import com.sjht.cloud.framework.common.exception.ExceptionCast;
import org.csource.fastdfs.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * ***************************************************
 * @ClassName FdfsConfig
 * @Description fastdfs配置类
 * @Author maojianyun
 * @Date 2019/12/25 13:49
 * @Version V1.0
 * ****************************************************
 **/
@Configuration
public class FdfsConfig {

    @Value("${sjht.fastdfs.tracker_servers}")
    String tracker_servers;
    @Value("${sjht.fastdfs.connect_timeout_in_seconds}")
    int connect_timeout_in_seconds;
    @Value("${sjht.fastdfs.network_timeout_in_seconds}")
    int network_timeout_in_seconds;
    @Value("${sjht.fastdfs.charset}")
    String charset;

    @Bean
    public StorageClient1 getStorageClient1(){
        try {
            Properties properties = new Properties();
            properties.put("fastdfs.connect_timeout_in_seconds", connect_timeout_in_seconds);
            properties.put("fastdfs.network_timeout_in_seconds", network_timeout_in_seconds);
            properties.put("fastdfs.charset", charset);
            // properties.put("fastdfs.tracker_servers", tracker_servers);
            properties.put("fastdfs.tracker_servers", tracker_servers);
            //加载fastdfs-client.properties配置文件
            ClientGlobal.initByProperties(properties);
            // initFdfsConfig();
            //定义TrackerClient，用于请求TrackerServer
            TrackerClient trackerClient = new TrackerClient();
            //连接tracker
            TrackerServer trackerServer = trackerClient.getConnection();
            //获取Stroage
            StorageServer storeStorage = trackerClient.getStoreStorage(trackerServer);
            //创建stroageClient
            StorageClient1 storageClient1 = new StorageClient1(trackerServer,storeStorage);
            return storageClient1;
        } catch (Exception e) {
            e.printStackTrace();
            ExceptionCast.cast(FileSystemCode.FS_INITFDFSERROR);
        }
        return null;
    }
}
