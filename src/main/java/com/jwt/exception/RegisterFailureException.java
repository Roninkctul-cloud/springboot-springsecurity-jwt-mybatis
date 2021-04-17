package com.jwt.exception;

/**
 * @author:抱着鱼睡觉的喵喵
 * @date:2021/4/14
 * @description:
 */
public class RegisterFailureException extends Exception{

    private String message;
    public RegisterFailureException() {
        super();
    }
    public RegisterFailureException(String message) {
       this.message = message;
    }
}
