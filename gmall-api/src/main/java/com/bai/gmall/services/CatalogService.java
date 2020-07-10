package com.bai.gmall.services;

import com.bai.gmall.beans.PmsBaseCatalog1;
import com.bai.gmall.beans.PmsBaseCatalog2;
import com.bai.gmall.beans.PmsBaseCatalog3;

import java.util.List;

public interface CatalogService {
    List<PmsBaseCatalog1> getCatalog1();

    List<PmsBaseCatalog2> getCatalog2(String catalogId2);

    List<PmsBaseCatalog3> getCatalog3(String catalog2Id);
}
