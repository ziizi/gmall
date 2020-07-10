package com.bai.gmall.manage.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.bai.gmall.beans.PmsBaseCatalog1;
import com.bai.gmall.beans.PmsBaseCatalog2;
import com.bai.gmall.beans.PmsBaseCatalog3;
import com.bai.gmall.manage.mapper.PmsBaseCatalog1Mapper;
import com.bai.gmall.manage.mapper.PmsBaseCatalog2Mapper;
import com.bai.gmall.manage.mapper.PmsBaseCatalog3Mapper;
import com.bai.gmall.services.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.GeneratedValue;
import java.util.List;

@Service
public class CatalogServiceImp implements CatalogService {

    @Autowired
    PmsBaseCatalog1Mapper pmsBaseCatalog1Mapper;

    @Autowired
    PmsBaseCatalog2Mapper pmsBaseCatalog2Mapper;

    @Autowired
    PmsBaseCatalog3Mapper pmsBaseCatalog3Mapper;

    @Override
    public List<PmsBaseCatalog1> getCatalog1() {
        return pmsBaseCatalog1Mapper.selectAll();
    }

    @Override
    public List<PmsBaseCatalog2> getCatalog2(String catalogId2) {
        PmsBaseCatalog2 pmsBaseCatalog2 = new PmsBaseCatalog2();
        pmsBaseCatalog2.setCatalog1Id(catalogId2);
        return pmsBaseCatalog2Mapper.select(pmsBaseCatalog2);
    }

    @Override
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id) {
        PmsBaseCatalog3 pmsBaseCatalog3 = new PmsBaseCatalog3();
        pmsBaseCatalog3.setCatalog2Id(catalog2Id);
        return pmsBaseCatalog3Mapper.select(pmsBaseCatalog3);
    }
}
