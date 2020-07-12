package com.map8.xf.web.controller;

import com.map8.xf.service.async.AsyncService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/async")
public class AsyncController {
    @Resource
    private AsyncService asyncService;

    @GetMapping("/page")
    public String asncPage(){
        System.out.println("请求线程名称：["+Thread.currentThread().getName()+"]");
        asyncService.generateReport();
        return "async";
    }
}
