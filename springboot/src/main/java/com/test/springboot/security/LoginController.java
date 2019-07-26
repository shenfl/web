package com.test.springboot.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @GetMapping("/login/{status}")
    public String login(@PathVariable String status) {
        System.out.println(status);
        if ("auth".equals(status)) {
            return "没有登录";
        }
        if ("fail".equals(status)) {
            return "登录失败";
        }
        if ("success".equals(status)) {
            return "登录成功";
        }
        if ("logout".equals(status)) {
            return "注销成功";
        }
        return "";
    }
}