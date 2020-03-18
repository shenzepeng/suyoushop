package com.kxg.suyoushop.provider.goods.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class AddEsGoodsSent {
    @Autowired
    private KafkaTemplate<String,String> template;

    public void sent(String top,String msg){
        template.send(top, msg);
    }
}
