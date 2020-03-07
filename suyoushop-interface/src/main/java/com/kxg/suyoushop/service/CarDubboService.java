package com.kxg.suyoushop.service;

import com.kxg.suyoushop.request.AddGoodsToCarRequest;
import com.kxg.suyoushop.request.CarRequest;
import com.kxg.suyoushop.request.DeleteGoodByIdRequest;
import com.kxg.suyoushop.request.FindCarByUserIdRequest;
import com.kxg.suyoushop.response.AddGoodsToCarResponse;
import com.kxg.suyoushop.response.DeleteGoodResponse;
import com.kxg.suyoushop.response.FindCarByUserIdResponse;
import com.kxg.suyoushop.response.UpdateCarResponse;

public interface CarDubboService {
    AddGoodsToCarResponse addCar(AddGoodsToCarRequest request);
    UpdateCarResponse updateCater(CarRequest cars);
    DeleteGoodResponse deleteGood(DeleteGoodByIdRequest id);
    FindCarByUserIdResponse findGoodsById(FindCarByUserIdRequest request);
}
