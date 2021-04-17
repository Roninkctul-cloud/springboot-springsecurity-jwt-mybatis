package com.jwt.controller;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.*;

/**
 * @author:抱着鱼睡觉的喵喵
 * @date:2021/4/15
 * @description:
 */
@RestController
@RequestMapping("/api")
@EnableWebSecurity
public class TestController {

    @GetMapping("/add")
    public String add() {
        return "add";
    }

    @GetMapping("select")
    public String select() {
        return "select";
    }

    @GetMapping("/delete")
    public String delete() {
        return "delete";
    }

    @GetMapping("/update")
    public String update() {
        return "update";
    }
}
