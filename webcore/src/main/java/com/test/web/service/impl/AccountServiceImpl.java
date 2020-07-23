package com.test.web.service.impl;

import com.test.web.mapper.AccountMapper;
import com.test.web.model.Account;
import com.test.web.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
