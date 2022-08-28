package com.xhd.gulimall;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.UUID;

public class test {

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Test
   public void redisTest(){
        ValueOperations<String,String> ops = stringRedisTemplate.opsForValue();
        //保存
        ops.set("hello","word"+ UUID.randomUUID().toString());
        //查询
        String hello = ops.get("hello");
        System.out.println(hello);
    }
}
