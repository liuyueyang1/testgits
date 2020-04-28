package com.itheima;

import com.itheima.beans.User;
import com.itheima.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes =MavenBootApplication.class )
public class test {
        @Autowired
        private UserMapper userMapper;

    @Test
    public void test(){
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }
}
