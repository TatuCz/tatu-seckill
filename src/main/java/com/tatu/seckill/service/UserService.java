package com.tatu.seckill.service;

import com.tatu.seckill.dao.UserMapper;
import com.tatu.seckill.domain.User;
import com.tatu.seckill.redis.RedisService;
import com.tatu.seckill.response.ErrorCodeMsg;
import com.tatu.seckill.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisService redisService;

    public User getById(int id) {
        return userMapper.getById(id);
    }

    public boolean addUser(String nickname, String password) {
        User user = new User();
        user.setNickname(nickname);
        String salt = MD5Util.getRandomSalt();
        user.setSalt(salt);
        user.setPassword(MD5Util.md5(password, salt));
        user.setRegisterDate(new Date());
        return userMapper.insert(user) > 0;
    }

    public ErrorCodeMsg login(String nickname, String password) {
        User user = userMapper.getByNickname(nickname);
        if (user != null) {
            String encryptedPwd = MD5Util.md5(password, user.getSalt());
            if (encryptedPwd.equals(user.getPassword())) {
                return null;
            }
            return ErrorCodeMsg.PASSWORD_NOT_MATCH;
        }

        return ErrorCodeMsg.USER_NOT_FOUNT;
    }
}
