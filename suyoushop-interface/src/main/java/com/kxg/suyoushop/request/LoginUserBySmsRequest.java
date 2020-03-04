package com.kxg.suyoushop.request;

import lombok.Data;

@Data
public class LoginUserBySmsRequest {
    private String phoneNumber;
    private String code;
}
