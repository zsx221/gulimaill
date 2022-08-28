package com.xhd.gulimall.controller;

import com.alibaba.fastjson.JSON;
import com.xhd.gulimall.common.utils.R;
import com.xhd.gulimall.service.CategoryService;
import com.xhd.gulimall.vo.Catelog2Vo;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
public class TestController {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    CategoryService categoryService;

//    @Autowired
//    Jedis jedis;

    @RequestMapping("/test")
    public R redisTest(){
        ValueOperations<String,String> ops = stringRedisTemplate.opsForValue();
        //保存
        ops.set("hello","word"+ UUID.randomUUID().toString());
        //查询
        String hello = ops.get("hello");
        return R.ok(hello).put("hello",hello);
    }
    //ToDo产生堆外内存溢出:OutOfDirectMemoryError
//1) 、springboot2.e以后默认使用lettuce作为操作redis的客户端。它使用netty进行网络通信
//2)、lettuce的bug导致netty堆外内存溢出-Xmx300m; netty如果没有指定堆外内存，默认使用-Xmx300m[/可以通过-Dio.netty .maxDirectMemory进行设置

//解决方案:不能使用-Dio.netty.maxDirectMemory只去调大堆外内存。

// 1/1)、升级Lettuce客户端。2)、切换使用jedis
    //lettuce、jedis都封装了redistemplte
    //使用jedis 操作redis
    @RequestMapping("/test2")
    public R redisTest2(){

        String redisCategory = stringRedisTemplate.opsForValue().get("Redisvalue2");
        if (StringUtils.isEmpty(redisCategory))//缓存没有
        {
            Map<String, List<Catelog2Vo>> json = categoryService.getCatalogJson();
            String s = JSON.toJSONString(json);
            stringRedisTemplate.opsForValue().set("RedisCategory2",s);
//            stringRedisTemplate.opsForValue().set
            return R.ok(s).put("RedisCategory2",redisCategory);
        }
        String s = JSON.toJSONString(redisCategory);
        return R.ok(s).put("RedisCategory",redisCategory);
    }
    @RequestMapping("/test3")//解决缓存穿透问题,缓存穿透意味着数据库没有这个数据，但是这个时候有大量的请求过来，这个时候我们需要设置这个数据为null，并且设置过期时间
    //然后传给缓存
    public R redisTest3(){
        String redisCategory = stringRedisTemplate.opsForValue().get("RedisCategory3");
        if (StringUtils.isEmpty(redisCategory))//缓存没有
        {
            Map<String, List<Catelog2Vo>> json = categoryService.getCatalogJson();
            if(StringUtils.isEmpty(json))
            {
                stringRedisTemplate.opsForValue().set("RedisCategory3", String.valueOf(json),1l, TimeUnit.HOURS);
            }
            String s = JSON.toJSONString(json);
            stringRedisTemplate.opsForValue().set("RedisCategory2",s);
//            stringRedisTemplate.opsForValue().set
            return R.ok(s).put("RedisCategory2",redisCategory);
        }
        String s = JSON.toJSONString(redisCategory);
        return R.ok(s).put("RedisCategory",redisCategory);
    }

    /*
    *解决缓存击穿问题
    * 1、缓存击穿：大量的并发到一个热点数据，但是这个热点key在缓存中的过期时间已经过去了，那么这个时候会对数据库有大量的压力
    * 2、解决方案：加锁，当缓存里面没有数据时，我们需要去数据库去查询，进行加锁的操作，等查询完，然后在缓存中添加此key时，我们可以
    * 再去缓存中去找，这样就减轻了数据库的压力
    * */
    @RequestMapping("/test4")
    public R redisTest4(){
        String redisCategory = stringRedisTemplate.opsForValue().get("catalogJSON");
        if (StringUtils.isEmpty(redisCategory))//缓存没有
        {
            Map<String, List<Catelog2Vo>> locallock = categoryService.getCatalogJsonFromDbWithLocallock();
            String key=JSON.toJSONString(locallock);
            return R.ok(key).put("catalogJSON",key);
        }
        System.out.println("缓存命中，直接返回");
        String s = JSON.toJSONString(redisCategory);
        return R.ok(s).put("catalogJSON",redisCategory);
    }
    //解决缓存击穿问题：使用redis分布式锁来解决。
    @RequestMapping("/test5")
    public R redisTest5(){
        String redisCategory = stringRedisTemplate.opsForValue().get("catalogJSON");
        if (StringUtils.isEmpty(redisCategory))//缓存没有
        {
            Map<String, List<Catelog2Vo>> locallock = categoryService.getCatalogJson2();
            String key=JSON.toJSONString(locallock);
            return R.ok(key).put("catalogJSON",key);
        }
        System.out.println("缓存命中，直接返回");
        String s = JSON.toJSONString(redisCategory);
        return R.ok(s).put("catalogJSON",redisCategory);
    }
}
