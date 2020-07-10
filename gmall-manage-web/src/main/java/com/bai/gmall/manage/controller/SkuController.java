package com.bai.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bai.gmall.beans.PmsBaseSaleAttr;
import com.bai.gmall.beans.PmsSkuInfo;
import com.bai.gmall.services.SkuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@CrossOrigin
@Controller
public class SkuController {

    @Reference
    SkuService skuService;

    @RequestMapping(path = "saveSkuInfo")
    @ResponseBody
    public String saveSkuInfo (@RequestBody PmsSkuInfo pmsSkuInfo){
        pmsSkuInfo.setProductId(pmsSkuInfo.getSpuId());
        // 处理默认图片
        String skuDefaultImg = pmsSkuInfo.getSkuDefaultImg();
        if (StringUtils.isBlank(skuDefaultImg)) {
            pmsSkuInfo.setSkuDefaultImg(pmsSkuInfo.getSkuImageList().get(0).getImgUrl());
        }
        skuService.saveSkuInfo(pmsSkuInfo);
        return "success";
    }
}
