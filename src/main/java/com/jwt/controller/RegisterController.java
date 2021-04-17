package com.jwt.controller;

import com.jwt.entity.User;
import com.jwt.entity.UserDto;
import com.jwt.exception.RegisterFailureException;
import com.jwt.exception.RegisterUsernameHasBeenExists;
import com.jwt.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author:抱着鱼睡觉的喵喵
 * @date:2021/4/14
 * @description:
 */
@Controller
@Slf4j
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    @RequestMapping("/register")
    public String register(@Validated UserDto userDto) throws RegisterUsernameHasBeenExists {
        log.info("注册的数据为:"+userDto.toString() );

        User user = registerService.selectDup(userDto.getUsername());
        if (user == null) {
            throw new RegisterUsernameHasBeenExists("用户已存在");
        }
        try {
            registerService.register(userDto);
        } catch (RegisterFailureException e) {
            e.printStackTrace();
        }
        return "/";
    }
}
