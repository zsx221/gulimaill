package com.xhd.gulimall.controller;

import com.xhd.gulimall.common.utils.PageUtils;
import com.xhd.gulimall.common.utils.R;
import com.xhd.gulimall.entity.UmsMemberCollectSubjectEntity;
import com.xhd.gulimall.service.UmsMemberCollectSubjectService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 会员收藏的专题活动
 *
 * @author xhd
 * @email 1365821818@qq.com
 * @date 2022-07-31 23:13:04
 */
@RestController
@RequestMapping("gulimall/umsmembercollectsubject")
public class UmsMemberCollectSubjectController {
    @Autowired
    private UmsMemberCollectSubjectService umsMemberCollectSubjectService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("gulimall:umsmembercollectsubject:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = umsMemberCollectSubjectService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("gulimall:umsmembercollectsubject:info")
    public R info(@PathVariable("id") Long id) {
        UmsMemberCollectSubjectEntity umsMemberCollectSubject = umsMemberCollectSubjectService.getById(id);

        return R.ok().put("umsMemberCollectSubject", umsMemberCollectSubject);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("gulimall:umsmembercollectsubject:save")
    public R save(@RequestBody UmsMemberCollectSubjectEntity umsMemberCollectSubject) {
        umsMemberCollectSubjectService.save(umsMemberCollectSubject);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("gulimall:umsmembercollectsubject:update")
    public R update(@RequestBody UmsMemberCollectSubjectEntity umsMemberCollectSubject) {
        umsMemberCollectSubjectService.updateById(umsMemberCollectSubject);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("gulimall:umsmembercollectsubject:delete")
    public R delete(@RequestBody Long[] ids) {
        umsMemberCollectSubjectService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
