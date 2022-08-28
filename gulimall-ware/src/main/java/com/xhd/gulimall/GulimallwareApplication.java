package com.xhd.gulimall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.xhd.gulimall.dao")
public class GulimallwareApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallwareApplication.class, args);
    }

}
