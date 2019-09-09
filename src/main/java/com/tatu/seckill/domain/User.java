package com.tatu.seckill.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {
    private Long id;
    private String nickname;
    private String password;
    private String avatarUrl;
    private String salt;
    private Date registerDate;
    private Date lastLoginDate;
}
