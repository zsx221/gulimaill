package com.xhd.gulimall;

import com.xhd.gulimall.entity.OrderEntity;
import com.xhd.gulimall.service.OrderService;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@Slf4j
@RunWith(SpringRunner.class)
public class GulimallOrderApplicationTests {
    @Autowired
    OrderService service;

    @Autowired
    AmqpAdmin amqpAdmin;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void contextLoads() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderSn("fjhdfj");
        service.save(orderEntity);
        System.out.println("******************ok");
    }
    //收发消息
    //使用rabbitTemplte来收发
    @Test
    public void sendMessage(){
        rabbitTemplate.convertAndSend("directExchange","directExchange","helllo,world");
        log.info("消息发送完成");
    }

    /*
    * 1、如何创建Exchange、Queue、Bing
    *   1）、使用amqpAdmin进行创建
    * 2、如何如何收发消息
    * */
    @Test
    public void createExchange(){
        //amqpAdmin
        /*
        DirectExchange(String name, boolean durable, boolean autoDelete)
        * */
        //配置exchange
        amqpAdmin.declareExchange(new DirectExchange("directExchange",true,false));
        log.info("Exchange创建成功");
    }

    @Test
    public void createQueue(){
        //创建队列queue
        /*
        * Queue(String name, boolean durable, boolean exclusive, boolean autoDelete)
        * */
        amqpAdmin.declareQueue(new Queue("directQueue",true,false,false));
        log.info("创建队列queue成功");
    }

    @Test
    public void createBing(){
        //把交互机和队列绑定
        /*
        *
        * String destination（目的地）, DestinationType destinationType(目的地类型), String exchange, String routingKey, Map<String, Object> arguments
        * 将exchange指定的交换机和destination目的地进行绑定，
        *
        * */
        amqpAdmin.declareBinding(new Binding("directQueue",
                Binding.DestinationType.QUEUE,
                "directExchange",
                "directExchange",
                null));
        log.info("创建交换机directModel成功");
    }
}
