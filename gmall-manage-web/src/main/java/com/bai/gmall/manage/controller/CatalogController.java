package com.bai.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bai.gmall.beans.PmsBaseCatalog1;
import com.bai.gmall.beans.PmsBaseCatalog2;
import com.bai.gmall.beans.PmsBaseCatalog3;
import com.bai.gmall.services.CatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin // 解决跨域问题
public class CatalogController {

    @Reference
    private CatalogService catalogService;


    @RequestMapping("getCatalog1")
    @ResponseBody
    public List<PmsBaseCatalog1> getCatalog1() {
        List<PmsBaseCatalog1> catalog1s = catalogService.getCatalog1();
        return catalog1s;
    }

    @RequestMapping("getCatalog2")
    @ResponseBody
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id) {
        List<PmsBaseCatalog2> catalog2s = catalogService.getCatalog2(catalog1Id);
        return catalog2s;
    }

    @RequestMapping("getCatalog3")
    @ResponseBody
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id) {
        List<PmsBaseCatalog3> catalog3s = catalogService.getCatalog3(catalog2Id);
        return catalog3s;
    }

}
