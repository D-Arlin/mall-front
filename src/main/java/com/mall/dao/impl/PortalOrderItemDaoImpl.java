package com.mall.dao.impl;

import com.mall.dao.PortalOrderItemDao;
import com.mall.model.OmsOrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA
 * Author: d-arlin@qq.com
 * Date: 2019/10/27
 * Time: 2:12
 */
@Component
public class PortalOrderItemDaoImpl implements PortalOrderItemDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(OmsOrderItem omsOrderItem) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into oms_order_item (order_id, order_sn, product_id,\n" +
                "        product_pic, product_name, product_brand,\n" +
                "        product_sn, product_price, product_quantity,\n" +
                "        product_sku_id, product_category_id, product_sku_code,\n" +
                "        sp1, sp2, sp3, product_attr ) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        return jdbcTemplate.update(sql.toString()
                , omsOrderItem.getOrderId()
                , omsOrderItem.getOrderSn()
                , omsOrderItem.getProductId()
                , omsOrderItem.getProductPic()
                , omsOrderItem.getProductName()
                , omsOrderItem.getProductBrand()
                , omsOrderItem.getProductSn()
                , omsOrderItem.getProductPrice()
                , omsOrderItem.getProductQuantity()
                , omsOrderItem.getProductSkuId()
                , omsOrderItem.getProductCategoryId()
                , omsOrderItem.getProductSkuCode()
                , omsOrderItem.getSp1()
                , omsOrderItem.getSp2()
                , omsOrderItem.getSp3()
                , omsOrderItem.getProductAttr()
        );
    }
}
