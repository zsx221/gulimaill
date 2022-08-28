package com.xhd.gulimall.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class redissionConfig {
    @Bean
    public RedissonClient redissonClient(){
        // connects to 127.0.0.1:6379 by default
//        RedissonClient redisson = Redisson.create();
        Config config = new Config();
        config.useSingleServer().setAddress("redis://182.61.138.205:6378");
        RedissonClient redisson = Redisson.create(config);
        return redisson;
    }
}
