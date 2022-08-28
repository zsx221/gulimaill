package com.xhd.gulimall.common.to;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author xhd
 */
@Data
public class SpuBoundTo {
    private Long spuId;
    private BigDecimal buyBounds;
    private BigDecimal growBounds;
}
