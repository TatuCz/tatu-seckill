package com.tatu.seckill.dao;

import com.tatu.seckill.vo.GoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodsMapper {

    @Select("SELECT g.*, sg.stock_count, sg.start_date, sg.end_date, sg.price AS seckill_price FROM seckill_goods sg LEFT JOIN goods g ON sg.id = g.id")
    List<GoodsVo> getList();



}
