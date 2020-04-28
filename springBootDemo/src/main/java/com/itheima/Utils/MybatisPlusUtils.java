package com.itheima.Utils;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.plugins.SqlExplainInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author: Lyy
 * @date: 2020/4/8
 * @time: 17:26
 */
@Configuration
@MapperScan("com.itheima.mapper")
public class MybatisPlusUtils {

    /***
     * 注册分页插件
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor page=new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
                        }

    /***
     * 防止误删全表
     * @return
     */
    @Bean
    public SqlExplainInterceptor sqlExplainInterceptor(){
                                SqlExplainInterceptor sql=new SqlExplainInterceptor();
                                sql.setStopProceed(true);
                               return sql;
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
