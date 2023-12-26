package com.mk.system.controller;


import com.mk.system.pojo.Departments;
import com.mk.system.pojo.Jobs;
import com.mk.system.service.JobsService;
import com.mk.system.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("job")
public class JobController {
    @Autowired
    private JobsService jobsService;

    @PostMapping("add")
    public Result addDepartment(@RequestBody Jobs jobs){
        Result result = jobsService.add(jobs);
        return result;
    }

    @GetMapping("deleteById")
    public Result deleteById(String jobId){
        Result result = jobsService.deleteById(jobId);
        return result;
    }

    @PostMapping("updateById")
    public Result updateById(@RequestBody Jobs jobs){
        boolean d = jobsService.updateById(jobs);
        if (d){
            return Result.ok(null);
        }
        return Result.build(null,600,"修改失败");
    }

    @GetMapping("find")
    public Result findAll(){
        Result result = jobsService.findAll();
        return result;
    }

}
