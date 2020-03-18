package com.kxg.suyoushop.service;

import com.kxg.suyoushop.request.AddGoodsRequest;
import com.kxg.suyoushop.request.ShopLoginRequest;
import com.kxg.suyoushop.response.AddGoodsResponse;
import com.kxg.suyoushop.response.ShopLoginResponse;

public interface ShopDubboService {
   ShopLoginResponse login(ShopLoginRequest request);
   AddGoodsResponse addGoods(AddGoodsRequest request);
}
