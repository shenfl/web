package com.test.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.springboot.model.Account;

/**
 * @author shenfl
 */
public interface AccountMapper extends BaseMapper<Account> {
    Account findById(Integer id);
}
