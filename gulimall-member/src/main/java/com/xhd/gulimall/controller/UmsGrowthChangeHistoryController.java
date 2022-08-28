package com.xhd.gulimall.controller;

import com.xhd.gulimall.common.utils.PageUtils;
import com.xhd.gulimall.common.utils.R;
import com.xhd.gulimall.entity.UmsGrowthChangeHistoryEntity;
import com.xhd.gulimall.service.UmsGrowthChangeHistoryService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 成长值变化历史记录
 *
 * @author xhd
 * @email 1365821818@qq.com
 * @date 2022-07-31 23:13:04
 */
@RestController
@RequestMapping("gulimall/umsgrowthchangehistory")
public class UmsGrowthChangeHistoryController {
    @Autowired
    private UmsGrowthChangeHistoryService umsGrowthChangeHistoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("gulimall:umsgrowthchangehistory:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = umsGrowthChangeHistoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("gulimall:umsgrowthchangehistory:info")
    public R info(@PathVariable("id") Long id) {
        UmsGrowthChangeHistoryEntity umsGrowthChangeHistory = umsGrowthChangeHistoryService.getById(id);

        return R.ok().put("umsGrowthChangeHistory", umsGrowthChangeHistory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("gulimall:umsgrowthchangehistory:save")
    public R save(@RequestBody UmsGrowthChangeHistoryEntity umsGrowthChangeHistory) {
        umsGrowthChangeHistoryService.save(umsGrowthChangeHistory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("gulimall:umsgrowthchangehistory:update")
    public R update(@RequestBody UmsGrowthChangeHistoryEntity umsGrowthChangeHistory) {
        umsGrowthChangeHistoryService.updateById(umsGrowthChangeHistory);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("gulimall:umsgrowthchangehistory:delete")
    public R delete(@RequestBody Long[] ids) {
        umsGrowthChangeHistoryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
