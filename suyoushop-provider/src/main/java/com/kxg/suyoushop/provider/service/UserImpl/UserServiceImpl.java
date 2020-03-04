package com.kxg.suyoushop.provider.service.UserImpl;

import com.kxg.suyoushop.provider.pojo.User;
import com.kxg.suyoushop.provider.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<User> login(String phoneNumber, String password) {
        return null;
    }

    @Override
    public List<User> loginBySms(String phoneNumber, String code) {
        return null;
    }

    @Override
    public Integer updateUserInfo(User user) {
        return null;
    }

    @Override
    public Integer deleteUser(Long id) {
        return null;
    }

    @Override
    public List<User> findUserByPhone(String phoneNumber) {
        return null;
    }

    @Override
    public Integer addNewUser(User user) {
        return null;
    }
}
