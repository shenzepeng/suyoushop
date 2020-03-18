package com.kxg.suyoushop.provider.es.domain;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;
@Data
@Document(indexName = "travel_index",type = "docs")
public class GoodsEsPojo {
    @Id
    private Long id;

    @Field(type = FieldType.Double)
    private Long shopId;
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String name;
    @Field(type = FieldType.Double)
    private Double price;

    @Field(type = FieldType.Double)
    private String goodImg;

    @Field(type = FieldType.Double)
    private Long existNumber;

    @Field(type = FieldType.Double)
    private Date createTime;

    @Field(type = FieldType.Double)
    private Date updateTime;
    @Field(type = FieldType.Double)
    private Short status;
}
