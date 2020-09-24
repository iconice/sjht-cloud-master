package com.sjht.cloud.auth.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sjht.cloud.auth.dto.UserLongDto;
import com.sjht.cloud.auth.entity.AuthToken;
import com.sjht.cloud.auth.feignClient.UserFeignClient;
import com.sjht.cloud.auth.service.AuthService;
import com.sjht.cloud.framework.common.constant.CommonCanstant;
import com.sjht.cloud.framework.common.constant.SjhtServerListConstant;
import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import com.sjht.cloud.framework.common.entity.response.ResponseResult;
import com.sjht.cloud.framework.common.entity.response.ResponseUtil;
import com.sjht.cloud.framework.common.enums.AuthCode;
import com.sjht.cloud.framework.common.exception.ExceptionCast;
import com.sjht.cloud.ucenter.api.dto.RegisteredDto;
import com.sjht.cloud.ucenter.api.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * ***************************************************
 * @ClassName AuthServiceImpl
 * @Description 认证实现类
 * @Author maojianyun
 * @Date 2019/12/5 14:03
 * @Version V1.0
 * ****************************************************
 **/
@Service
public class AuthServiceImpl implements AuthService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthServiceImpl.class);

    @Value("${auth.tokenValiditySeconds}")
    private int tokenValiditySeconds;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private UserFeignClient userFeignClient;

    @Override
    public AuthToken login(UserLongDto userLongDto, String clientId, String clientSecret) {

        // 请求spring security申请令牌
        AuthToken authToken = this.applyToken(userLongDto, clientId, clientSecret);
        if (authToken != null){
            // 用户身份令牌
            String access_token = authToken.getAccess_token();
            // 存储到redis中的内容
            String jsonString = JSON.toJSONString(authToken);
            // 将令牌存储到redis
            boolean result = this.saveToken(access_token, jsonString, tokenValiditySeconds);
            if (!result) {
                ExceptionCast.cast(AuthCode.AUTH_LOGIN_TOKEN_SAVEFAIL);
            }
        } else {
            ExceptionCast.cast(AuthCode.AUTH_CREDENTIAL_ERROR);
        }
        return authToken;
    }

    @Override
    public ResponseResult userRegistered(RegisteredDto registeredDto) {
        return userFeignClient.registered(registeredDto);
    }

    @Override
    public ResponseDataResult<AuthToken> getUserToken(String token) {
        AuthToken authToken = new AuthToken();
        String userToken = "user_token:"+token;
        String userTokenString = redisTemplate.opsForValue().get(userToken);
        if(userToken!=null){
            try {
                authToken = JSONObject.parseObject(userTokenString, AuthToken.class);
            } catch (Exception e) {
                LOGGER.error("getUserToken from redis and execute JSON.parseObject error {}",e.getMessage()); e.printStackTrace(); }
        }
        return ResponseUtil.SUCCESS(authToken);
    }

    @Override
    public ResponseResult delToken(String access_token) {
        String key = "user_token:" + access_token;
        redisTemplate.delete(key);
        return ResponseUtil.SUCCESS();
    }

    /**
     *
     * @param access_token 用户身份令牌
     * @param content  内容就是AuthToken对象的内容
     * @param ttl 过期时间
     * @return
     */
    private boolean saveToken(String access_token, String content,long ttl){
        String key = "user_token:" + access_token;
        redisTemplate.boundValueOps(key).set(content,ttl, TimeUnit.SECONDS);
        Long expire = redisTemplate.getExpire(key);
        return expire>0;
    }

    /**
     * 请求spring security申请令牌
     * @param userLongDto
     * @return AuthToken
     */
    private AuthToken applyToken(UserLongDto userLongDto, String clientId, String clientSecret){
        // 从nacos中获取服务地址（因为spring security在认证服务中）
        // 从nacos中获取认证服务的一个实例地址
        ServiceInstance serviceInstance = loadBalancerClient.choose(SjhtServerListConstant.SJHT_CLOUD_UCENTER_AUTH_SERVER);
        // 此地址就是http:// ip:port
        URI uri = serviceInstance.getUri();
        // 令牌申请地址
        String authUrl = uri+ "/auth/oauth/token";
        // 定义header
        LinkedMultiValueMap<String, String> header = new LinkedMultiValueMap<>();
        String httpBasic = getHttpBasic(clientId, clientSecret);
        header.add("Authorization",httpBasic);
        //定义body
        LinkedMultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type","password");
        body.add("username",userLongDto.getUserName());
        body.add("password",userLongDto.getPassword());
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(body, header);
        //设置restTemplate远程调用时候，对400和401不让报错，正确返回数据
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler(){
            @Override
            public void handleError(ClientHttpResponse response) throws IOException {
                if(response.getRawStatusCode() == CommonCanstant.AuthCode.CODE_500){
                    ExceptionCast.cast(AuthCode.AUTH_CREDENTIAL_ERROR);
                }
                if(response.getRawStatusCode() == CommonCanstant.AuthCode.CODE_401){
                    ExceptionCast.cast(AuthCode.AUTH_ACCOUNT_NOTEXISTS);
                }
            }
        });
        ResponseEntity<Map> exchange = restTemplate.exchange(authUrl, HttpMethod.POST, httpEntity, Map.class);
        //申请令牌信息
        Map bodyMap = exchange.getBody();
        if(bodyMap == null ||
                bodyMap.get(CommonCanstant.AuthCode.ACCESS_TOKEN) == null ||
                bodyMap.get(CommonCanstant.AuthCode.REFRESH_TOKEN) == null ||
                bodyMap.get(CommonCanstant.AuthCode.JTI) == null){
            //解析spring security返回的错误信息
            return null;
        }
        AuthToken authToken = new AuthToken();
        authToken.setAccess_token((String) bodyMap.get(CommonCanstant.AuthCode.JTI));//用户身份令牌
        authToken.setRefresh_token((String) bodyMap.get(CommonCanstant.AuthCode.REFRESH_TOKEN));//刷新令牌
        authToken.setJwt_token((String) bodyMap.get(CommonCanstant.AuthCode.ACCESS_TOKEN));//jwt令牌
        return authToken;
    }

    /**
     *  获取httpbasic的串
     * @param clientId
     * @param clientSecret
     * @return
     */
    private String getHttpBasic(String clientId,String clientSecret){
        String string = clientId+":"+clientSecret;
        //将串进行base64编码
        byte[] encode = Base64Utils.encode(string.getBytes());
        return "Basic "+new String(encode);
    }

    @Override
    public ResponseResult userReset(UserDto userDto) {
        return userFeignClient.createUser(userDto);
    }
}
