package com.xhd.gulimall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.xhd.gulimall.dao")
public class  GulimallcouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallcouponApplication.class, args);
    }

}
