package com.kxg.suyoushop.provider.service;

import com.kxg.suyoushop.provider.pojo.User;

import java.util.List;

public interface UserService {
    List<User> login(String phoneNumber, String password);
    List<User> loginBySms(String phoneNumber,String code);
    Integer updateUserInfo(User user);
    Integer deleteUser(Long id);
    List<User> findUserByPhone(String phoneNumber);
    Integer addNewUser(User user);
}
