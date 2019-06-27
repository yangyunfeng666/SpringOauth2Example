package com.yunsoft.oauth.dao;

import com.yunsoft.oauth.modle.User;

import java.util.List;

public interface UserDao {
    List<User> selectByUserName(String userName);
    int insertSelective(User user);
}
