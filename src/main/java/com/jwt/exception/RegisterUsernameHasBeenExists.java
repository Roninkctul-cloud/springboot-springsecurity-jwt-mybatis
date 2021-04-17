package com.jwt.exception;

/**
 * @author:抱着鱼睡觉的喵喵
 * @date:2021/4/15
 * @description:
 */
public class RegisterUsernameHasBeenExists extends Exception{
    private String message;
    public RegisterUsernameHasBeenExists(String message) {
        this.message = message;
    }
}
