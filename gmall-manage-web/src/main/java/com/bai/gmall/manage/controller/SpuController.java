package com.bai.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bai.gmall.beans.PmsProductImage;
import com.bai.gmall.beans.PmsProductInfo;
import com.bai.gmall.beans.PmsProductSaleAttr;
import com.bai.gmall.manage.util.PmsUploadUtil;
import com.bai.gmall.services.SpuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@CrossOrigin
public class SpuController {

    @Reference
    SpuService spuService;


    @RequestMapping("spuList")
    @ResponseBody
    public List<PmsProductInfo> spuList(String catalog3Id){
        List<PmsProductInfo> pmsProductInfos = spuService.spuList(catalog3Id);
        return pmsProductInfos;
    }


    @RequestMapping("fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile multipartFile){
        // 将图片或者音视频上传到分布式文件服务器，将图片存储路径返回到页面
        String imgUrl = PmsUploadUtil.uploadImage(multipartFile);
        System.out.println(imgUrl);
        return imgUrl;
    }

    @RequestMapping("saveSpuInfo")
    @ResponseBody
    public String saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo){
        spuService.saveSpuInfo(pmsProductInfo);
        return "pmsProductInfos";
    }
    // spuSaleAttrList
    @RequestMapping("spuSaleAttrList")
    @ResponseBody
    public List<PmsProductSaleAttr> spuSaleAttrList(String spuId){
        List<PmsProductSaleAttr> pmsProductSaleAttrs = spuService.spuSaleAttrList(spuId);
        return pmsProductSaleAttrs;
    }


    @RequestMapping("spuImageList")
    @ResponseBody
    public List<PmsProductImage> spuImageList(String spuId){
        List<PmsProductImage> PmsProductImages = spuService.spuImageList(spuId);
        return PmsProductImages;
    }
}
