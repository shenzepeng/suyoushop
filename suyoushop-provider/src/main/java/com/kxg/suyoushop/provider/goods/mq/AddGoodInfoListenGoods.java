package com.kxg.suyoushop.provider.goods.mq;

import com.kxg.suyoushop.provider.es.domain.GoodsEsPojo;
import com.kxg.suyoushop.provider.goods.serivce.GoodsService;
import com.kxg.suyoushop.provider.pojo.Goods;
import com.kxg.suyoushop.provider.utils.JsonUtils;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class AddGoodInfoListenGoods {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private AddEsGoodsSent addEsGoodsSent;
    @KafkaListener(topics = "add_goods")
    public void listen(ConsumerRecord<?, ?> record) throws Exception {
        //控制台打印send进来的信息
        String value = record.value().toString();
        GoodsEsPojo goodsEsPojo = JsonUtils.jsonToPojo(value, GoodsEsPojo.class);
        Goods goods=new Goods();
        BeanUtils.copyProperties(goodsEsPojo,goods);
        goods.setCreateTime(new Date());
        goods.setUpdateTime(new Date());
        goodsService.addGoods(goods);

        addEsGoodsSent.sent("add_es_goods",JsonUtils.objectToJson(goods));
    }
}
