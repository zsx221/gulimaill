package com.xhd.gulimall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xhd.gulimall.common.utils.PageUtils;
import com.xhd.gulimall.entity.AttrGroupEntity;

import java.util.Map;

/**
 * 属性分组
 *
 * @author xhd
 * @email 1365821818@qq.com
 * @date 2022-07-31 12:18:40
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

