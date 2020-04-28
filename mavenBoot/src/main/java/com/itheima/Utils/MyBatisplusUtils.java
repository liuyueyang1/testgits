package com.itheima.Utils;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.itheima.mapper")
public class MyBatisplusUtils {
    /***
     * 分页
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor page=new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
        }
    /**
     * 显示sql
     * @return
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor(){
        PerformanceInterceptor pf=new PerformanceInterceptor();
        return pf;
    }

}
