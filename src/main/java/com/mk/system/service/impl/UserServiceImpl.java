package com.mk.system.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mk.system.pojo.User;
import com.mk.system.service.UserService;
import com.mk.system.mapper.UserMapper;
import com.mk.system.utils.JwtHelper;
import com.mk.system.utils.MD5Util;
import com.mk.system.utils.Result;
import com.mk.system.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
* @author mao
* @description 针对表【tbusers】的数据库操作Service实现
* @createDate 2023-12-21 13:31:32
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtHelper jwtHelper;

    @Override
    public Result login(User user) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUsername,user.getUsername());
        User loginUser = userMapper.selectOne(lambdaQueryWrapper);

        if (loginUser==null){
            return Result.build(null, ResultCodeEnum.USERNAME_ERROR);
        }

        if (!StringUtils.isEmpty(user.getPassword())
                && MD5Util.encrypt(user.getPassword()).equals(loginUser.getPassword())){
            String token = jwtHelper.createToken(Long.valueOf(loginUser.getUserId()));
            Map data = new HashMap();
            data.put("user",loginUser);
            data.put("token",token);
            return Result.ok(data);
        }

        return Result.build(null,ResultCodeEnum.PASSWORD_ERROR);
    }

    @Override
    public Result getUserInfo(String token) {
        boolean expiration = jwtHelper.isExpiration(token);
        if (expiration){
            return Result.build(null,ResultCodeEnum.NOTLOGIN);
        }
        int userId = jwtHelper.getUserId(token).intValue();
        User user = userMapper.selectById(userId);
        user.setPassword("");
        Map data = new HashMap();
        data.put("loginUser",user);
        return Result.ok(data);
    }

    @Override
    public Result register(User user) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUsername,user.getUsername());
        Long count = userMapper.selectCount(lambdaQueryWrapper);
        if (count>0){
            return Result.build(null,ResultCodeEnum.USERNAME_USED);
        }
        user.setPassword(MD5Util.encrypt(user.getPassword()));
        userMapper.insert(user);
        return Result.ok(null);
    }

    @Override
    public Result checkUserName(String username) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUsername,username);
        Long count = userMapper.selectCount(lambdaQueryWrapper);
        if (count==0){
            return Result.ok(null);
        }
        return Result.build(null,ResultCodeEnum.USERNAME_USED);
    }
}




