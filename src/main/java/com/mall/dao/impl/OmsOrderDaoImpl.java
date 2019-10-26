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
        return 0;
    }
}
