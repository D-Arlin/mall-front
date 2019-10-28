package com.mall.dao.impl;

import com.mall.dao.OmsOrderDao;
import com.mall.model.OmsOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA
 * Author: d-arlin@qq.com
 * Date: 2019/10/27
 * Time: 2:09
 */
@Component
public class OmsOrderDaoImpl implements OmsOrderDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(OmsOrder record) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into oms_order ( member_id,order_sn, create_time, total_amount, \n" +
                "      pay_amount, freight_amount, discount_amount, \n" +
                "      pay_type, source_type, status, order_type, \n" +
                "      receiver_name, receiver_phone, receiver_post_code, \n" +
                "      receiver_province, receiver_city, receiver_region, \n" +
                "      receiver_detail_address, note, confirm_status, delete_status) " +
                " values (1,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        jdbcTemplate.update(sql.toString()
                , record.getOrderSn()
                , record.getCreateTime()
                , record.getTotalAmount()
                , record.getPayAmount()
                , record.getFreightAmount()
                , record.getDiscountAmount()
                , record.getPayType()
                , record.getSourceType()
                , record.getStatus()
                , record.getOrderType()
                , record.getReceiverName()
                , record.getReceiverPhone()
                , record.getReceiverPostCode()
                , record.getReceiverProvince()
                , record.getReceiverCity()
                , record.getReceiverRegion()
                , record.getReceiverDetailAddress()
                , record.getNote()
                , record.getConfirmStatus()
                , record.getDeleteStatus()
        );
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()",Integer.class);
    }

}
