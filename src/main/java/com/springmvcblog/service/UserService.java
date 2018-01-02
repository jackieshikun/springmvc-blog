package com.springmvcblog.service;

import java.util.List;

import com.springmvcblog.model.User;

public interface UserService {

    /**
     * 注册用户
     * @param user
     */
    User register(User user);

    /**
     * 判断用户是否登录成功
     * @param email
     * @param password
     * @return
     */
    User login(String email, String password);

    /**
     * 更新用户信息
     * @param user
     */
    User update(User user);

    /**
     * 获取所有用户
     * @return
     */
    List<User> getUsers();

    User findByName(String username);

    User findByEmail(String email);

}
