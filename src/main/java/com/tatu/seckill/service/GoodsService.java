package com.tatu.seckill.service;

import com.tatu.seckill.dao.GoodsMapper;
import com.tatu.seckill.domain.Goods;
import com.tatu.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    public List<GoodsVo> getList() {
        return goodsMapper.getList();
    }

    public GoodsVo getDetail(long goodsId) {
        return goodsMapper.getDetail(goodsId);
    }
}
