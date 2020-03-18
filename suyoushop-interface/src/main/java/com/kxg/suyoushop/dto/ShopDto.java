package com.kxg.suyoushop.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ShopDto implements Serializable {

    private Long id;


    private String phoneNumber;

    private String password;


    private String imgUrl;

    private Short status;


    private Date createTime;


    private Date updateTime;

    private String name;
}
