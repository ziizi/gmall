package com.bai.gmall.services;

import com.bai.gmall.beans.PmsSkuInfo;

import java.util.List;

public interface SkuService {

    void saveSkuInfo(PmsSkuInfo pmsSkuInfo);

    PmsSkuInfo getSkuById(String skuId);

    List<PmsSkuInfo> getAllSku();

}
