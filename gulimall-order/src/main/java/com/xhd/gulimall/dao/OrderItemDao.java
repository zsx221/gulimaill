package com.xhd.gulimall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xhd.gulimall.entity.OrderItemEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 *
 * @author xhd
 * @email 1365821818@qq.com
 * @date 2022-07-31 23:07:23
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {

}
