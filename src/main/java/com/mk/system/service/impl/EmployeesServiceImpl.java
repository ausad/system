package com.mk.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mk.system.pojo.Departments;
import com.mk.system.pojo.Employees;
import com.mk.system.service.EmployeesService;
import com.mk.system.mapper.EmployeesMapper;
import com.mk.system.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author mao
* @description 针对表【tbemployees】的数据库操作Service实现
* @createDate 2023-12-21 13:31:32
*/
@Service
public class EmployeesServiceImpl extends ServiceImpl<EmployeesMapper, Employees>
    implements EmployeesService{

    @Autowired
    private EmployeesMapper employeesMapper;

    public Result findAll() {
        List<Employees> departments = employeesMapper.selectList(null);
        return Result.ok(departments);
    }

    @Override
    public Result add(Employees employees) {
        int insert = employeesMapper.insert(employees);
        if (insert>0){
            return Result.ok(null);
        }
        return Result.build(null, 506,"员工添加失败");
    }

    @Override
    public Result deleteById(String employeeId) {
        int i = employeesMapper.deleteById(employeeId);
        if (i>0){
            return Result.ok(null);
        }
        return Result.build(null,507,"删除员工失败");
    }
}




