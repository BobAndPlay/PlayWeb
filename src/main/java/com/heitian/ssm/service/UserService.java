package com.heitian.ssm.service;

import com.heitian.ssm.model.User;

import java.util.List;

/**
 * Author: Bob
 * Date:   2016/7/15.
 */
public interface UserService {

    List<User> getAllUser();

    User getUserByPhoneOrEmail(String emailOrPhone, Short state);

    User getUserById(Long userId);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(User user);

    List<User> searchUser(String name);
}
