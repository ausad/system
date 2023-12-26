package com.mk.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mk.system.mapper.EmployeesMapper;
import com.mk.system.pojo.Departments;
import com.mk.system.service.DepartmentsService;
import com.mk.system.mapper.DepartmentsMapper;
import com.mk.system.service.EmployeesService;
import com.mk.system.utils.Result;
import com.mk.system.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author mao
* @description 针对表【tbdepartments】的数据库操作Service实现
* @createDate 2023-12-21 13:31:32
*/
@Service
public class DepartmentsServiceImpl extends ServiceImpl<DepartmentsMapper, Departments>
    implements DepartmentsService{
    @Autowired
    private DepartmentsMapper departmentsMapper;
    @Autowired
    private EmployeesMapper employeesMapper;

    @Override
    public Result add(Departments departments) {
        int insert = departmentsMapper.insert(departments);
        if (insert>0){
            return Result.ok(null);
        }
        return Result.build(null, 506,"部门添加失败");
    }

    @Override
    public Result findAll() {
        List<Departments> departments = departmentsMapper.selectList(null);
        return Result.ok(departments);
    }

    @Override
    public Result deleteById(String departmentId) {
        int i = departmentsMapper.deleteById(departmentId);
        if (i>0){
            employeesMapper.deleteByDeptId(departmentId);
            return Result.ok(null);
        }
        return Result.build(null,507,"删除部门失败");
    }

}




