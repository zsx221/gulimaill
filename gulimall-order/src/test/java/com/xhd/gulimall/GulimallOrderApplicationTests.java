package com.xhd.gulimall;

import com.xhd.gulimall.entity.OrderEntity;
import com.xhd.gulimall.service.OrderService;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GulimallOrderApplicationTests {
    @Autowired
    OrderService service;

    @Test
    void contextLoads() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderSn("fjhdfj");
        service.save(orderEntity);
        System.out.println("******************ok");
    }

}
