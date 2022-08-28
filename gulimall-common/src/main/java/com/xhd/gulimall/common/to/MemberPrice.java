package com.xhd.gulimall.common.to;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author xhd
 */
@Data
public class MemberPrice {
    private Long id;
    private String name;
    private BigDecimal price;
}
