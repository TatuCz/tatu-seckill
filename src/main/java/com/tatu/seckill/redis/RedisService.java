package com.tatu.seckill.redis;

import com.tatu.seckill.redis.prefix.KeyPrefix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }

    public void set(KeyPrefix keyPrefix, String key, Object value) {
        String realKey = keyPrefix.getKeyPrefix() + key;
        System.out.println("realKey:" + realKey);
        redisTemplate.opsForValue().set(realKey, value);
    }

    public void set(KeyPrefix keyPrefix, String key, Object value, long expireTime, TimeUnit timeUnit) {
        String realKey = keyPrefix.getKeyPrefix() + key;
        redisTemplate.opsForValue().set(realKey, value, expireTime, timeUnit);
    }

    public Object get(KeyPrefix keyPrefix, String key) {
        String realKey = keyPrefix.getKeyPrefix() + key;
        return redisTemplate.opsForValue().get(realKey);
    }

    public boolean exists(KeyPrefix keyPrefix, String key) {
        String realKey = keyPrefix.getKeyPrefix() + key;
        return redisTemplate.hasKey(realKey);
    }

    public Long incr(KeyPrefix keyPrefix, String key) {
        String realKey = keyPrefix.getKeyPrefix() + key;
        return redisTemplate.opsForValue().increment(realKey);
    }

    public Long decr(KeyPrefix keyPrefix, String key) {
        String realKey = keyPrefix.getKeyPrefix() + key;
        return redisTemplate.opsForValue().decrement(realKey);
    }


}
