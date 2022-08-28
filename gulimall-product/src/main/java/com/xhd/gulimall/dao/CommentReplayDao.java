package com.xhd.gulimall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xhd.gulimall.entity.CommentReplayEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品评价回复关系
 *
 * @author xhd
 * @email 1365821818@qq.com
 * @date 2022-07-31 12:18:40
 */
@Mapper
public interface CommentReplayDao extends BaseMapper<CommentReplayEntity> {

}
