package com.test.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
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

    @GetMapping("/update")
    public Boolean update() {
        LambdaUpdateWrapper<Account> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Account::getId, 71);
        updateWrapper.set(Account::getName, "kk");
        updateWrapper.set(Account::getMoney, null);
        int update = accountMapper.update(null, updateWrapper);
        System.out.println(update);
        return true;
    }
}
