package com.tatu.seckill.controller;

import com.tatu.seckill.domain.Goods;
import com.tatu.seckill.service.GoodsService;
import com.tatu.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/detail/{id}")
    public String detail(Model model,
                         @PathVariable("id") long id) {
        GoodsVo goods = goodsService.getDetail(id);
        model.addAttribute("goods", goods);

        int seckillStatus = 0;
        long remainSeconds = 0;
        long nowTs = System.currentTimeMillis();
        long startTime = goods.getStartDate().getTime();
        long endTime = goods.getEndDate().getTime();

        if (startTime > nowTs) { //倒计时
            remainSeconds = (startTime - nowTs) / 1000;
        } else if (startTime < nowTs && endTime > nowTs) { //进行中
            seckillStatus = 1;
        }  else if (endTime < nowTs) { //已结束
            seckillStatus = 2;
        }


        model.addAttribute("seckillStatus", seckillStatus);
        model.addAttribute("remainSeconds", remainSeconds);

        return "goods/detail";
    }
}
