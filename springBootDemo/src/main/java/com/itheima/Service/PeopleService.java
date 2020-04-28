package com.itheima.Service;

import com.baomidou.mybatisplus.service.IService;
import com.itheima.entity.People;

import java.util.List;

public interface PeopleService extends IService<People> {
        List<People> findAll();


}
