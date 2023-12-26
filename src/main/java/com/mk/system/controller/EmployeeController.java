package com.mk.system.controller;


import com.mk.system.pojo.Departments;
import com.mk.system.pojo.Employees;
import com.mk.system.service.DepartmentsService;
import com.mk.system.service.EmployeesService;
import com.mk.system.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private EmployeesService employeesService;

    @PostMapping("add")
    public Result addDepartment(@RequestBody Employees employees){
        Result result = employeesService.add(employees);
        return result;
    }

    @GetMapping("deleteById")
    public Result deleteById(String employeeId){
        Result result = employeesService.deleteById(employeeId);
        return result;
    }

    @PostMapping("updateById")
    public Result updateById(@RequestBody Employees employees){
        boolean d = employeesService.updateById(employees);
        if (d){
            return Result.ok(null);
        }
        return Result.build(null,600,"修改失败");
    }

    @GetMapping("find")
    public Result findAll(){
        Result result = employeesService.findAll();
        return result;
    }

}
