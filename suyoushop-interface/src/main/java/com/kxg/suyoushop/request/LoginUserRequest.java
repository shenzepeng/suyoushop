package com.kxg.suyoushop.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginUserRequest implements Serializable {
    private String phoneNumber;
    private String password;
}
