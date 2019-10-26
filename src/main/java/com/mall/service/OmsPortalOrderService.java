package com.mall.service;


import com.mall.api.CommonResult;
import com.mall.model.OmsCartItem;
import org.springframework.transaction.annotation.Transactional;

/**
 * 前台订单管理Service
 * Created by macro on 2018/8/30.
 */
public interface OmsPortalOrderService {

    /**
     * 根据提交信息生成订单
     */
    @Transactional
    CommonResult generateOrder(OmsCartItem orderParam);


}
