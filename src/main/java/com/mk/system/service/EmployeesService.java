package com.mk.system.service;

import com.mk.system.pojo.Employees;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mk.system.utils.Result;

/**
* @author mao
* @description 针对表【tbemployees】的数据库操作Service
* @createDate 2023-12-21 13:31:32
*/
public interface EmployeesService extends IService<Employees> {

    Result findAll();

    Result add(Employees employees);

    Result deleteById(String employeeId);
}
