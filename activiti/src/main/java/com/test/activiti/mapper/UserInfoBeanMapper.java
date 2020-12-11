package com.test.activiti.mapper;

import com.test.activiti.pojo.UserInfoBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author shenfl
 */
@Mapper
@Component
public interface UserInfoBeanMapper {
    /**
     * 从数据库中查询用户
     * @param username
     * @return
     */
    @Select("select * from user where username = #{username}")
    UserInfoBean selectByUsername(@Param("username") String username);
}