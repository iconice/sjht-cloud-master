package com.sjht.cloud.auth.service;

import com.sjht.cloud.auth.dto.UserLongDto;
import com.sjht.cloud.auth.entity.AuthToken;
import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import com.sjht.cloud.framework.common.entity.response.ResponseResult;
import com.sjht.cloud.ucenter.api.dto.RegisteredDto;
import com.sjht.cloud.ucenter.api.dto.UserDto;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @version 1.0
 **/
@Service
public interface AuthService {

    /**
     * 用户登录认证
     * @param userLongDto
     * @param clientId
     * @param clientSecret
     * @return
     */
    public AuthToken login(UserLongDto userLongDto, String clientId, String clientSecret);

    /**
     * 用户注册
     * @param registeredDto
     * @return
     */
    ResponseResult userRegistered(RegisteredDto registeredDto);

    /**
     * 从redis中查询jwt令牌
     * @param token
     * @return
     */
    public ResponseDataResult<AuthToken> getUserToken(String token);

    /**
     * 删除token
     * @param access_token
     * @return
     */
    public ResponseResult delToken(String access_token);

  /*
   * @Author zhangchi
   * @Description //TODO 强制重置用户密码，后期需要加因子验证
   * @Date 10:08 2020/4/29
   * @Param [userDto]
   * @return com.sjht.cloud.framework.common.entity.response.ResponseResult
   **/
    ResponseResult userReset(UserDto userDto);
}
