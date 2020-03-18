package com.kxg.suyoushop.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
@Data
public class ShopLoginRequest implements Serializable {
    @NotEmpty
    private String phoneNumber;
    @NotEmpty
    private String password;
}
