package com.xhd.gulimall.controller;

import com.xhd.gulimall.common.utils.PageUtils;
import com.xhd.gulimall.common.utils.R;
import com.xhd.gulimall.entity.WmsPurchaseDetailEntity;
import com.xhd.gulimall.service.WmsPurchaseDetailService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * @author xhd
 * @email 1365821818@qq.com
 * @date 2022-07-31 23:11:02
 */
@RestController
@RequestMapping("gulimall/wmspurchasedetail")
public class WmsPurchaseDetailController {
    @Autowired
    private WmsPurchaseDetailService wmsPurchaseDetailService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("gulimall:wmspurchasedetail:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = wmsPurchaseDetailService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("gulimall:wmspurchasedetail:info")
    public R info(@PathVariable("id") Long id) {
        WmsPurchaseDetailEntity wmsPurchaseDetail = wmsPurchaseDetailService.getById(id);

        return R.ok().put("wmsPurchaseDetail", wmsPurchaseDetail);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("gulimall:wmspurchasedetail:save")
    public R save(@RequestBody WmsPurchaseDetailEntity wmsPurchaseDetail) {
        wmsPurchaseDetailService.save(wmsPurchaseDetail);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("gulimall:wmspurchasedetail:update")
    public R update(@RequestBody WmsPurchaseDetailEntity wmsPurchaseDetail) {
        wmsPurchaseDetailService.updateById(wmsPurchaseDetail);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("gulimall:wmspurchasedetail:delete")
    public R delete(@RequestBody Long[] ids) {
        wmsPurchaseDetailService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
