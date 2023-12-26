package com.mk.system.service;

import com.mk.system.pojo.Departments;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mk.system.utils.Result;

/**
* @author mao
* @description 针对表【tbdepartments】的数据库操作Service
* @createDate 2023-12-21 13:31:32
*/
public interface DepartmentsService extends IService<Departments> {

    Result add(Departments departments);

    Result findAll();

    Result deleteById(String departmentId);

}
