package com.sjht.cloud;

import com.sjht.cloud.framework.common.interceptor.FeignClientInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * ***************************************************
 * @ClassName UcenterServerApplication
 * @Description 用户中心服务启动入口
 * @Author maojianyun
 * @Date 2019/12/1 20:02
 * @Version V1.0
 * ****************************************************
 **/
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@RefreshScope
public class UcenterServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(UcenterServerApplication.class, args);
    }

    @Bean
    public FeignClientInterceptor feignClientInterceptor(){
        return new FeignClientInterceptor();
    }
}
