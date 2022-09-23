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
 * 5、监听消息:使用eRabbitListener;必须有@EnabLeRabbit
        @Rabbitlistener:类+方法上(监听哪些队列即可)
        *
        @RabbitHandler:标在方法上(重载区分不同的消息)本地事务失效间题
        *
        同一个对象内事务方法互调默认失效，原因绕过了代理对象，事务使用代理对象来控制的解决:使用代理对象来调用事务方法
            1)、引入aop-starter;spring-boot-starter-aop; 引入了aspectj
            2) 、@EnableAspectJAutoProxy(exposeProxy = true);开启aspectj动态代理功能。以后所有的动态代理都是aspee
        对外暴露代理对象
        3)、本类互调用调用对象
            OrderServiceImpl orderService = (OrderServiceImpl ) AopContext.currentProxy();
            orderService.b();
            orderService.c();

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
