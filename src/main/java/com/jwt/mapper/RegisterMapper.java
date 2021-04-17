package com.jwt.mapper;

import com.jwt.entity.User;
import com.jwt.entity.UserDto;
import org.springframework.stereotype.Repository;

/**
 * @author:抱着鱼睡觉的喵喵
 * @date:2021/4/14
 * @description:
 */
@Repository
public interface RegisterMapper {
    boolean register(UserDto userDto);
    User selectDup(String username);
}
