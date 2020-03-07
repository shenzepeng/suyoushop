package com.kxg.suyoushop.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class AddNewOrderRequest implements Serializable {

    private Long carId;

    private Double totalPriece;


    private Long userId;


    private Long shopId;

}
