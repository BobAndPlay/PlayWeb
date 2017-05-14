package com.bob.ssm.service.impl;

import com.bob.ssm.base.BaseResponse;
import com.bob.ssm.dao.UserDao;
import com.bob.ssm.model.User;
import com.bob.ssm.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author: Bob
 * Date:   2016/7/15.
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    public User getUserById(Long userId) {
        return userDao.selectUserById(userId);
    }

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    public User getUserByPhoneOrEmail(String emailOrPhone, Short state) {
        return userDao.selectUserByPhoneOrEmail(emailOrPhone, state);
    }

    public List<User> getAllUser() {
        return userDao.selectAllUser();
    }

    public List<User> searchUser(String name) {
        return userDao.selectUserByName(name);
    }

    public String login(String username, String pwd) throws JsonProcessingException {
        BaseResponse response = new BaseResponse();
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> users = userDao.selectUserByName(username);
        if (users != null && users.size() > 0) {
            return objectMapper.writeValueAsString(response);
        } else {
            response.setCode("2");
            response.setMsg("用户不存在");
            return objectMapper.writeValueAsString(response);
        }

    }
}
