package com.xhd.gulimall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xhd.gulimall.entity.OrderOperateHistoryEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单操作历史记录
 *
 * @author xhd
 * @email 1365821818@qq.com
 * @date 2022-07-31 23:07:23
 */
@Mapper
public interface OrderOperateHistoryDao extends BaseMapper<OrderOperateHistoryEntity> {

}
