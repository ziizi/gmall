package com.bai.gmall.manage.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.bai.gmall.beans.PmsSkuAttrValue;
import com.bai.gmall.beans.PmsSkuImage;
import com.bai.gmall.beans.PmsSkuInfo;
import com.bai.gmall.beans.PmsSkuSaleAttrValue;
import com.bai.gmall.manage.mapper.PmsSkuAttrValueMapper;
import com.bai.gmall.manage.mapper.PmsSkuImageMapper;
import com.bai.gmall.manage.mapper.PmsSkuInfoMapper;
import com.bai.gmall.manage.mapper.PmsSkuSaleAttrValueMapper;
import com.bai.gmall.services.SkuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkuServiceImp implements SkuService {

    @Autowired
    PmsSkuInfoMapper pmsSkuInfoMapper;

    @Autowired
    PmsSkuAttrValueMapper pmsSkuAttrValueMapper;

    @Autowired
    PmsSkuImageMapper pmsSkuImageMapper;

    @Autowired
    PmsSkuSaleAttrValueMapper pmsSkuSaleAttrValueMapper;

    @Override
    public void saveSkuInfo(PmsSkuInfo pmsSkuInfo) {

        int i = pmsSkuInfoMapper.insertSelective(pmsSkuInfo);
        String skuId = pmsSkuInfo.getId();

        // 插入平台属性关联
        List<PmsSkuAttrValue> skuAttrValueList = pmsSkuInfo.getSkuAttrValueList();
        for (PmsSkuAttrValue pmsSkuAttrValue : skuAttrValueList) {
            pmsSkuAttrValue.setSkuId(skuId);
            pmsSkuAttrValueMapper.insertSelective(pmsSkuAttrValue);
        }

        // 插入销售属性
        List<PmsSkuSaleAttrValue> skuSaleAttrValueList = pmsSkuInfo.getSkuSaleAttrValueList();
        for (PmsSkuSaleAttrValue pmsSkuSaleAttrValue : skuSaleAttrValueList) {
            pmsSkuSaleAttrValue.setSkuId(skuId);
            pmsSkuSaleAttrValueMapper.insertSelective(pmsSkuSaleAttrValue);
        }

        // 插入图片
        List<PmsSkuImage> skuImageList = pmsSkuInfo.getSkuImageList();
        for (PmsSkuImage pmsSkuImage : skuImageList) {
            pmsSkuImage.setSkuId(skuId);
            pmsSkuImageMapper.insertSelective(pmsSkuImage);

        }

    }

    @Override
    public List<PmsSkuInfo> getAllSku() {
        List<PmsSkuInfo> objects = new ArrayList<>();
        List<PmsSkuInfo> pmsSkuInfos = pmsSkuInfoMapper.selectAll();
        for (PmsSkuInfo pmsSkuInfo : pmsSkuInfos) {

        }
        
        return pmsSkuInfos;
    }

    @Override
    public PmsSkuInfo getSkuById(String skuId) {
        PmsSkuInfo pmsSkuInfo = new PmsSkuInfo();
        pmsSkuInfo.setId(skuId);
        PmsSkuInfo pmsSkuInfo1 = pmsSkuInfoMapper.selectOne(pmsSkuInfo);

        return pmsSkuInfo1;
    }
}
