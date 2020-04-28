package com.itheima.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.Service.PeopleService;
import com.itheima.Utils.Result;
import com.itheima.entity.People;
import com.itheima.mapper.PeopleMappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
public class PeopleController {
    @Autowired
    private PeopleService peopleService;

    @Autowired
    private PeopleMappers peopleMappers;

    @RequestMapping("/quick")
    public List<People> qucik() {
        List<People> all = peopleMappers.findAll();
        return all;
    }

    @RequestMapping("/test1")
    public ModelAndView test(ModelAndView mv) throws JsonProcessingException {
        System.out.println("此方法运行了");
        List<People> people = peopleService.selectList(null);
        mv.addObject("msg", "这是一个测试信息看能不能收到");
        mv.addObject("people", people);
        mv.setViewName("hello");
        return mv;
    }


    @RequestMapping("/tofind")
    public ModelAndView qucik(ModelAndView mv) {
        mv.setViewName("list/regist");
        return mv;
    }

    @RequestMapping("/findUser")
    public ModelAndView findUser(ModelAndView mv, String username) {
        System.out.println(username);
//        People people = peopleService.selectOne(new EntityWrapper<People>().eq("username", username));
//        System.out.println(people);
//        if (people!=null){
//            mv.addObject("msg","用户名存在");
//            mv.addObject("people",people);
//            mv.setViewName("/list/regist");
//        }else {
        mv.addObject("msg", "用户名可用");
        mv.setViewName("/list/regist");
//        }
        return mv;
    }


    @RequestMapping("/findAll")
    public Result findAll() {
        Result build=Result.build(true);
        List<People> all = peopleService.findAll();
        System.out.println(all);
        build.setObj(all);
        return build;
    }

}
