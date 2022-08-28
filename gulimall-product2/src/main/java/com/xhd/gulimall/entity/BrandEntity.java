package com.xhd.gulimall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xhd.gulimall.common.valid.AddGroup;
import com.xhd.gulimall.common.valid.UpdateGroup;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;

/**
 * 品牌
 *
 * @author xhd
 * @email 1365821818@qq.com
 * @date 2022-07-31 12:18:40
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 品牌id
     */
    @TableId
    @Null(message = "插入数据不需要id",groups = {AddGroup.class})
    @NotNull(message = "修改数据必须携带id",groups = {UpdateGroup.class})
    private Long brandId;
    /**
     * 品牌名
     */

    private String name;
    /**
     * 品牌logo地址
     */
    @NotNull(message = "logo不能为空" ,groups = {AddGroup.class,UpdateGroup.class})
    @URL(message = "logo必须是一个合法的url地址",groups = {AddGroup.class,UpdateGroup.class})
    private String logo;
    /**
     * 介绍
     */
    private String descript;
    /**
     * 显示状态[0-不显示；1-显示]
     */
    private Integer showStatus;
    /**
     * 检索首字母
     */
    private String firstLetter;
    /**
     * 排序
     */
    @Min(value = 0,message = "最小不能小于0",groups = {AddGroup.class,UpdateGroup.class} )
        private Integer sort;

}
