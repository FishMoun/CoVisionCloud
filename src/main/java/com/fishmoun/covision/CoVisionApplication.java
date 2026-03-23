package com.fishmoun.covision;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;


@MapperScan("com.fishmoun.covision.mapper")
@EnableAspectJAutoProxy(exposeProxy = true)
@SpringBootApplication
@EnableAsync
public class CoVisionApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoVisionApplication.class, args);
    }

}
