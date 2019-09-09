package com.tatu.seckill.redis.prefix;

public class UserKey extends BaseKeyPrefix {

    public UserKey(String keyPrefix) {
        super(keyPrefix);
    }

    public static UserKey GET_BY_ID = new UserKey("id");
    public static UserKey GET_BY_USERNAME = new UserKey("uname");
}
