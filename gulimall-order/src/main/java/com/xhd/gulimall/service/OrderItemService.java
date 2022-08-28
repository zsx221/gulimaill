package com.xhd.gulimall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xhd.gulimall.common.utils.PageUtils;
import com.xhd.gulimall.entity.OrderItemEntity;

import java.util.Map;

/**
 * 订单项信息
 *
 * @author xhd
 * @email 1365821818@qq.com
 * @date 2022-07-31 23:07:23
 */
public interface OrderItemService extends IService<OrderItemEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

