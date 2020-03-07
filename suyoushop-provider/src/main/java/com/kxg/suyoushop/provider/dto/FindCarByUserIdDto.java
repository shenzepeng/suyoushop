package com.kxg.suyoushop.provider.dto;

import com.kxg.suyoushop.provider.pojo.Cars;
import lombok.Data;

import java.util.List;
@Data
public class FindCarByUserIdDto {
    private List<Cars> carsList;
    private Long total;
}
