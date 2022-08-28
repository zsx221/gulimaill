package com.xhd.gulimall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xhd.gulimall.common.utils.PageUtils;
import com.xhd.gulimall.entity.WmsPurchaseEntity;

import java.util.Map;

/**
 * 采购信息
 *
 * @author xhd
 * @email 1365821818@qq.com
 * @date 2022-07-31 23:11:03
 */
public interface WmsPurchaseService extends IService<WmsPurchaseEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

