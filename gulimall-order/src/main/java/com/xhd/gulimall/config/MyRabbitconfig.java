package com.xhd.gulimall.config;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRabbitconfig {
    @Autowired
    RabbitTemplate rabbitTemplate;

    //使用json序列化机制，进行消息转换
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    //定制Rabbitmq回调机制
    /*  1、第一步开启发送端确定
    *       spring.rabbitmq.publisher-confirms=true
    *   2、消息成功回调
    * #开启发生端抵达队列的确认
        spring.rabbitmq.publisher-returns=true
        #只要抵达队列，以异步发送优先回调我们这个returnconfirm
        spring.rabbitmq.template.mandatory=true
    * */
    public void initRabbitTemplate(){

        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            /*  @Param correlationData  关联的唯一id
             *  @Param ack  消息是否成功收到
             *  @Param  cause 失败的原因
             * */
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                System.out.println("confirm...correlationData"+correlationData+"是否ack :"+ack+"失败的原因cause"+cause);
            }
        });
        //设置消息抵达队列的回调机制
        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {

            @Override
            public void returnedMessage(Message message, int i, String s, String s1, String s2) {

            }
        });
    }
}
