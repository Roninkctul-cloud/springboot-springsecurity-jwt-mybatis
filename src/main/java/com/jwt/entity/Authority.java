package com.jwt.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author:抱着鱼睡觉的喵喵
 * @date:2021/4/13
 * @description:
 */
@Data
public class Authority implements Serializable {
    private String roles;
}
