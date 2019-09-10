CREATE TABLE `seckill`.`order_detail` (
  `id` INT NOT NULL,
  `uid` INT NULL,
  `goods_id` BIGINT(20) NULL,
  `delivery_addr_id` BIGINT(20) NULL COMMENT '收获地址id',
  `goods_name` VARCHAR(45) NULL,
  `goods_count` INT(11) NULL DEFAULT 0,
  `goods_price` DECIMAL(10,2) NULL DEFAULT 0.00,
  `order_channel` TINYINT(4) NULL DEFAULT 0 COMMENT '下单渠道，1:PC，2:WAP，3:Android，4:iOS',
  `status` TINYINT(4) NULL COMMENT '0:下单未支付，1:已支付，2:已发货，3:已收货，4:退款中，5:已退款，6:完成',
  `create_date` DATETIME NULL COMMENT '下单时间',
  `pay_date` DATETIME NULL COMMENT '支付时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB CHARSET=utf8mb4;
