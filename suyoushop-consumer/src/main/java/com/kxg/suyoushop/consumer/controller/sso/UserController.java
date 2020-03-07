package com.kxg.suyoushop.consumer.controller.sso;

import com.kxg.suyoushop.common.SzpJsonResult;
import com.kxg.suyoushop.consumer.request.UserLoginBySmsRequest;
import com.kxg.suyoushop.consumer.request.UserLoginRequest;
import com.kxg.suyoushop.consumer.response.UserLoginReponse;
import com.kxg.suyoushop.dto.UserDto;
import com.kxg.suyoushop.request.LoginUserRequest;
import com.kxg.suyoushop.response.LoginUserResponse;
import com.kxg.suyoushop.service.UserDubboService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Reference(version = "1.0.0")
    private UserDubboService userDubboService;
    @PostMapping("login")
    public SzpJsonResult<UserLoginReponse> userLogin(@RequestBody @Validated UserLoginRequest request){

        LoginUserRequest loginUserRequest=new LoginUserRequest();
        loginUserRequest.setPhoneNumber(request.getPhoneNumber());
        loginUserRequest.setPassword(request.getPassword());
        LoginUserResponse login = userDubboService.login(loginUserRequest);
        UserLoginReponse reponse=new UserLoginReponse();
        UserDto userDto = login.getUserDto();
        BeanUtils.copyProperties(userDto,reponse);
        reponse.setToken(login.getToken());
        reponse.setMsg(login.getMsg());
        return SzpJsonResult.ok(reponse);
    }
}
