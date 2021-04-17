package com.jwt.handler;

import com.alibaba.fastjson.JSON;
import com.jwt.entity.User;
import com.jwt.utils.JwtTokenUtils;
import com.jwt.utils.ResponseBody;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author:抱着鱼睡觉的喵喵
 * @date:2021/4/11
 * @description:    认证成功Handler处理类
 */
@Component
public class AjaxAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private String url;

    public AjaxAuthenticationSuccessHandler() {
    }

    public AjaxAuthenticationSuccessHandler(String url) {
        this.url = url;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        User user = (User) authentication.getPrincipal();
        String token = JwtTokenUtils.createToken(user.getUsername(), String.valueOf(user.getAuthorities()));
        //设置编码,如果不设置会乱码
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        //设置返回的token 带有Bearer的前缀字符串
        response.setHeader("Authorization",  JwtTokenUtils.TOKEN_PREFIX+token);
        response.getWriter().write(new ResponseBody<User>(200,"登录成功",user).toString());
    }
}
