package com.mall.service.impl;


import com.mall.dao.ProductDao;
import com.mall.model.PmsProduct;
import com.mall.model.PmsProductParm;
import com.mall.model.PmsSkuStock;
import com.mall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by IntelliJ IDEA
 * Author: d-arlin@qq.com
 * Date: 2019/10/22
 * Time: 23:43
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public PmsProductParm getProductDetails(String id) {

        PmsProduct pmsProduct = productDao.getProductDetails(id);
        List<PmsSkuStock> pmsSkuStockList = productDao.getPmsSkuStock(id);
        PmsProductParm pmsProductResult = new PmsProductParm();
        pmsProductResult.setPmsProduct(pmsProduct);
        pmsProductResult.setAlbumPicsArray(pmsProduct.getAlbumPics().split(","));
        pmsProductResult.setSkuStockList(pmsSkuStockList);
        return pmsProductResult;
    }
}
