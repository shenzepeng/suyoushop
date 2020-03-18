package com.kxg.suyoushop.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class AddGoodsRequest implements Serializable {

    private Long shopId;

    private String name;

    private Double price;

    private String goodImg;

    private Long existNumber;

}
