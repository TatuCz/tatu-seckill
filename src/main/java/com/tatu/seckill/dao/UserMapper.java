package com.tatu.seckill.dao;

import com.tatu.seckill.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("SELECT id,username FROM user WHERE id=#{id}")
    User getById(int id);

    @Insert("INSERT INTO user(username) VALUES(#{username})")
    int insert(String username);
}
