package com.bai.gmall.services;

import com.bai.gmall.beans.PmsBaseAttrInfo;
import com.bai.gmall.beans.PmsBaseAttrValue;
import com.bai.gmall.beans.PmsBaseSaleAttr;

import java.util.List;

public interface AttrService {
    List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);

    String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    List<PmsBaseAttrValue> getAttrValueList(String attrId);

    List<PmsBaseSaleAttr> baseSaleAttrList();
}
