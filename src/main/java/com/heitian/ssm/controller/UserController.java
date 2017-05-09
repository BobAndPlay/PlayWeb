package com.heitian.ssm.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.heitian.ssm.model.Dog;
import com.heitian.ssm.model.User;
import com.heitian.ssm.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Bob
 * Date:   2016/7/15.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    private Logger log = Logger.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @RequestMapping("/showUser")
    public String showUser(HttpServletRequest request, Model model) {
        log.info("查询所有用户信息");
        List<User> userList = userService.getAllUser();
        model.addAttribute("userList", userList);
        return "showUser";
    }

    @RequestMapping("/searchUser")
    public String searchUser(HttpServletRequest request, Model model) {
        log.info("查询所有用户信息");
        String user_name = request.getParameter("user_name");
        String name = null;
        try {
            name = new String (user_name.getBytes("ISO-8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        List<User> userList = userService.searchUser(name);
        model.addAttribute("userList", userList);
        return "showUser";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String addUser(HttpServletRequest request) {
        String name = request.getParameter("username");
        String userphone = request.getParameter("userphone");
        User user = new User();
        user.setUserName(name);
        user.setUserPhone(userphone);
        userService.addUser(user);
        return "添加用户成功";
    }

    @RequestMapping(value = "/showDog", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String load() throws IOException {
        List<Dog> list = new ArrayList<Dog>();
        Dog dog = new Dog();
        dog.setName("旺财");
        dog.setAge("1");
        dog.setColor("黄色");

        Dog dog1 = new Dog();
        dog1.setName("哮天");
        dog1.setAge("1");
        dog1.setColor("黑色");
        list.add(dog);
        list.add(dog1);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(list);
        System.out.println(jsonString);
        return jsonString;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String add(HttpServletRequest request) {
        return "请求参数有误";
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String updateUser(HttpServletRequest request) {
        try {
            String id = request.getParameter("id");
            String user_phone = request.getParameter("user_phone");
            String user_email = request.getParameter("user_email");
            long lid = Long.parseLong(id);
            User user = userService.getUserById(lid);
            user.setUserPhone(user_phone);
            user.setUserEmail(user_email);
            userService.updateUser(user);
            return "修改成功";
        } catch (Exception e) {
            return "请求参数有误";
        }
    }


    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String deleteUser(HttpServletRequest request) {
        try {
            String id = request.getParameter("id");
            long lid = Long.parseLong(id);
            User user = userService.getUserById(lid);
            userService.deleteUser(user);
            return "删除成功";
        } catch (Exception e) {
            return "请求参数有误";
        }
    }

}
