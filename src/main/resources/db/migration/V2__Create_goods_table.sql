CREATE TABLE `seckill`.`goods` (
  `id` INT NOT NULL COMMENT '商品id',
  `name` VARCHAR(45) NULL COMMENT '商品名称',
  `title` VARCHAR(45) NULL COMMENT '商品标题',
  `img_url` VARCHAR(256) NULL,
  `description` LONGTEXT NULL COMMENT '商品详情',
  `price` DECIMAL(10,2) NULL DEFAULT 0.00 COMMENT '商品价格',
  `stock` INT(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB CHARSET=utf8mb4;