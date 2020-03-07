package com.kxg.suyoushop.provider.service;

import com.kxg.suyoushop.provider.dto.FindCarByUserIdDto;
import com.kxg.suyoushop.provider.pojo.Cars;

import java.util.List;

public interface CarService {
    Integer addCar(Cars cars);
    Integer updateCater(Cars cars);
    Integer deleteGood(Long id);
    FindCarByUserIdDto findGoodsById(Long id, Integer pageSize, Integer pageNumber);
}
