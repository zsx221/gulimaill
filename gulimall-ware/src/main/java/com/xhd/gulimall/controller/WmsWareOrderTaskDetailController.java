package com.xhd.gulimall.controller;

import com.xhd.gulimall.common.utils.PageUtils;
import com.xhd.gulimall.common.utils.R;
import com.xhd.gulimall.entity.WmsWareOrderTaskDetailEntity;
import com.xhd.gulimall.service.WmsWareOrderTaskDetailService;
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
@RequestMapping("gulimall/wmswareordertaskdetail")
public class WmsWareOrderTaskDetailController {
    @Autowired
    private WmsWareOrderTaskDetailService wmsWareOrderTaskDetailService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("gulimall:wmswareordertaskdetail:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = wmsWareOrderTaskDetailService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("gulimall:wmswareordertaskdetail:info")
    public R info(@PathVariable("id") Long id) {
        WmsWareOrderTaskDetailEntity wmsWareOrderTaskDetail = wmsWareOrderTaskDetailService.getById(id);

        return R.ok().put("wmsWareOrderTaskDetail", wmsWareOrderTaskDetail);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("gulimall:wmswareordertaskdetail:save")
    public R save(@RequestBody WmsWareOrderTaskDetailEntity wmsWareOrderTaskDetail) {
        wmsWareOrderTaskDetailService.save(wmsWareOrderTaskDetail);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("gulimall:wmswareordertaskdetail:update")
    public R update(@RequestBody WmsWareOrderTaskDetailEntity wmsWareOrderTaskDetail) {
        wmsWareOrderTaskDetailService.updateById(wmsWareOrderTaskDetail);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("gulimall:wmswareordertaskdetail:delete")
    public R delete(@RequestBody Long[] ids) {
        wmsWareOrderTaskDetailService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
