package com.itheima.Service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.Service.PeopleService;
import com.itheima.entity.People;
import com.itheima.mapper.PeopleMappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PeopleServiceimpl extends ServiceImpl<PeopleMappers,People> implements PeopleService {
        @Autowired
        private PeopleMappers peopleMappers;
        @Autowired
        private RedisTemplate redisTemplate;
    @Override
      public   List<People> findAll() {
        Object username_json = redisTemplate.boundValueOps("username_json").get();
        if (username_json==null){
            //redis没有数据
             username_json = peopleMappers.findAll();
            System.out.println("redis没数据，从数据库查");
            redisTemplate.boundValueOps("username_json").set(username_json);
        }else {
            System.out.println("redis有数据，从缓存查");
        }
        return (List<People>) username_json;
    }


}
