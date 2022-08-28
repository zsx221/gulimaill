package com.xhd.gulimall.controller;

import com.xhd.gulimall.common.utils.PageUtils;
import com.xhd.gulimall.common.utils.R;
import com.xhd.gulimall.entity.WmsWareInfoEntity;
import com.xhd.gulimall.service.WmsWareInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 仓库信息
 *
 * @author xhd
 * @email 1365821818@qq.com
 * @date 2022-07-31 23:11:02
 */
@RestController
@RequestMapping("gulimall/wmswareinfo")
public class WmsWareInfoController {
    @Autowired
    private WmsWareInfoService wmsWareInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("gulimall:wmswareinfo:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = wmsWareInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("gulimall:wmswareinfo:info")
    public R info(@PathVariable("id") Long id) {
        WmsWareInfoEntity wmsWareInfo = wmsWareInfoService.getById(id);

        return R.ok().put("wmsWareInfo", wmsWareInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("gulimall:wmswareinfo:save")
    public R save(@RequestBody WmsWareInfoEntity wmsWareInfo) {
        wmsWareInfoService.save(wmsWareInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("gulimall:wmswareinfo:update")
    public R update(@RequestBody WmsWareInfoEntity wmsWareInfo) {
        wmsWareInfoService.updateById(wmsWareInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("gulimall:wmswareinfo:delete")
    public R delete(@RequestBody Long[] ids) {
        wmsWareInfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
