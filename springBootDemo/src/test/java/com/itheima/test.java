package com.itheima;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.Service.PeopleService;
import com.itheima.entity.People;
import com.itheima.mapper.PeopleMappers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyspringBootApplication.class)
public class test {
                @Autowired
                private PeopleMappers peopleMappers;

    @Autowired
    private PeopleService peopleService;

        @Autowired
        private RedisTemplate<String,String> redisTemplate;


        @Test
        public void test(){
            List list=new ArrayList();
            list.add("a");
            list.add("b");
            String s = list.toString();
            redisTemplate.boundValueOps("mylist").set(s);
            String mylist = redisTemplate.boundValueOps("mylist").get();

            System.out.println(mylist);

        }

    /***
     * 插入
     */
    @Test
    public void test2() throws JsonProcessingException {
        List<People> people = peopleService.selectList(null);
        ObjectMapper mapper=new ObjectMapper();
            String s = mapper.writeValueAsString(people);
            System.out.println(s);
        }

    /***
     * 更新
     */
    @Test
    public void test3(){
        People people=new People();
        people.setId(21);
        people.setUsername("mybatisplus");
        people.setPassword("555");
        people.setSex("male");
//        people.setHobby("code");
        Integer insert = peopleMappers.updateById(people);
        System.out.println("更新了"+insert+"条数据");
    }

    /***
     * 查询
     */
    @Test
    public void test4(){
                People people=new People();
                people.setUsername("lyy");
                people.setPassword("888");
                people.setHobby("hehe");
        boolean insert = people.insert();
        System.out.println(insert);
    }

//        @Autowired
//        private RedisTemplate<String,String> redisTemplate;
//    @Test
//    public void test1() throws JsonProcessingException {
//        Object findAll = redisTemplate.boundValueOps("user.findAll").get();
//        if (findAll==null){
//            List<People> all = peopleMappers.findAll();
//            ObjectMapper objectMapper=new ObjectMapper();
//            String s = objectMapper.writeValueAsString(all);
//            System.out.println(s);
//            redisTemplate.boundValueOps("user.findAll").set(s);
//            System.out.println("从数据库中获得数据");
//        }else {
//            System.out.println("从redis中获得数据");
//        }
//    }
}
