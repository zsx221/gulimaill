package com.xhd.gulimall;

import com.xhd.gulimall.entity.UndoLogEntity;
import com.xhd.gulimall.service.UndoLogService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class gulimallWareApplicationTests {
    @Autowired
    UndoLogService undoLogService;

    @Test
    public void contextLoads() {
        UndoLogEntity undoLogEntity = new UndoLogEntity();
        undoLogEntity.setBranchId(898l);
        undoLogEntity.setLogStatus(3434);
        undoLogService.save(undoLogEntity);
        System.out.println("******************添加成功");
    }

}
