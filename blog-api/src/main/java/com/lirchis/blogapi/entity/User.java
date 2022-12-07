package com.lirchis.blogapi.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private String nickname;
    private String avatar;
    private String email;
    private Date createTime;
    private Date updateTime;
    private String role;
}
