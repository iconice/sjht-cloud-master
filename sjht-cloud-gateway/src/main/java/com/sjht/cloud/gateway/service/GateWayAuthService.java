package com.sjht.cloud.gateway.service;

import org.springframework.http.HttpHeaders;
import org.springframework.web.server.ServerWebExchange;

/**
 * ***************************************************
 * @ClassName GateWayAuthService
 * @Description auth接口
 * @Author maojianyun
 * @Date 2019/12/10 16:28
 * @Version V1.0
 * ****************************************************
 **/
public interface GateWayAuthService {

    /**
     * 从头部取出jwt令牌
     * @param headers
     * @return
     */
    String getJwtFromHeader(HttpHeaders headers);

    /**
     * 从头部取出token
     * @param headers
     * @return
     */
    String getTokenFromHead(HttpHeaders headers);

    /**
     * 有效期查询
     * @param access_token
     * @return
     */
    long getExpire(String access_token);

    /**检查请求是否过于频繁*/
    boolean isTooFrequent(ServerWebExchange exchange);
}
