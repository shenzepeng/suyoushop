package com.kxg.suyoushop.provider.dubboservice;

import com.kxg.suyoushop.UserDubboService;
import com.kxg.suyoushop.dto.UserDto;
import com.kxg.suyoushop.provider.pojo.User;
import com.kxg.suyoushop.provider.service.UserService;
import com.kxg.suyoushop.request.DeleteUserRequest;
import com.kxg.suyoushop.request.LoginUserBySmsRequest;
import com.kxg.suyoushop.request.LoginUserRequest;
import com.kxg.suyoushop.request.UpdateUserRequest;
import com.kxg.suyoushop.response.DeleteUserResponse;
import com.kxg.suyoushop.response.LoginUserResponse;
import com.kxg.suyoushop.response.UpdateUserResponse;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;
@Service(version = "1.0.0")
public class UserDubboServiceImpl implements UserDubboService {
    @Autowired
    private UserService userService;
    @Override
    public LoginUserResponse login(LoginUserRequest request) {
        LoginUserResponse response=new LoginUserResponse();
        List<User> login = userService.login(request.getPhoneNumber(), request.getPassword());
        if (!CollectionUtils.isEmpty(login)){
            UserDto userDto=new UserDto();
            User user = login.get(0);
            BeanUtils.copyProperties(user,userDto);
            response.setUserDto(userDto);
            return response;
        }
        return response;
    }

    @Override
    public LoginUserResponse loginBySms(LoginUserBySmsRequest request) {
        LoginUserResponse response=new LoginUserResponse();
        String code = request.getCode();
        String phoneNumber = request.getPhoneNumber();
        //1.调用短信接口  传入手机号和短息验证码
        String checkReuslt = checkPhoneAndCode(code, phoneNumber);
        if (!"00".equals(checkReuslt)){
            response.setMsg("短信验证失败");
            return response;
        }
        //2.验证通过
        //3.查看当前数据库是否有这个手机的记录
        List<User> userByPhone = userService.findUserByPhone(phoneNumber);
        //4.无记录，生成新的用户，返还
        if (CollectionUtils.isEmpty(userByPhone)){
            User user=new User();
            //构造user的信息
            userService.addNewUser(user);
            UserDto userDto=new UserDto();
            BeanUtils.copyProperties(user,userDto);
            response.setUserDto(userDto);
            //生成token，放入redis，返还前端
            return response;
        }
        //5。有记录拿到该记录，返还
        User user = userByPhone.get(0);
        UserDto userDto=new UserDto();
        BeanUtils.copyProperties(user,userDto);
        response.setUserDto(userDto);
        //生成token，放入redis，返还前端
        return response;
    }

    @Override
    public UpdateUserResponse updateUserInfo(UpdateUserRequest user) {
        return null;
    }

    @Override
    public DeleteUserResponse deleteUser(DeleteUserRequest request) {
        return null;
    }

    private String checkPhoneAndCode(String code,String phoneNumber){
        return "00";
    }

}
