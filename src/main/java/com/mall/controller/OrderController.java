package com.mall.controller;

import com.mall.api.CommonResult;
import com.mall.model.OmsCartItem;
import com.mall.service.OmsPortalOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单管理
 * Author: d-arlin@qq.com
 * Date: 2019/10/26
 * Time: 18:27
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OmsPortalOrderService portalOrderService;

    @PostMapping("generateOrder")
    public CommonResult generateOrder( OmsCartItem cartItem){
        return portalOrderService.generateOrder(cartItem);
    }
}
