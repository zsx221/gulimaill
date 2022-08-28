package com.xhd.gulimall;

import com.xhd.gulimall.entity.CouponEntity;
import com.xhd.gulimall.service.CouponService;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GulimallProductApplicationTests {
    @Autowired
    CouponService couponService;

    @Test
    void contextLoads() {
        CouponEntity couponEntity = new CouponEntity();
        couponEntity.setCouponImg("最落魄");
        couponEntity.setCouponName("crazy Friday");
        couponService.save(couponEntity);
        System.out.println("保存成功");
    }

}
