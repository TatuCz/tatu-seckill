package com.tatu.seckill.domain;

import lombok.Data;

@Data
public class SeckillOrder {
    private Long id;
    private Long userId;
    private Long orderId;
    private Long goodsId;
}
