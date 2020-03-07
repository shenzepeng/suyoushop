package com.kxg.suyoushop.consumer.controller.car;
import com.kxg.suyoushop.constant.SuYouShopConstants;
import com.kxg.suyoushop.common.SzpJsonResult;
import com.kxg.suyoushop.consumer.hander.CheckHandler;
import com.kxg.suyoushop.request.AddGoodsToCarRequest;
import com.kxg.suyoushop.request.CarRequest;
import com.kxg.suyoushop.response.AddGoodsToCarResponse;
import com.kxg.suyoushop.response.UpdateCarResponse;
import com.kxg.suyoushop.service.CarDubboService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("car")
public class CarController {
    @Reference(version = "1.0.0")
    private CarDubboService service;
    @Autowired
    private CheckHandler checkHandler;
    /**
     * 修改购物车中的信息
     */
    //1.添加购物车
    @PostMapping("add")
    public SzpJsonResult<AddGoodsToCarResponse> addCar(@RequestHeader("token")String token, @RequestBody @Validated AddGoodsToCarRequest request){
        if (checkHandler.checkSsoToken(token)){
            AddGoodsToCarResponse addGoodsToCarResponse = service.addCar(request);
            return SzpJsonResult.ok(addGoodsToCarResponse);
        }
        return SzpJsonResult.errorTokenMsg(SuYouShopConstants.TOKEN_IS_NOT_RIGHT);
    }
    //2.更新购物车
    public SzpJsonResult<UpdateCarResponse> updateCar(@RequestHeader("token")String token,@RequestBody @Validated CarRequest request){
        if (checkHandler.checkSsoToken(token)) {
            return SzpJsonResult.ok(service.updateCater(request));
        }
        return SzpJsonResult.errorTokenMsg(SuYouShopConstants.TOKEN_IS_NOT_RIGHT);
    }
    //3.删除购物车中的内容


}
