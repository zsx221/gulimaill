package com.xhd.gulimall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhd.gulimall.common.utils.PageUtils;
import com.xhd.gulimall.common.utils.Query;
import com.xhd.gulimall.dao.OrderDao;
import com.xhd.gulimall.entity.OrderEntity;
import com.xhd.gulimall.service.OrderService;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;


@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderDao, OrderEntity> implements OrderService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrderEntity> page = this.page(
                new Query<OrderEntity>().getPage(params),
                new QueryWrapper<OrderEntity>()
        );
        return new PageUtils(page);
    }
    //同一个对象内事务方法互调默认失效，原因绕过了代理对象/事务使用代理对象来控制的
    @Transactional(timeout = 30)//a事务的所有设置就传播到了和他公用一个事务的方法
     public void a() {
    //b，c做任何设置都没用。都是和a公用一个事务this.b();没用
        this.c();//没用
        OrderServiceImpl orderService = (OrderServiceImpl) AopContext.currentProxy();
        orderService.b();
        orderService.c();
        //bService.b(); //ia事务
        //cService.c();//新事务(不回滚)int i = 10/0;
    }
        @Transactional(propagation = Propagation.REQUIRED, timeout = 2)
        public void b () {
            // 7 s
        }
        @Transactional(propagation = Propagation.REQUIRES_NEW, timeout = 20)
        public void c () {
        }
}