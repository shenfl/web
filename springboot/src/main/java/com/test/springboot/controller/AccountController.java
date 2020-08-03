package com.test.springboot.controller;

import com.test.springboot.mapper.AccountMapper;
import com.test.springboot.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shenfl
 */
@RestController
public class AccountController {
    @Autowired
    private AccountMapper accountMapper;

    @GetMapping("/account")
    public Boolean query() {
        Account account = accountMapper.selectById(71);
        System.out.println(account);
        account = accountMapper.findById(72);
        System.out.println(account);
        return true;
    }
}
