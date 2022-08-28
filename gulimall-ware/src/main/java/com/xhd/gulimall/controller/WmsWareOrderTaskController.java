package com.xhd.gulimall.controller;

import com.xhd.gulimall.common.utils.PageUtils;
import com.xhd.gulimall.common.utils.R;
import com.xhd.gulimall.entity.WmsWareOrderTaskEntity;
import com.xhd.gulimall.service.WmsWareOrderTaskService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 库存工作单
 *
 * @author xhd
 * @email 1365821818@qq.com
 * @date 2022-07-31 23:11:02
 */
@RestController
@RequestMapping("gulimall/wmswareordertask")
public class WmsWareOrderTaskController {
    @Autowired
    private WmsWareOrderTaskService wmsWareOrderTaskService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("gulimall:wmswareordertask:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = wmsWareOrderTaskService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("gulimall:wmswareordertask:info")
    public R info(@PathVariable("id") Long id) {
        WmsWareOrderTaskEntity wmsWareOrderTask = wmsWareOrderTaskService.getById(id);

        return R.ok().put("wmsWareOrderTask", wmsWareOrderTask);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("gulimall:wmswareordertask:save")
    public R save(@RequestBody WmsWareOrderTaskEntity wmsWareOrderTask) {
        wmsWareOrderTaskService.save(wmsWareOrderTask);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("gulimall:wmswareordertask:update")
    public R update(@RequestBody WmsWareOrderTaskEntity wmsWareOrderTask) {
        wmsWareOrderTaskService.updateById(wmsWareOrderTask);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("gulimall:wmswareordertask:delete")
    public R delete(@RequestBody Long[] ids) {
        wmsWareOrderTaskService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
