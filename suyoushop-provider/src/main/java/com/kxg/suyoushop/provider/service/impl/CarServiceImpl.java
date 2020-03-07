package com.kxg.suyoushop.provider.service.impl;

import com.kxg.suyoushop.provider.dto.FindCarByUserIdDto;
import com.kxg.suyoushop.provider.pojo.Cars;
import com.kxg.suyoushop.provider.service.CarService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarServiceImpl implements CarService {

    @Override
    public Integer addCar(Cars cars) {
        return null;
    }

    @Override
    public Integer updateCater(Cars cars) {
        return null;
    }

    @Override
    public Integer deleteGood(Long id) {
        return null;
    }

    @Override
    public FindCarByUserIdDto findGoodsById(Long id, Integer pageSize, Integer pageNumber) {
        //1.分页
        //2.查询
        //3.返回结果
        return null;
    }
}
