package com.xhd.gulimall.controller;

import com.xhd.gulimall.common.utils.PageUtils;
import com.xhd.gulimall.common.utils.R;
import com.xhd.gulimall.entity.WmsPurchaseEntity;
import com.xhd.gulimall.service.WmsPurchaseService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 采购信息
 *
 * @author xhd
 * @email 1365821818@qq.com
 * @date 2022-07-31 23:11:03
 */
@RestController
@RequestMapping("gulimall/wmspurchase")
public class WmsPurchaseController {
    @Autowired
    private WmsPurchaseService wmsPurchaseService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("gulimall:wmspurchase:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = wmsPurchaseService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("gulimall:wmspurchase:info")
    public R info(@PathVariable("id") Long id) {
        WmsPurchaseEntity wmsPurchase = wmsPurchaseService.getById(id);

        return R.ok().put("wmsPurchase", wmsPurchase);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("gulimall:wmspurchase:save")
    public R save(@RequestBody WmsPurchaseEntity wmsPurchase) {
        wmsPurchaseService.save(wmsPurchase);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("gulimall:wmspurchase:update")
    public R update(@RequestBody WmsPurchaseEntity wmsPurchase) {
        wmsPurchaseService.updateById(wmsPurchase);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("gulimall:wmspurchase:delete")
    public R delete(@RequestBody Long[] ids) {
        wmsPurchaseService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
