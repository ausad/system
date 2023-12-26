package com.mk.system.service;

import com.mk.system.pojo.Jobs;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mk.system.utils.Result;

/**
* @author mao
* @description 针对表【tbjobs】的数据库操作Service
* @createDate 2023-12-21 13:31:32
*/
public interface JobsService extends IService<Jobs> {

    Result findAll();

    Result add(Jobs jobs);

    Result deleteById(String jobId);
}
