package com.xhd.gulimall.controller;

import com.xhd.gulimall.common.utils.PageUtils;
import com.xhd.gulimall.common.utils.R;
import com.xhd.gulimall.entity.UmsMemberEntity;
import com.xhd.gulimall.openfeign.CouponFenignService;
import com.xhd.gulimall.service.UmsMemberService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 会员
 *
 * @author xhd
 * @email 1365821818@qq.com
 * @date 2022-07-31 23:13:04
 */
@RestController
@RequestMapping("gulimall/umsmember")
public class UmsMemberController {
    @Autowired
    private UmsMemberService umsMemberService;

    @Autowired
    CouponFenignService couponFenignService;
    @RequestMapping("/coupons")
    public  R test(){
        UmsMemberEntity memberEntity=new UmsMemberEntity();
        memberEntity.setNickname("张三");
        R membercoupons=couponFenignService.membercoupons();
        return  R.ok().put("member",membercoupons).put("coupons",membercoupons.get("coupons"));
    }
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("gulimall:umsmember:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = umsMemberService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("gulimall:umsmember:info")
    public R info(@PathVariable("id") Long id) {
        UmsMemberEntity umsMember = umsMemberService.getById(id);

        return R.ok().put("umsMember", umsMember);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("gulimall:umsmember:save")
    public R save(@RequestBody UmsMemberEntity umsMember) {
        umsMemberService.save(umsMember);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("gulimall:umsmember:update")
    public R update(@RequestBody UmsMemberEntity umsMember) {
        umsMemberService.updateById(umsMember);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("gulimall:umsmember:delete")
    public R delete(@RequestBody Long[] ids) {
        umsMemberService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
