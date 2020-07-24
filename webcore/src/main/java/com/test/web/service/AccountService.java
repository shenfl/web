package com.test.web.service;/**
 * @author shenfl
 */

import com.github.pagehelper.PageInfo;
import com.test.web.model.Account;

import java.util.List;

/**
 * @author shenfl
 */
public interface AccountService {
    Account getById(Integer id);
    List<Account> selectAll();
    PageInfo<Account> selectPage(Integer pageNo, Integer pageSize);
}
