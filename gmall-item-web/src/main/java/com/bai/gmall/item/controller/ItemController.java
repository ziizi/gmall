package com.bai.gmall.item.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bai.gmall.beans.PmsSkuInfo;
import com.bai.gmall.services.SkuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ItemController {

    @Reference
    SkuService skuService;


    @RequestMapping("/index")
    //@ResponseBody
    public String index(ModelMap modelMap){


        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            strings.add("循环"+i);
        }
        modelMap.put("hello","hello thyemleaf from controller");
        modelMap.put("list",strings);
        modelMap.put("check","1");
        return "index";
    }


    @RequestMapping("{skuId}.html")
    //@ResponseBody
    public String item(@PathVariable String skuId, ModelMap modelMap){

        PmsSkuInfo pmsSkuInfo = skuService.getSkuById(skuId);
        modelMap.put("skuInfo",pmsSkuInfo);
        return "item";
    }
}
