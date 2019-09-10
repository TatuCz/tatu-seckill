package com.tatu.seckill.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Goods {
    private Long id;
    private String name;
    private String title;
    private String imgUrl;
    private String description;
    private Double price;
    private Integer stock;
}
