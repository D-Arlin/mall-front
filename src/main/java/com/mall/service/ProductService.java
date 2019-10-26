package com.mall.service;

import com.mall.model.PmsProductParm;

/**
 * Created by IntelliJ IDEA
 * Author: d-arlin@qq.com
 * Date: 2019/10/22
 * Time: 23:42
 */
public interface ProductService {

    PmsProductParm getProductDetails(String id);
}
