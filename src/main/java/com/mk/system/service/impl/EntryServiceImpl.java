package com.mk.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mk.system.pojo.Entry;
import com.mk.system.service.EntryService;
import com.mk.system.mapper.EntryMapper;
import org.springframework.stereotype.Service;

/**
* @author mao
* @description 针对表【tbentry】的数据库操作Service实现
* @createDate 2023-12-21 13:31:32
*/
@Service
public class EntryServiceImpl extends ServiceImpl<EntryMapper, Entry>
    implements EntryService{

}




