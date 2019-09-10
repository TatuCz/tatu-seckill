CREATE TABLE `seckill`.`seckill_order` (
  `id` INT NOT NULL,
  `uid` INT NULL,
  `order_id` BIGINT(20) NULL,
  `goods_id` BIGINT(20) NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB CHARSET=utf8mb4;
