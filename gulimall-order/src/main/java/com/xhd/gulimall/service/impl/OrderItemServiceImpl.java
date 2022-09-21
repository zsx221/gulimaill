package com.xhd.gulimall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhd.gulimall.common.utils.PageUtils;
import com.xhd.gulimall.common.utils.Query;
import com.xhd.gulimall.dao.OrderItemDao;
import com.xhd.gulimall.entity.OrderItemEntity;
import com.xhd.gulimall.service.OrderItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("orderItemService")
@Slf4j
public class OrderItemServiceImpl extends ServiceImpl<OrderItemDao, OrderItemEntity> implements OrderItemService {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrderItemEntity> page = this.page(
                new Query<OrderItemEntity>().getPage(params),
                new QueryWrapper<OrderItemEntity>()
        );
        return new PageUtils(page);
    }
    /*queues：声明需要监听的所有队列
    *默认传的是message
    * org.springframework.amqp.core.Message
    *参数可以写一下类型
    * 1、Message、message原生消息详细信息。头+体
    * 2、
    * */

    @RabbitListener(queues = ("directQueue"))
    public void receviceMessage(Object message){
        // rabbitTemplate.convertSendAndReceive("directExchange","directExchange","helllo,world,i have receviced");
        System.out.println("接收到消息。。。。内容："+message);
    }
}