package com.kxg.suyoushop;

import com.kxg.suyoushop.request.DeleteUserRequest;
import com.kxg.suyoushop.request.LoginUserBySmsRequest;
import com.kxg.suyoushop.request.LoginUserRequest;
import com.kxg.suyoushop.request.UpdateUserRequest;
import com.kxg.suyoushop.response.DeleteUserResponse;
import com.kxg.suyoushop.response.LoginUserResponse;
import com.kxg.suyoushop.response.UpdateUserResponse;

import java.util.List;

public interface UserDubboService {
    LoginUserResponse login(LoginUserRequest request);
    LoginUserResponse loginBySms(LoginUserBySmsRequest loginUserBySmsRequest);
    UpdateUserResponse updateUserInfo(UpdateUserRequest user);
    DeleteUserResponse deleteUser(DeleteUserRequest request);
}
