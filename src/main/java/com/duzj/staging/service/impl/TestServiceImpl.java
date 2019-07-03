package com.duzj.staging.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duzj.staging.dao.TestDao;
import com.duzj.staging.pojo.Test;
import com.duzj.staging.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * @Author duzj
 * @date 2019/07/03
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestDao, Test> implements ITestService {
    @Autowired
    private TestDao testDao;
}
