package com.kxg.suyoushop.consumer.controller.sso;

import com.kxg.suyoushop.common.SzpJsonResult;
import com.kxg.suyoushop.constant.SuYouShopConstants;
import com.kxg.suyoushop.consumer.hander.CheckHandler;
import com.kxg.suyoushop.request.AddGoodsRequest;
import com.kxg.suyoushop.request.ShopLoginRequest;
import com.kxg.suyoushop.response.AddGoodsResponse;
import com.kxg.suyoushop.response.ShopLoginResponse;
import com.kxg.suyoushop.service.ShopDubboService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("shop")
public class ShopController {
    @Autowired
    private CheckHandler checkHandler;
    @Reference(version = "1.0.0")
    private ShopDubboService shopDubboService;
    @PostMapping("login")
    public SzpJsonResult<ShopLoginResponse> shopLogin(@Validated  @RequestBody ShopLoginRequest request){
        return SzpJsonResult.ok(shopDubboService.login(request));
    }
    @PostMapping("add/goods")
    public SzpJsonResult<AddGoodsResponse> addGoods(@RequestHeader("token")String token, @RequestBody AddGoodsRequest request){
        if (checkHandler.checkSsoToken(token)){
             return SzpJsonResult.ok(shopDubboService.addGoods(request));
        }
        return SzpJsonResult.errorMsg(SuYouShopConstants.TOKEN_IS_NOT_RIGHT);
    }
}
