package com.tatu.seckill.redis.prefix;

/**
 * 构造前缀字符串，格式:"业务类名.业务定义的KeyPrefix"
 */
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
