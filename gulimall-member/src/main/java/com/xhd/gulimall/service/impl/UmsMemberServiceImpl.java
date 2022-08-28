package com.xhd.gulimall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhd.gulimall.common.utils.PageUtils;
import com.xhd.gulimall.common.utils.Query;
import com.xhd.gulimall.dao.UmsMemberDao;
import com.xhd.gulimall.entity.UmsMemberEntity;
import com.xhd.gulimall.service.UmsMemberService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("umsMemberService")
public class UmsMemberServiceImpl extends ServiceImpl<UmsMemberDao, UmsMemberEntity> implements UmsMemberService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UmsMemberEntity> page = this.page(
                new Query<UmsMemberEntity>().getPage(params),
                new QueryWrapper<UmsMemberEntity>()
        );

        return new PageUtils(page);
    }

}