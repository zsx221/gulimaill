package com.xhd.gulimall;

import com.xhd.gulimall.entity.UmsGrowthChangeHistoryEntity;
import com.xhd.gulimall.service.UmsGrowthChangeHistoryService;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GulimallMemberApplicationTests {
    @Autowired
    UmsGrowthChangeHistoryService umsGrowthChangeHistoryService;

    @Test
    void contextLoads() {
        UmsGrowthChangeHistoryEntity umsGrowthChangeHistoryEntity = new UmsGrowthChangeHistoryEntity();
        umsGrowthChangeHistoryEntity.setId(2l);
        umsGrowthChangeHistoryEntity.setNote("d");
        umsGrowthChangeHistoryService.save(umsGrowthChangeHistoryEntity);
        System.out.println("*************************成功");
    }

}
