package com.xhd.gulimall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/*
* 使用rabbitmq步骤
*  1、引入amqp场景,  RabbitAutoConfiguration会自动生效
 * 2、给容器中配置了rabbitTemplate、MessagingTemplateConfiguration、amqpAdmin、CachingConnectionFactory
 *      所有的属性都是spring.rabbitmq
 *      @ConfigurationProperties(prefix="spring.rabbitmq")
 * 3、给配置文件中添加必要配置

 * 4、开启扫描组件，@EnableRabbit
* */
@EnableRabbit
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.xhd.gulimall.dao")
public class GulimallorderApplication {
    public static void main(String[] args) {
        SpringApplication.run(GulimallorderApplication.class, args);
    }

}
