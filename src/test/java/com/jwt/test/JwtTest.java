package com.jwt.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:抱着鱼睡觉的喵喵
 * @date:2021/4/13
 * @description:
 */
public class JwtTest {
    public static void main(String[] args) {
        String a = "";
        List<String> list = new ArrayList<>();
        list.add("b");
        list.add("c");
        for(String cur : list) {
            a = cur;
        }
        System.out.println(a);
    }
}
