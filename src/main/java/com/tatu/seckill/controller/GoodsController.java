package com.tatu.seckill.controller;

import com.tatu.seckill.service.GoodsService;
import com.tatu.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/goods")
@Controller
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/list")
    public String list(Model model) {
        List<GoodsVo> list = goodsService.getList();
        System.out.println("count:"+list.size());
        System.out.println(list.get(0).getSeckillPrice());
        model.addAttribute("goodsList", list);
        return "goods/list";
    }
}
