package com.kxg.suyoushop.provider.es.mq;

import com.kxg.suyoushop.provider.es.dao.CreateIndex;
import com.kxg.suyoushop.provider.es.dao.GoodsEsPojoRepository;
import com.kxg.suyoushop.provider.es.domain.GoodsEsPojo;
import com.kxg.suyoushop.provider.utils.JsonUtils;
import lombok.Data;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class AddGoodInfoListenES {
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    @Autowired
    private GoodsEsPojoRepository repository;
    @Autowired
    private CreateIndex createIndex;

    @KafkaListener(topics = "add_es_goods")
    public void listen(ConsumerRecord<?, ?> record) throws Exception {
        //控制台打印send进来的信息
        String value = record.value().toString();
        GoodsEsPojo goodsEsPojo = JsonUtils.jsonToPojo(value, GoodsEsPojo.class);
        //1.有没有相应的库（也就是索引），没有库的话，需要映射一下
        if (!createIndex.getIndexExist(goodsEsPojo)) {
            //创建索引
            createIndex.createIndex(goodsEsPojo);
            //映射
            createIndex.putMapping(goodsEsPojo);
        }
        //2.添加数据
        repository.save(goodsEsPojo);
    }
}
