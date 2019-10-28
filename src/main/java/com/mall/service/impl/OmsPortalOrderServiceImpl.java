package com.mall.service.impl;

import com.mall.api.CommonResult;
import com.mall.dao.OmsOrderDao;
import com.mall.dao.PortalOrderItemDao;
import com.mall.model.OmsCartItem;
import com.mall.model.OmsOrder;
import com.mall.model.OmsOrderItem;
import com.mall.service.OmsPortalOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 前台订单管理Service
 * Created by macro on 2018/8/30.
 */
@Service
public class OmsPortalOrderServiceImpl implements OmsPortalOrderService {

    @Autowired
    private OmsOrderDao omsOrderDao;
    @Autowired
    private PortalOrderItemDao portalOrderItemDao;

    @Override
    public CommonResult generateOrder(OmsCartItem omsCartItem) {

        //生成下单商品信息
        OmsOrderItem orderItem = new OmsOrderItem();
        orderItem.setProductId(omsCartItem.getProductId());
        orderItem.setProductName(omsCartItem.getProductName());
        orderItem.setProductPic(omsCartItem.getProductPic());
        orderItem.setProductAttr(omsCartItem.getProductAttr());
        orderItem.setProductBrand(omsCartItem.getProductBrand());
        orderItem.setProductSn(omsCartItem.getProductSn());
        orderItem.setProductPrice(omsCartItem.getPrice());
        orderItem.setProductQuantity(omsCartItem.getQuantity());
        orderItem.setProductSkuId(omsCartItem.getProductSkuId());
        orderItem.setProductSkuCode(omsCartItem.getProductSkuCode());
        orderItem.setProductCategoryId(omsCartItem.getProductCategoryId());

        //根据商品合计、运费、活动优惠、优惠券、积分计算应付金额
        OmsOrder order = new OmsOrder();
        order.setDiscountAmount(new BigDecimal(0));
        order.setTotalAmount(omsCartItem.getPrice().multiply(new BigDecimal(omsCartItem.getQuantity())));
        order.setFreightAmount(new BigDecimal(0));
        order.setPayAmount(omsCartItem.getPrice().multiply(new BigDecimal(omsCartItem.getQuantity())));
        //转化为订单信息并插入数据库

        order.setCreateTime(new Date());

        //支付方式：0->未支付；1->支付宝；2->微信；3->货到付款
        order.setPayType(3);
        //订单来源：0->PC订单；1->app订单
        order.setSourceType(1);
        //订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单
        order.setStatus(0);
        //订单类型：0->正常订单；1->秒杀订单
        order.setOrderType(0);
        //收货人信息：姓名、电话、邮编、地址
        order.setReceiverName(omsCartItem.getName());
        order.setReceiverPhone(omsCartItem.getPhoneNumber());
        order.setReceiverPostCode(omsCartItem.getPostCode());
        order.setReceiverProvince(omsCartItem.getProvince());
        order.setReceiverCity(omsCartItem.getCity());
        order.setReceiverRegion(omsCartItem.getRegion());
        order.setReceiverDetailAddress(omsCartItem.getDetailAddress());
        order.setNote(omsCartItem.getNote());
        //0->未确认；1->已确认
        order.setConfirmStatus(0);
        order.setDeleteStatus(0);
        //生成订单号
        order.setOrderSn(generateOrderSn(order));

        //插入order表和order_item表
        Long insert = Long.valueOf(omsOrderDao.insert(order));
        orderItem.setOrderId(insert);
        orderItem.setOrderSn(order.getOrderSn());
        portalOrderItemDao.insert(orderItem);

        Map<String, Object> result = new HashMap<>();
        result.put("order", order);
        result.put("orderItemList", orderItem);
        return CommonResult.success("下单成功");
    }


    /**
     * 生成订单编号
     */
    private static Integer number = 0;
    private static int maxNum = 200000;
    private static String date = new SimpleDateFormat("yyyyMMdd").format(new Date());

    private String generateOrderSn(OmsOrder order) {
        StringBuilder sb = new StringBuilder();
        String now = new SimpleDateFormat("yyyyMMdd").format(new Date());
        if (!date.equals(now)) date = now;
        sb.append(date);
        sb.append(String.format("%02d", order.getSourceType()));
        sb.append(String.format("%02d", order.getPayType()));
        number++;//唯一数字自增
        if (number >= maxNum) { // 值的上限，超过就归零
            number = maxNum - 200000;
        }
        sb.append(String.format("%06d", number));
        return sb.toString();
    }

}
