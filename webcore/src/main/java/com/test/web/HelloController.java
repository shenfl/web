package com.test.web;

import com.github.pagehelper.PageInfo;
import com.test.web.model.Account;
import com.test.web.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by shenfl on 2018/5/21
 */
@Controller
public class HelloController {
    @Autowired
    private AccountService accountService;
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String printHello(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        PageInfo<Account> pageInfo = accountService.selectPage(1, 2);
        System.out.println(pageInfo);
        System.out.println(pageInfo.getList());
        model.addAttribute("msg", "Spring MVC Hello World");
        model.addAttribute("name", "yuntao");
        Cookie cookie = new Cookie("key2", "value2");
        cookie.setDomain("/");
        response.addCookie(cookie);
        return "test";
    }
}