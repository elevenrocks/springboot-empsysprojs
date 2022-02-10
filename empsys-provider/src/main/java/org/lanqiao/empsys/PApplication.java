package org.lanqiao.empsys;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableDubbo
@MapperScan("org.lanqiao.empsys.dao")
@EnableCaching
public class PApplication {

    public static void main(String[] args) {
        SpringApplication.run(PApplication.class, args);
    }

}
