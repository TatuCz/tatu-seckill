package com.tatu.seckill.redis.prefix;

public abstract class BaseKeyPrefix implements KeyPrefix {

    private String keyPrefix;

    public BaseKeyPrefix(String keyPrefix) {
        this.keyPrefix = keyPrefix;
    }

    @Override
    public String getKeyPrefix() {
        String className = this.getClass().getSimpleName();
        return className + "." + keyPrefix;
    }
}
