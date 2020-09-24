package com.sjht.cloud.gateway.filter;

import com.alibaba.fastjson.JSONObject;
import com.sjht.cloud.framework.common.entity.response.ResponseResult;
import com.sjht.cloud.framework.common.entity.response.ResponseUtil;
import com.sjht.cloud.framework.common.enums.CommonCode;
import com.sjht.cloud.gateway.config.SwaggerProvider;
import com.sjht.cloud.gateway.service.GateWayAuthService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

/**
 * ***************************************************
 * @ClassName LoginFilter
 * @Description 登录认证过滤器
 * @Author maojianyun
 * @Date 2019/12/10 16:44
 * @Version V1.0
 * ****************************************************
 **/
@Slf4j
@Component
public class LoginFilter  implements GlobalFilter, Ordered {


    @Autowired
    private GateWayAuthService gateWayAuthService;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        boolean isSwagger = false;
        HttpHeaders headers = exchange.getRequest().getHeaders();
        String path = exchange.getRequest().getURI().getPath();
        log.info("进入loginfilter，当前路径:{}",path);
        log.info(headers.toString());


        // 后面进行登录验证
        ServerHttpResponse response = exchange.getResponse();

        //检查请求是否过于频繁
        if(gateWayAuthService.isTooFrequent(exchange)){
            return this.errorRespont(response, ResponseUtil.FAIL(CommonCode.TOO_FREQUENT));
        }

        // swagger路径放行
        //chain.filter(exchange);
        //|| path.startsWith("/ucenter/user")
        if(StringUtils.endsWithIgnoreCase(path, SwaggerProvider.API_URI) || path.startsWith("/auth")){ // 不需要登陆认证的接口
            return chain.filter(exchange);
        }

        // 从头部取出token
        String token = gateWayAuthService.getTokenFromHead(headers);
        if (StringUtils.isBlank(token)) {
            return this.errorRespont(response, ResponseUtil.FAIL(CommonCode.UNAUTHENTICATED));
        }
        String jwt = gateWayAuthService.getJwtFromHeader(headers);
        if (StringUtils.isBlank(jwt)) {
            return this.errorRespont(response, ResponseUtil.FAIL(CommonCode.UNAUTHENTICATED));
        }
        long expire = gateWayAuthService.getExpire(token);
        if (expire < 0) {
            return this.errorRespont(response, ResponseUtil.FAIL(CommonCode.UNAUTHENTICATED));
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }

    private Mono<Void> errorRespont(ServerHttpResponse response, ResponseResult data){
        byte[] datas = JSONObject.toJSONString(data).getBytes(StandardCharsets.UTF_8);
        DataBuffer buffer = response.bufferFactory().wrap(datas);
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        return response.writeWith(Mono.just(buffer));
    }
}
