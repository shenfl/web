package com.test.web.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.web.mapper.AccountMapper;
import com.test.web.model.Account;
import com.test.web.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shenfl
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper mapper;
    @Override
    public Account getById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Account> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public PageInfo<Account> selectPage(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Account> accounts = mapper.selectAll();
        PageInfo<Account> pageInfo = new PageInfo<>(accounts);
        return pageInfo;
    }
}
