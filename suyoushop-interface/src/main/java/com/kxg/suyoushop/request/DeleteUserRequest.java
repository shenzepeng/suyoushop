package com.kxg.suyoushop.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class DeleteUserRequest implements Serializable {
    private Long id;
}
