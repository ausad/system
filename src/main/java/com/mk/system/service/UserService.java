package com.mk.system.service;

import com.mk.system.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mk.system.utils.Result;

/**
* @author mao
* @description 针对表【tbusers】的数据库操作Service
* @createDate 2023-12-21 13:31:32
*/
public interface UserService extends IService<User> {

    Result login(User user);

    Result getUserInfo(String token);

    Result register(User user);

    Result checkUserName(String username);
}
