package com.kxg.suyoushop.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class FindCarByUserIdRequest implements Serializable {
    private Long id;
    private Integer pageSize;
    private Integer pageNumber;
}
