package com.kxg.suyoushop.response;

import com.kxg.suyoushop.dto.ShopDto;
import lombok.Data;

import java.io.Serializable;

@Data
public class ShopLoginResponse extends ShopDto implements Serializable {
    private String token;
}
