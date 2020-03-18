package com.kxg.suyoushop.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class GoodsDto implements Serializable {

    private Long id;

    private Long shopId;

    private String name;

    private Double price;


    private String goodImg;


    private Long existNumber;


    private Date createTime;


    private Date updateTime;

    private Short status;
}
