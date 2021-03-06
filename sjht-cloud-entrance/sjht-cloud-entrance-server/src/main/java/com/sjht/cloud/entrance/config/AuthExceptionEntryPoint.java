package com.sjht.cloud.entrance.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sjht.cloud.framework.common.enums.CommonCode;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**处理invalid token*/
public class AuthExceptionEntryPoint implements AuthenticationEntryPoint
{

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws ServletException {
        Map<String, Object> map = new HashMap<String, Object>();
        Throwable cause = authException.getCause();
        if(cause instanceof InvalidTokenException) {
            map.put("code", CommonCode.UNAUTHENTICATED.code());//401
            map.put("msg", "无效的token");
        }else{
            map.put("code", CommonCode.UNAUTHENTICATED.code());//401
            map.put("msg", CommonCode.UNAUTHENTICATED.message());
        }
        map.put("data", authException.getMessage());
        map.put("success", false);

        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(response.getOutputStream(), map);
        } catch (Exception e) {
            throw new ServletException();
        }
    }
}
