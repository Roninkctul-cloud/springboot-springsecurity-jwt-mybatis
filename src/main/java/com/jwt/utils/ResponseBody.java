package com.jwt.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * @author:抱着鱼睡觉的喵喵
 * @date:2021/4/12
 * @description:
 */
@Data
public  class ResponseBody<T> implements Serializable {

    private Integer code;
    private String msg;
    private T data;

    public ResponseBody(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public ResponseBody(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
