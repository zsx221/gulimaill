package com.xhd.gulimall.openfeign;

import com.xhd.gulimall.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
/* 1、想要远程调用别的服务
        1)引入open-feign
        2)编写一个接口,告诉SpringCloud这个接口需要调用远程服务
            1、声明接口的每一个方法都是调用哪个远程服务的那个请求
        3)开启远程调用功能
        */

@FeignClient("gulimall-coupon")
public interface CouponFenignService {
    @RequestMapping("/gulimall/coupon/member/list")
    public R membercoupons();
}
