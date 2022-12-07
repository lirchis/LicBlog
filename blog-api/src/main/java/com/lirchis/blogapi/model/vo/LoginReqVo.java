package com.lirchis.blogapi.model.vo;

import lombok.Data;

import java.io.Serializable;


@Data
public class LoginReqVo implements Serializable {
    private String username;
    private String password;
}
