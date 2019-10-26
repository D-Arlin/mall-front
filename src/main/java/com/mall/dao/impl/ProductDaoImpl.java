package com.mall.dao.impl;


import com.mall.dao.ProductDao;
import com.mall.model.PmsProduct;
import com.mall.model.PmsSkuStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Created by IntelliJ IDEA
 * Author: d-arlin@qq.com
 * Date: 2019/10/22
 * Time: 23:44
 */
@Component
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public PmsProduct getProductDetails(String id) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM pms_product WHERE id = ?");
        return jdbcTemplate.queryForObject(sb.toString()
                ,new BeanPropertyRowMapper<>(PmsProduct.class)
                ,id);
    }

    @Override
    public List<PmsSkuStock> getPmsSkuStock(String pid) {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT * FROM pms_sku_stock WHERE product_id = ? ORDER BY price");
        return jdbcTemplate.query(sb.toString()
                ,new BeanPropertyRowMapper<>(PmsSkuStock.class)
                ,pid);
    }
}
