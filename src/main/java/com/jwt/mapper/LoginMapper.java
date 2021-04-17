package com.jwt.mapper;

import com.jwt.entity.Authority;
import com.jwt.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author:抱着鱼睡觉的喵喵
 * @date:2021/4/13
 * @description:
 */
@Repository
public interface LoginMapper {
    User findByUsername(String username);
    String findAuthorityByUsername(String username);
}
