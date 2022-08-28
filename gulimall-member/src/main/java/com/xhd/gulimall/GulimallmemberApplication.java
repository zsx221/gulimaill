package com.xhd.gulimall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.xhd.gulimall.openfeign")
@EnableDiscoveryClient
@MapperScan("com.xhd.gulimall.dao")
public class GulimallmemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallmemberApplication.class, args);
    }

}
