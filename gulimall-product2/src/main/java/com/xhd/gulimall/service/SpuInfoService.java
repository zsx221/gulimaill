package com.xhd.gulimall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xhd.gulimall.common.utils.PageUtils;
import com.xhd.gulimall.entity.SpuInfoEntity;

import java.util.Map;

/**
 * spu信息
 *
 * @author xhd
 * @email 1365821818@qq.com
 * @date 2022-07-31 12:18:40
 */
public interface SpuInfoService extends IService<SpuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

