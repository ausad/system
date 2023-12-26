package com.mk.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mk.system.mapper.EmployeesMapper;
import com.mk.system.pojo.Departments;
import com.mk.system.pojo.Jobs;
import com.mk.system.service.JobsService;
import com.mk.system.mapper.JobsMapper;
import com.mk.system.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author mao
* @description 针对表【tbjobs】的数据库操作Service实现
* @createDate 2023-12-21 13:31:32
*/
@Service
public class JobsServiceImpl extends ServiceImpl<JobsMapper, Jobs>
    implements JobsService{
    @Autowired
    private JobsMapper jobsMapper;
    @Autowired
    private EmployeesMapper employeesMapper;
    @Override
    public Result findAll() {
        List<Jobs> jobs = jobsMapper.selectList(null);
        return Result.ok(jobs);
    }

    @Override
    public Result add(Jobs jobs) {
        int insert = jobsMapper.insert(jobs);
        if (insert>0){
            return Result.ok(null);
        }
        return Result.build(null, 606,"岗位添加失败");
    }

    @Override
    public Result deleteById(String jobId) {
        int i = jobsMapper.deleteById(jobId);
        if (i>0){
            employeesMapper.deleteByJobId(jobId);
            return Result.ok(null);
        }
        return Result.build(null,607,"删除岗位失败");
    }
}




