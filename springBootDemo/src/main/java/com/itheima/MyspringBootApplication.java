package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/***
 * 启示引导类
 */
@SpringBootApplication
public class MyspringBootApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(MyspringBootApplication.class);
    }

    //返回jsp页面必须继承SpringBootServletInitializer类重写里面的方法
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MyspringBootApplication.class);
    }
}
