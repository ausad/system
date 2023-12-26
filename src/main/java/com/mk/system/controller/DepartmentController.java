package com.mk.system.controller;


import com.mk.system.pojo.Departments;
import com.mk.system.service.DepartmentsService;
import com.mk.system.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("department")
public class DepartmentController {
    @Autowired
    private DepartmentsService departmentsService;

    @PostMapping("add")
    public Result addDepartment(@RequestBody Departments departments){
        Result result = departmentsService.add(departments);
        return result;
    }

    @GetMapping("deleteById")
    public Result deleteById(String departmentId){
        Result result = departmentsService.deleteById(departmentId);
        return result;
    }

    @PostMapping("updateById")
    public Result updateById(@RequestBody Departments departments){
        boolean d = departmentsService.updateById(departments);
        if (d){
            return Result.ok(null);
        }
        return Result.build(null,600,"修改失败");
    }

    @GetMapping("find")
    public Result findAll(){
        Result result = departmentsService.findAll();
        return result;
    }

}
