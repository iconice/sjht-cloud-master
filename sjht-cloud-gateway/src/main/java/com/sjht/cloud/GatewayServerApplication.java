package com.sjht.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * ***************************************************
 * @ClassName GatewayServerApplication
 * @Description 网关启动入口
 * @Author maojianyun
 * @Date 2019/12/4 15:06
 * @Version V1.0
 * ****************************************************
 **/
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@RefreshScope
public class GatewayServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServerApplication.class, args);
    }
}
