package com.kxg.suyoushop.provider.dubboservice;

import com.kxg.suyoushop.constant.SuYouShopConstants;
import com.kxg.suyoushop.provider.es.domain.GoodsEsPojo;
import com.kxg.suyoushop.provider.pojo.Goods;
import com.kxg.suyoushop.provider.service.GoodsService;
import com.kxg.suyoushop.provider.utils.JsonUtils;
import com.kxg.suyoushop.request.AddGoodsRequest;
import com.kxg.suyoushop.request.ShopLoginRequest;
import com.kxg.suyoushop.response.AddGoodsResponse;
import com.kxg.suyoushop.response.ShopLoginResponse;
import com.kxg.suyoushop.service.ShopDubboService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.Date;
import java.util.concurrent.ExecutionException;

@Slf4j
@Service(version = "1.0.0")
public class ShopDubboServiceImpl implements ShopDubboService {
    @Autowired
    private GoodsService goodsService;
    @Override
    public ShopLoginResponse login(ShopLoginRequest request) {
        return null;
    }
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public AddGoodsResponse addGoods(AddGoodsRequest request) {
        AddGoodsResponse addGoodsResponse=new AddGoodsResponse();
        Short end=null;
        GoodsEsPojo esPojo=new GoodsEsPojo();
        BeanUtils.copyProperties(request,esPojo);
        esPojo.setUpdateTime(new Date());
        esPojo.setCreateTime(new Date());
        //向消息中间间丢消息
        String result = null;
        try {
            result = sent("add_goods", JsonUtils.objectToJson(esPojo));
        } catch (Exception e) {
            log.info("商品落入kafka中出现了异常-{}",e.getMessage());
            end=SuYouShopConstants.ADD_GOODS_FAIL;
            addGoodsResponse.setEnd(end);
            return addGoodsResponse;
        }

        if ("OK".equals(result)){
            end=SuYouShopConstants.ADD_GOODS_SUCCESSFUL;
        }else {
            end=SuYouShopConstants.ADD_GOODS_FAIL;
        }
        addGoodsResponse.setEnd(end);
        return addGoodsResponse;
    }
    public String sent(String topic,String msg) throws ExecutionException, InterruptedException {
        ListenableFuture<SendResult<String, String>> send = kafkaTemplate.send(topic, msg);
        SendResult<String, String> stringStringSendResult = send.get();
        log.info("stringStringSendResult",stringStringSendResult);
        return "OK";
    }
}
