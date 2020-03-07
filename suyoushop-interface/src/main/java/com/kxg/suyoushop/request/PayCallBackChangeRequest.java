package com.kxg.suyoushop.request;

import lombok.Data;

import java.io.Serializable;
@Data
public class PayCallBackChangeRequest implements Serializable {
    private Long orderId;
    private Short status;
    private String payCode;
}
