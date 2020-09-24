package com.sjht.cloud.auth.controller;

import com.sjht.cloud.auth.dto.UserLongDto;
import com.sjht.cloud.auth.entity.AuthToken;
import com.sjht.cloud.auth.service.AuthService;
import com.sjht.cloud.framework.common.entity.response.Response;
import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import com.sjht.cloud.framework.common.entity.response.ResponseResult;
import com.sjht.cloud.framework.common.entity.response.ResponseUtil;
import com.sjht.cloud.framework.common.enums.AuthCode;
import com.sjht.cloud.framework.common.enums.CommonCode;
import com.sjht.cloud.framework.common.exception.ExceptionCast;
import com.sjht.cloud.framework.common.utils.CookieUtil;
import com.sjht.cloud.framework.common.utils.HeaderUtil;
import com.sjht.cloud.ucenter.api.dto.RegisteredDto;
import com.sjht.cloud.ucenter.api.dto.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ***************************************************
 * @ClassName AuthController
 * @Description 认证服务器
 * @Author maojianyun
 * @Date 2019/12/5 16:40
 * @Version V1.0
 * ****************************************************
 **/
@RestController
@RequestMapping("/")
@Api(value = "认证服务-认证服务接口", tags = {"认证服务-认证服务接口"})
@Slf4j
public class AuthController {
    private static final     String PHONE_REG = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";

    @Value("${auth.clientId}")
    private String clientId;

    @Value("${auth.clientSecret}")
    private String clientSecret;

    @Value("${auth.cookieDomain}")
    private String cookieDomain;

    @Value("${auth.cookieMaxAge}")
    private int cookieMaxAge;

    @Autowired
    private AuthService authService;

    @PostMapping("/user/login")
    @ApiOperation(value = "认证服务-用户登录认证")
    public ResponseDataResult userLogin(@RequestBody UserLongDto userLongDto) {
        log.info("当前登录用户:{}",userLongDto.getUserName());
        Map<String, Object> result = new HashMap<>();
        //账号
        String username = userLongDto.getUserName();
        //密码
        String password = userLongDto.getPassword();
        if (userLongDto == null || StringUtils.isEmpty(username)) {
            ExceptionCast.cast(AuthCode.AUTH_USERNAME_NONE);
        }
        if (userLongDto == null || StringUtils.isEmpty(password)) {
            ExceptionCast.cast(AuthCode.AUTH_PASSWORD_NONE);
        }
        //申请令牌
        AuthToken authToken = authService.login(userLongDto, clientId, clientSecret);
        // 用户身份令牌
        String access_token = authToken.getAccess_token();
        //将令牌存储到cookie
        this.saveHead(access_token);
        result.put("token", access_token);
        return ResponseUtil.SUCCESS(result);
    }

    @PostMapping("/user/userRegistered")
    @ApiOperation(value = "认证服务-用户注册")
    //这个相当于是个后门，防止网关把自己墙了  feignClient
    public Response userRegistered(@RequestBody RegisteredDto registeredDto) {
        log.info("注册用户{}",registeredDto.getTell());
        String phone = registeredDto.getTell();
        if(phone.length() != 11){
            ExceptionCast.cast(CommonCode.WRONG_PHONE_NUM);
        }else{
            Pattern p = Pattern.compile(PHONE_REG);
            Matcher m = p.matcher(phone);
            boolean isMatch = m.matches();
            if(!isMatch){
                ExceptionCast.cast(CommonCode.WRONG_PHONE_NUM);
            }
        }
        return authService.userRegistered(registeredDto);
    }

    @GetMapping("/user/jwt")
    @ApiOperation(value = "认证服务-查询userjwt令牌")
    public Response userjwt() {
        Map<String, Object> data = null;
        String token = this.getTokenFormHead();
        if(token != null){
            AuthToken authToken = authService.getUserToken(token).getData();
            if (authToken != null) {
                data = new HashMap<>();
                data.put("jwp", authToken.getJwt_token());
            } else {
                return ResponseUtil.FAIL(CommonCode.UNAUTHENTICATED);
            }
        }
        return ResponseUtil.SUCCESS(data);
    }

    @PostMapping("/user/logout")
    @ApiOperation(value = "认证服务-退出登录")
    public ResponseResult logout() {
        String token = this.getTokenFormHead();
        //删除redis中的token
        authService.delToken(token);
        return ResponseUtil.SUCCESS();
    }

    /**
     * 将令牌存储到cookie
     *
     * @param token
     */
    private void saveHead(String token) {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        //HttpServletResponse response,String domain,String path, String name, String value, int maxAge,boolean httpOnly
        // HeaderUtil.addHead(response, "uid", token);
        response.setHeader("uid", token);
    }

    /**
     * 取出cookie中的身份令牌
     *
     * @return
     */
    //取出cookie中的身份令牌
    private String getTokenFormHead() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Map<String, String> map = HeaderUtil.readHeads(request, "uid");
        if (map != null && map.get("uid") != null) {
            String uid = map.get("uid");
            return uid;
        }
        return null;
    }

    /**
     * 从cookie删除token
     *
     * @param token
     */
    private void clearCookie(String token) {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        //HttpServletResponse response,String domain,String path, String name, String value, int maxAge,boolean httpOnly
        CookieUtil.addCookie(response, cookieDomain, "/", "uid", token, 0, false);

    }

    /*
     * @Author zhangchi
     * @Description 强制重置初始密码
     * @Date 10:00 2020/4/29
     * @Param
     * @return
     **/
//    @PostMapping("/user/userReset")
//    @ApiOperation(value = "认证服务-用户重置密码")
//    public Response userReset(@RequestBody UserDto userDto) {
//        return authService.userReset(userDto);
//    }

}
