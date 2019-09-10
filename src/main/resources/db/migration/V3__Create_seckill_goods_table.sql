CREATE TABLE `seckill`.`seckill_goods` (
  `id` BIGINT(20) NOT NULL,
  `goods_id` BIGINT(20) NOT NULL,
  `price` DECIMAL(10,2) NULL DEFAULT 0.00 COMMENT '秒杀价格',
  `stock_count` INT(11) NULL DEFAULT 0,
  `start_date` DATETIME NULL COMMENT '秒杀开始时间',
  `end_date` DATETIME NULL COMMENT '秒杀结束时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB CHARSET=utf8mb4;
