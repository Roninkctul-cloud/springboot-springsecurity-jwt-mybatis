package com.jwt.service;

import com.jwt.entity.User;
import com.jwt.entity.UserDto;
import com.jwt.exception.RegisterFailureException;
import com.jwt.exception.RegisterUsernameHasBeenExists;

/**
 * @author:抱着鱼睡觉的喵喵
 * @date:2021/4/14
 * @description:
 */
public interface RegisterService {
    boolean register(UserDto userDto) throws RegisterFailureException;
    User selectDup(String username) throws  RegisterUsernameHasBeenExists;
}
