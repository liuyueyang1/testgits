package com.itheima.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.itheima.entity.People;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface PeopleMappers extends BaseMapper<People> {

    List<People> findAll();
    List<People> findOne(@Param("sex") String sex , @Param("hobby")String hobby);


}
