package com.tatu.seckill.dao;

import com.tatu.seckill.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("SELECT id,nickname,avatar_url,register_date,last_login_date FROM user WHERE id=#{id}")
    User getById(int id);

    @Select("SELECT id,nickname,password,salt,avatar_url,register_date,last_login_date FROM user WHERE nickname=#{nickname}")
    User getByNickname(String nickname);

    @Insert("INSERT INTO user(nickname, password, avatar_url, salt, register_date) VALUES(#{nickname}, #{password}, #{avatarUrl}, #{salt}, #{registerDate})")
    int insert(User user);
}
