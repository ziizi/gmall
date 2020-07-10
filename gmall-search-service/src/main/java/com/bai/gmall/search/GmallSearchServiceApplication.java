package com.bai.gmall.search;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bai.gmall.beans.PmsSkuInfo;
import com.bai.gmall.services.SkuService;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class GmallSearchServiceApplication {

    @Reference
    SkuService skuService;

    @Autowired
    JestClient jestClient;


    public static void main(String[] args) {

        SpringApplication.run(GmallSearchServiceApplication.class, args);
    }

    // 通过jestClient api的index 导入es数据库中
    @Test
    void contextInfo(){

        List<PmsSkuInfo> allSku = skuService.getAllSku();
        // 通过 服务获取饿allsku 导入es的数据库中
        for (PmsSkuInfo pmsSkuInfo : allSku) {
            Index index= new Index.Builder(pmsSkuInfo).index("gmall").type("skuInfo").id(pmsSkuInfo.getId()).build();
            try {
                jestClient.execute(index);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 通过 jestClient客户端api的dsl查询语句获取 结果
    @Test
    void contextInfo2() throws IOException {

        List<PmsSkuInfo> pmsSkuInfos = new ArrayList<>();
        Search serach = new Search.Builder("dsl").addIndex("gmall").addType("skuInfo").build();

        SearchResult execute = jestClient.execute(serach);

        List<SearchResult.Hit<PmsSkuInfo, Void>> hits = execute.getHits(PmsSkuInfo.class);

        for (SearchResult.Hit<PmsSkuInfo, Void> hit : hits) {
            PmsSkuInfo source = hit.source;
            pmsSkuInfos.add(source);
        }

    }


    @Test
    void contextInfo3() throws IOException {

        // 用jest 的dsl 工具
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // bool
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        // filter
        boolQueryBuilder.filter();
        // must
        boolQueryBuilder.must();

        // query
        searchSourceBuilder.query(boolQueryBuilder);

        // from
        searchSourceBuilder.from(0);
        // size
        searchSourceBuilder.size(20);
        //  highlight
        searchSourceBuilder.highlighter(null);
 



        List<PmsSkuInfo> pmsSkuInfos = new ArrayList<>();
        Search serach = new Search.Builder(searchSourceBuilder.toString()).addIndex("gmall").addType("skuInfo").build();

        SearchResult execute = jestClient.execute(serach);

        List<SearchResult.Hit<PmsSkuInfo, Void>> hits = execute.getHits(PmsSkuInfo.class);

        for (SearchResult.Hit<PmsSkuInfo, Void> hit : hits) {
            PmsSkuInfo source = hit.source;
            pmsSkuInfos.add(source);
        }

    }
}
