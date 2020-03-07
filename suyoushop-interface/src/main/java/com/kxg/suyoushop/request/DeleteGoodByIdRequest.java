package com.kxg.suyoushop.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class DeleteGoodByIdRequest implements Serializable {
    private Long goodId;
}
