package com.sjht.cloud.entrance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.origin.SystemEnvironmentOrigin;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

/**
 * ***************************************************
 * @ClassName EntranceServerApplication
 * @Description 入学服务启动入口
 * @Author maojianyun
 * @Date 2019/12/25 10:02
 * @Version V1.0
 * ****************************************************
 **/
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@RefreshScope
public class EntranceServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EntranceServerApplication.class, args);
        System.out.println("————————————————————————入学服务启动成功————————————————————————");
    }

    /**文件上传大小限制*/
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //单个文件最大
        factory.setMaxFileSize(DataSize.ofMegabytes(25)); //25MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize(DataSize.ofMegabytes(100));//100M
        return factory.createMultipartConfig();
    }
}
