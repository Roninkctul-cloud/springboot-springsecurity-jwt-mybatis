package com.jwt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author:抱着鱼睡觉的喵喵
 * @date:2021/4/7
 * @description:
 */
@Controller
public class LoginController {

    @RequestMapping("/toMain")
    public String main() {
        return "redirect:success.html";
    }

    @RequestMapping("/")
    public String demo() {
        return "main";
    }
    @GetMapping("/logout")
    public String logout() {
        return "redirect:login.html";
    }
}
