package com.mall.dao;

import com.mall.model.PmsProduct;
import com.mall.model.PmsSkuStock;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * Author: d-arlin@qq.com
 * Date: 2019/10/22
 * Time: 23:43
 */

public interface ProductDao {

    PmsProduct getProductDetails(String id);

    List<PmsSkuStock> getPmsSkuStock(String pid);
}
