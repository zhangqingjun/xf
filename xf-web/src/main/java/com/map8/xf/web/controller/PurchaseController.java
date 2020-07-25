package com.map8.xf.web.controller;

import com.map8.xf.service.inquiry.TProductService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(value = "/purchase",tags = "采购")
@RestController
public class PurchaseController {

    @Resource
    private TProductService tProductService;

    @PostMapping("/purchase")
    public Boolean purchase(Long userId,Long productId,Integer quantity){
        return tProductService.purchase(userId,productId,quantity);
    }

}
