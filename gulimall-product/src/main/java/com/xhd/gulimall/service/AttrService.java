package com.xhd.gulimall.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.xhd.gulimall.common.utils.PageUtils;
import com.xhd.gulimall.entity.AttrEntity;

import java.util.Map;

/**
 * 商品属性
 *
 * @author xhd
 * @email 1365821818@qq.com
 * @date 2022-07-31 12:18:39
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

