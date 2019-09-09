package com.tatu.seckill.redis.prefix;

/**
 * User模块的key前缀
 */
public class UserKey extends BaseKeyPrefix {

    public UserKey(String keyPrefix) {
        super(keyPrefix);
    }

    public static UserKey GET_BY_ID = new UserKey("id"); //前缀:UserKey.id
    public static UserKey GET_BY_USERNAME = new UserKey("uname"); //前缀:UserKey.uname
}
