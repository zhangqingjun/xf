package com.map8.xf.service.async.impl;

import com.map8.xf.service.async.AsyncService;
import org.springframework.scheduling.annotation.Async;

public class AsyncServiceImpl implements AsyncService {
    @Override
    @Async
    public void generateReport() {
        System.out.println("报表线程名称：【"+Thread.currentThread().getName()+"】");
    }
}
