package com.mall.controller;

import com.mall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 商品管理
 *
 * Author: d-arlin@qq.com
 * Date: 2019/10/22
 * Time: 22:51
 */
@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     *根据商品ID获取商品详情
     *
     * @param id 商品ID
     * @param map 返回结果集
     * @return
     */
    @GetMapping("{id}")
    public String getProductDetails(@PathVariable("id") String id, ModelMap map) {
        map.addAttribute("productDetails", productService.getProductDetails(id));
        return "productDetails";
    }
}
