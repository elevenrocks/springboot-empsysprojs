package org.lanqiao.empsys;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class CApplication {

    public static void main(String[] args) {
        SpringApplication.run(CApplication.class, args);
    }

}
