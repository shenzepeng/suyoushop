package com.kxg.suyoushop.consumer.request;

import lombok.Data;

@Data
public class UserLoginBySmsRequest {
    private String phoneNumber;
    private String code;
}
