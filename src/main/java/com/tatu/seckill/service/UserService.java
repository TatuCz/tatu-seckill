package com.tatu.seckill.service;

import com.tatu.seckill.dao.UserMapper;
import com.tatu.seckill.domain.User;
import com.tatu.seckill.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisService redisService;

    public User getById(int id) {
        return userMapper.getById(id);
    }
}
