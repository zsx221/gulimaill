package com.xhd.gulimall;

import com.xhd.gulimall.entity.BrandEntity;
import com.xhd.gulimall.service.BrandService;

import lombok.val;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.UUID;

@SpringBootTest
class GulimallProductApplicationTests {

    @Autowired
    BrandService brandService;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void name() {
    }

    @Test
    void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setDescript("hello");
        brandEntity.setName("华为");
        brandService.save(brandEntity);
        System.out.println("保存成功");
    }
    @Test
    void redisTest(){
        ValueOperations<String,String> ops = stringRedisTemplate.opsForValue();
        //保存
        ops.set("hello","word"+ UUID.randomUUID().toString());
        //查询
        String hello = ops.get("hello");
        System.out.println(hello);
    }
}
