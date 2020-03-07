package com.kxg.suyoushop.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 添加购物车的request
 */
@Data
public class AddGoodsToCarRequest implements Serializable {
    @NotNull
    private Long userId;
    @NotNull
    private Long goodsId;

    @NotNull
    private Long shopId;

    @NotEmpty(message = "商品名称不能缺少")
    private String goodName;
    @NotNull
    private Long numbers;
    @NotNull
    private Double totalPrice;
}
