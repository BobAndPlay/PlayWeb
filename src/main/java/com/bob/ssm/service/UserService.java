package com.bob.ssm.service;

import com.bob.ssm.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;

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

    String login(String username, String pwd) throws JsonProcessingException;
}
