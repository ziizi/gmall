package com.bai.gmall.services;

import com.bai.gmall.beans.PmsProductImage;
import com.bai.gmall.beans.PmsProductInfo;
import com.bai.gmall.beans.PmsProductSaleAttr;

import java.util.List;

public interface SpuService {
    List<PmsProductInfo> spuList(String catalog3Id);

    void saveSpuInfo(PmsProductInfo pmsProductInfo);

    List<PmsProductSaleAttr> spuSaleAttrList(String spuId);

    List<PmsProductImage> spuImageList(String spuId);
}
