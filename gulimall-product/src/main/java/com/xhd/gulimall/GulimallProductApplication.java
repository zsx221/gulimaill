package com.xhd.gulimall;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@Slf4j
@EnableDiscoveryClient
@EnableCaching
@MapperScan("com.xhd.gulimall.dao")
public class GulimallProductApplication {
    /*合springCache简化缓存开发) 、引入依赖
        spring-boot-starter-cache、 spring-boot-starter-data-redis2)、写配置
        (1)、自动配置了哪些
        CacheAuroConfiguration会导入 RedisCacheConfiguration;自动配好了缓存管理器RedisCacheManager

        (2)、配置使用redis作为缓存

        (3)、测试使用缓存

        @Cacheable:Triggers cache popuLation.:触发将数据保存到缓存的操作
        @CacheEvict:Triggers cache eviction.:触发将数据从缓存删除的操作
        @CachePut: Updates the cache without interfering with the method execution.:不影响方法执行更新缓存
        @Caching:Regroups multiple cache operations to be applied on a method.组合以上多个操作
        @CacheConfig: Shares some common cache-related settings at class-Level.:在类级别共享缓存的相同配置
            1) 、开启缓存功能@EnabLeCaching
            2)、只需要使用注解就能完成缓存操作
        4) 、原理.
        CacheAutoConfiguration -> RedisCacheConfiguration ->
        自动配置了RedisCacheManager->初始化所有的缓存->每个缓存决定使用什么配置->如果redisCacheConfiguration有就用已有的，没有就用默认配置
        ->想改缓存的配置，只需要给容器中放一个RedisCacheConfiguration即可->就会应用到当前RedisCacheManager管理的所有缓存分区中

    * */

    public static void main(String[] args) {
        try {
            SpringApplication.run(GulimallProductApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("报错原因 ============== " + e);
        }
    }

}
