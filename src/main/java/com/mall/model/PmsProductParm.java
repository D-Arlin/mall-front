package com.mall.model;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


/**
 * 创建和修改商品时使用的参数
 * Created by macro on 2018/4/26.
 */
@Data
public class PmsProductParm extends PmsProduct{

    private PmsProduct pmsProduct;

    @ApiModelProperty("商品的sku库存信息")
    private List<PmsSkuStock> skuStockList;

    private String[] albumPicsArray;




}
