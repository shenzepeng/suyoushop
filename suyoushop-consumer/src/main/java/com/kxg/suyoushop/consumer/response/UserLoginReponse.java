package com.kxg.suyoushop.consumer.response;

import lombok.Data;

import java.util.Date;

@Data
public class UserLoginReponse {
    private Long id;


    private String phoneNumber;

    private String password;


    private String imgUrl;


    private Date createTime;


    private Date updateTime;


    private String nickName;


    private Double existMoney;

    private String token;

    private String msg;
}
