package com.kxg.suyoushop.provider.es.dao;

import com.kxg.suyoushop.provider.es.domain.GoodsEsPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CreateIndex {
    @Autowired
    private ElasticsearchTemplate template;

    //创建索引
    public Boolean createIndex(Object object){
       return template.createIndex(object.getClass());
    }
    //映射
    public Boolean putMapping(Object object){
        return template.putMapping(object.getClass());
    }
    //删除
    public Boolean deleteIndex(Object object){
        return template.deleteIndex(object.getClass());
    }
    //判断索引已经存在
    public Boolean getIndexExist(Object object){
        return template.indexExists(object.getClass());
    }
}
