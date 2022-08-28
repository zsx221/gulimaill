package com.xhd.gulimall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xhd.gulimall.entity.CategoryBrandRelationEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 品牌分类关联
 *
 * @author xhd
 * @email 1365821818@qq.com
 * @date 2022-07-31 12:18:40
 */
@Mapper
public interface CategoryBrandRelationDao extends BaseMapper<CategoryBrandRelationEntity> {
    void updateCatogory(@Param("catId") Long catId, @Param("name") String name);
}
