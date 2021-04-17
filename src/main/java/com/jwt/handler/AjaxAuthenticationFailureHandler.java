package com.jwt.handler;


import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author:抱着鱼睡觉的喵喵
 * @date:2021/4/11
 * @description:    认证失败Handler处理类
 */
@Slf4j
@Component
public class AjaxAuthenticationFailureHandler implements AuthenticationFailureHandler {
    private String url;

    public AjaxAuthenticationFailureHandler(){}
    public AjaxAuthenticationFailureHandler(String url) {
        this.url = url;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        String failData = "";
        if (exception instanceof AccountExpiredException) {
            failData = "账号过期";
        } else if (exception instanceof UsernameNotFoundException) {
            failData = "账号不存在";
        } else if (exception instanceof CredentialsExpiredException) {
            failData = "密码过期";
        } else if (exception instanceof DisabledException) {
            failData = "账号不可用";
        } else if (exception instanceof LockedException) {
            failData = "账号锁定";
        } else if (exception instanceof BadCredentialsException) {
            failData = "密码错误";
        } else {
            failData = "未知异常";
        }
        log.info("认证失败,"+failData);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(failData));
    }
}
