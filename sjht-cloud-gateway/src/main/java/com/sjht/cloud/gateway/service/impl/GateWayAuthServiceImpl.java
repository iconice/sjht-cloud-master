package com.sjht.cloud.gateway.service.impl;

import com.sjht.cloud.gateway.service.GateWayAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * ***************************************************
 * @ClassName AuthServiceImpl
 * @Description 描述
 * @Author maojianyun
 * @Date 2019/12/10 16:36
 * @Version V1.0
 * ****************************************************
 **/
@Service
public class GateWayAuthServiceImpl implements GateWayAuthService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public String getJwtFromHeader(HttpHeaders headers) {
        //取出头信息
        List<String> authorizations = headers.get("Authorization");
        if(authorizations == null || authorizations.isEmpty()){
            return null;
        }
        if(!authorizations.get(0).startsWith("Bearer ")){
            return null;
        }
        //取到jwt令牌
        String jwt = authorizations.get(0).substring(6);
        return jwt;
    }

    @Override
    public String getTokenFromHead(HttpHeaders headers) {
        List<String> toekns = headers.get("uid");
        if (toekns == null || toekns.isEmpty()) {
            return null;
        }
        return toekns.get(0);
    }

    @Override
    public long getExpire(String access_token) {
        String key = "user_token:"+access_token;
        Long expire = stringRedisTemplate.getExpire(key, TimeUnit.SECONDS);
        return expire;
    }

    /**10s内访问超30次则认为过于频繁，禁用5分钟*/
    @Override
    public boolean isTooFrequent(ServerWebExchange exchange) {
        String key;

        HttpHeaders headers=exchange.getRequest().getHeaders();
        String token=this.getTokenFromHead(headers);
        if(token==null){//未登录
            key=exchange.getRequest().getRemoteAddress().getAddress().getHostAddress();
        }else{
            key=token;
        }

        //检查是否频繁登录
        key="auth_fre_"+key;
        long curr=stringRedisTemplate.opsForValue().increment(key);

        if(curr>30){//过于频繁,禁止访问5分钟
            stringRedisTemplate.expire(key,5*60,TimeUnit.SECONDS);
            return true;
        }

        if(curr==1){//第一次创建
            stringRedisTemplate.expire(key,10,TimeUnit.SECONDS);
        }

        return false;
    }
}
