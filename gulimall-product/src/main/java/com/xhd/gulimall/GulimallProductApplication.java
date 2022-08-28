package com.xhd.gulimall;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@Slf4j
@EnableDiscoveryClient
@MapperScan("com.xhd.gulimall.dao")
public class GulimallProductApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(GulimallProductApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("报错原因 ============== " + e);
        }
    }

}
