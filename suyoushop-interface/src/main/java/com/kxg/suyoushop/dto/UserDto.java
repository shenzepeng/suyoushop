package com.kxg.suyoushop.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserDto implements Serializable {

    private Integer id;

    private Integer age;


    private Date createTime;


    private Date endTime;


    private String imgUrl;

    private Short mark;


    private String nickName;

    private String password;


    private Long phoneNumber;

    private Short sex;


    private Short vip;
}
