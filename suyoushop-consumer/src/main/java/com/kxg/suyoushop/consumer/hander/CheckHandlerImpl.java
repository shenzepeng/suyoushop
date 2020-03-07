package com.kxg.suyoushop.consumer.hander;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class CheckHandlerImpl implements CheckHandler {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public Boolean checkSsoToken(String token) {
        if (StringUtils.isEmpty(token)){
            return false;
        }
        String tokenValue = stringRedisTemplate.opsForValue().get(token);
        if (StringUtils.isEmpty(tokenValue)){
            return false;
        }
        return true;
    }

    @Override
    public Boolean checkPayToken(String token,Long orderId) {
        if (StringUtils.isEmpty(token)||orderId==null){
            return false;
        }
        String tokenValue = stringRedisTemplate.opsForValue().get(token);
        if (StringUtils.isEmpty(tokenValue)){
            return false;
        }
        //通过校验
        if (tokenValue.equals(orderId.toString())){
            return true;
        }
        return false;
    }
}
