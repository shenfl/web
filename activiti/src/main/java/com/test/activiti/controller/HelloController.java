package com.test.activiti.controller;

import com.test.activiti.pojo.UserInfoBean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shenfl
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        UserInfoBean user = (UserInfoBean) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("当前登录用户: " + user.getUsername());
        return "hello";
    }
}
