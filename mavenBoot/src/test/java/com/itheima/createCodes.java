package com.itheima;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MavenBootApplication.class)
public class createCodes {

    @Test
    public void testGenerator(){
        //1.全局配置
        GlobalConfig config=new GlobalConfig();
        config.setActiveRecord(true)                 //是否支持AR模式
            .setAuthor("lyy")                        //作者
            .setOutputDir("E:\\xrls_p\\mavenBoot\\src\\main\\java")         //生成路径
            .setFileOverride(true)                   //文件覆盖
            .setIdType(IdType.AUTO)                  //主键策略
            .setServiceName("%sService")             //设置生成的service接口中是否有I
            .setBaseResultMap(true)
                .setEnableCache(false)               //开启二级缓存
            .setBaseColumnList(true);

        //2.数据源配置
        DataSourceConfig dsConfig=new DataSourceConfig();
                dsConfig.setDbType(DbType.MYSQL)       //数据库类型
                .setDriverName("com.mysql.jdbc.Driver")
                .setUrl("jdbc:mysql://localhost:3306/test?serverTimezone=UTC&&useUnicode=true&characterEncoding=utf8")
                .setUsername("root")
                .setPassword("root1234");
        //3.策略配置
        StrategyConfig stConfig =new StrategyConfig();
        stConfig.setCapitalMode(true)                 //全局大写命名
                .setDbColumnUnderline(true)           //指定表明 字段名是否使用下滑线
                .setNaming(NamingStrategy.underline_to_camel) //数据库表转驼峰命名策略
                .setInclude("user");                //要生成的表  (重要)
        //4.包名策略配置
        PackageConfig pkConfig=new PackageConfig();
        pkConfig.setParent("com.itheima")
                .setMapper("mapper")
                .setService("service")
                .setController("controller")
                .setEntity("beans")
                .setXml("mapper");
        //5.整合配置
        AutoGenerator ag=new AutoGenerator();
        ag.setGlobalConfig(config);
        ag.setDataSource(dsConfig);
        ag.setStrategy(stConfig);
        ag.setPackageInfo(pkConfig);
        //6.执行
        ag.execute();
    }
}
