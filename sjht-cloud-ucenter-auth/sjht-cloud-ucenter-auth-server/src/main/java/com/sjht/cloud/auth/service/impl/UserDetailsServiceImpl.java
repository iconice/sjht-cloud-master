package com.sjht.cloud.auth.service.impl;

import com.sjht.cloud.auth.entity.UserJwt;
import com.sjht.cloud.auth.feignClient.UserFeignClient;
import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import com.sjht.cloud.ucenter.api.vo.AuthUserVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * ***************************************************
 * @ClassName UserDetailsServiceImpl
 * @Description UserDetailsServiceImpl
 * @Author maojianyun
 * @Date 2019/12/4 10:28
 * @Version V1.0
 * ****************************************************
 **/
@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ClientDetailsService clientDetailsService;

    @Autowired
    private UserFeignClient userFeignClient;

    /**
     * 1. 进行身份认证
     * 2. 进行账户密码认证
     * @param username
     * @return UserDetails
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 取出身份，如果身份为空说明没有认证
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 没有认证统一采用httpbasic认证，httpbasic中存储了client_id和client_secret，开始认证client_id和client_secret
        if (authentication == null) {
            ClientDetails clientDetails = clientDetailsService.loadClientByClientId(username);
            if (clientDetails != null) {
                //密码
                String clientSecret = clientDetails.getClientSecret();

                return new User(username, clientSecret, AuthorityUtils.commaSeparatedStringToAuthorityList(""));
            }
        }
        if (StringUtils.isEmpty(username)) {
            return null;
        }
        // 根据用户名查询用户信息
        ResponseDataResult<AuthUserVo> response = userFeignClient.getUserInfoByUserNmae(username);
        AuthUserVo authUserVo = response.getData();
        if(authUserVo == null){
            //返回空给spring security表示用户不存在
            return null;
        }

        // 添加权限
        List<String> user_permission = new ArrayList<>();
        if (authUserVo.getPerms() != null && !authUserVo.getPerms().isEmpty()) {
            authUserVo.getPerms().forEach(e -> {
                user_permission.add(e);
            });
        }
        String user_permission_string  = StringUtils.join(user_permission.toArray(), ",");
        String userName = authUserVo.getUserName();
        String password = authUserVo.getPassword();
        UserJwt userDetails = new UserJwt(username, password, AuthorityUtils.commaSeparatedStringToAuthorityList(user_permission_string));
        userDetails.setId(authUserVo.getId());
        userDetails.setUserType(authUserVo.getUserType());
        userDetails.setName(authUserVo.getName());
        userDetails.setHeadUrl(authUserVo.getHeadUrl());

        log.info(userDetails.toString());
        return userDetails;
    }
}
