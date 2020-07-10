package com.bai.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bai.gmall.beans.PmsBaseAttrInfo;
import com.bai.gmall.beans.PmsBaseAttrValue;
import com.bai.gmall.beans.PmsBaseSaleAttr;
import com.bai.gmall.services.AttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
public class AttrController {

    @Reference
    AttrService attrService;

    @RequestMapping(path = "attrInfoList")
    @ResponseBody
    public List<PmsBaseAttrInfo> attrInfoList (String catalog3Id){
        List<PmsBaseAttrInfo> pmsBaseAttrInfoLis = attrService.attrInfoList (catalog3Id);
        return pmsBaseAttrInfoLis;
    }

    @RequestMapping(path = "saveAttrInfo")
    @ResponseBody
    public String saveAttrInfo (@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo){
        return attrService.saveAttrInfo(pmsBaseAttrInfo);
    }


    @RequestMapping(path = "getAttrValueList")
    @ResponseBody
    public List<PmsBaseAttrValue> getAttrValueList (String attrId){
        List<PmsBaseAttrValue>  pmsBaseAttrValues = attrService.getAttrValueList(attrId);
        return pmsBaseAttrValues;
    }



    @RequestMapping(path = "baseSaleAttrList")
    @ResponseBody
    public List<PmsBaseSaleAttr> baseSaleAttrList (){
        List<PmsBaseSaleAttr>  pmsBaseAttrValues = attrService.baseSaleAttrList();
        return pmsBaseAttrValues;
    }
}
