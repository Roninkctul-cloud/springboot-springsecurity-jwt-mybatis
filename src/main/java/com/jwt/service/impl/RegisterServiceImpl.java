package com.jwt.service.impl;

import com.jwt.entity.User;
import com.jwt.entity.UserDto;
import com.jwt.exception.RegisterFailureException;
import com.jwt.exception.RegisterUsernameHasBeenExists;
import com.jwt.mapper.RegisterMapper;
import com.jwt.service.RegisterService;
import com.sun.deploy.association.RegisterFailedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author:抱着鱼睡觉的喵喵
 * @date:2021/4/14
 * @description:
 */
@Service
@Slf4j
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegisterMapper registerMapper;
    @Override
    public boolean register(UserDto userDto) throws RegisterFailureException {
        boolean b = registerMapper.register(userDto);
        System.out.println(b);
        if (!b) {
            log.info("注册失败");
            throw new RegisterFailureException("注册失败");
        }
        return b;
    }

    @Override
    public User selectDup(String username) throws  RegisterUsernameHasBeenExists {
        User user = registerMapper.selectDup(username);
        if (user != null) {
            throw new RegisterUsernameHasBeenExists("用户名已经存在");
        }
        return null;
    }
}
