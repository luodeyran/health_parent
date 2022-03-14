package org.dey.controller;


import org.dey.pojo.User;
import org.dey.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author deyran
 * @classname
 * @see UserController
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("user.do")
    public void Users(){
        List<User> users = userService.USERS();
        users.forEach(System.out::println);
    }


    @RequestMapping("user2.do")
    public void test(){
        System.out.println("hello");
    }
}
