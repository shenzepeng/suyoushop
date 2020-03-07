package com.kxg.suyoushop.consumer.request;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Data
public class UserLoginRequest {
    @NotEmpty
    private String password;
    @NotEmpty
    private String phoneNumber;
    @NotNull
    private Integer age;

    @Valid
    private ArrayList<Integer> list;
}
