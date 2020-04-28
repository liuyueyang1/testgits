package com.itheima.controller;


import com.baomidou.mybatisplus.activerecord.Model;
import com.itheima.Utils.Result;
import com.itheima.beans.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lyy
 * @since 2020-04-23
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/maventest")
    public ModelAndView maventest(ModelAndView mv){
        List<User> users = userService.selectList(null);
        mv.addObject("users",users);
        mv.setViewName("test");
        return mv;
    }
}

