package com.kxg.suyoushop.consumer.hander;

public interface CheckHandler {
     Boolean checkSsoToken(String token);
     Boolean checkPayToken(String token,Long orderId);
}
