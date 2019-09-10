package com.tatu.seckill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.tatu.seckill.dao")
@SpringBootApplication
public class TatuSeckillApplication {

    public static void main(String[] args) {
        SpringApplication.run(TatuSeckillApplication.class, args);
    }

}
