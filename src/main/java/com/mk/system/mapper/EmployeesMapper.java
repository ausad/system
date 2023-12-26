package com.mk.system.mapper;

import com.mk.system.pojo.Employees;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author mao
* @description 针对表【tbemployees】的数据库操作Mapper
* @createDate 2023-12-21 13:31:32
* @Entity com.mk.system.pojo.Employees
*/
public interface EmployeesMapper extends BaseMapper<Employees> {

    void deleteByDeptId(String departmentId);

    void deleteByJobId(String jobId);
}




