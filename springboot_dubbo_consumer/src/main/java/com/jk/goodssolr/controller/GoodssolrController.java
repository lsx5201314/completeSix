package com.jk.goodssolr.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.goodssolr.model.SolrGoods;
import com.jk.goodssolr.util.PageModel;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName GoodssolrController
 * @Deacription TODO
 * @Author liushuxin
 * @Date 2019/11/20 18:33
 * @Version 1.0
 **/
@Controller
@RequestMapping("goodssolr")
public class GoodssolrController {
    @Autowired
    private SolrClient client;

    @RequestMapping("queryGoods")
    @ResponseBody
    public PageModel queryGoods(PageModel page, SolrGoods goods){
        if (page.getPageNow()==null || "".equals(page.getPageNow())){
            page.setPageNow(1);
        }
        Integer start = (page.getPageNow()-1)*page.getPageCount();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            SolrQuery params = new SolrQuery();
            //查询条件, 这里的 q 对应 下面图片标红的地方
            if (goods.getFlag()!=null && !"".equals(goods.getFlag())){
                params.set("q", "search_all_keywords:"+goods.getFlag());
            }else {
                params.set("q","*:*");
            }
            //过滤条件
            if (goods.getBrandId()!=null && !"".equals(goods.getBrandId())){
                params.set("fq","brandId:"+goods.getBrandId());
            }
            if (goods.getTypeId()!=null && !"".equals(goods.getTypeId())){
                params.set("fq","typeId:"+goods.getTypeId());
            }
            // 设置查询的排序参数，1-排序的字段名，2-排序方式（ORDER：asc desc）
            if (goods.getOrderType()==1){
                params.addSort(goods.getOrder(), SolrQuery.ORDER.asc);
            }else {
                params.addSort(goods.getOrder(),SolrQuery.ORDER.desc);
            }

            //分页
            params.setStart(start);
            params.setRows(page.getPageCount());
            //默认域
            params.set("df", "search_all_keywords");

            //只查询指定域
            //params.set("fl", "id,product_title,product_price");

            //高亮
            //打开开关
            params.setHighlight(true);
            //指定高亮域
            params.addHighlightField("name");
            //设置前缀
            params.setHighlightSimplePre("<span style='color:red'>");
            //设置后缀
            params.setHighlightSimplePost("</span>");
            //查询后返回的对象
            QueryResponse queryResponse = client.query("core1",params);
            //查询后返回的对象 获得真正的查询结果
            SolrDocumentList results = queryResponse.getResults();
            //查询的总条数
            long numFound = results.getNumFound();

            PageModel pageModel = new PageModel((int) numFound, page.getPageNow(), page.getPageCount());


            //获取高亮显示的结果, 高亮显示的结果和查询结果是分开放的
            Map<String, Map<String, List<String>>> highlight = queryResponse.getHighlighting();
            List<SolrGoods> list1 =new ArrayList<SolrGoods>();
            for (SolrDocument result : results) {
                SolrGoods solrGoods = new SolrGoods();
                String highFile="";
                Map<String, List<String>> map = highlight.get(result.get("id"));
                List<String> list = map.get("name");
                if (list==null){
                    highFile = (String)result.get("name");
                }else {
                    highFile=list.get(0);
                }
                solrGoods.setId(Integer.valueOf((String)result.get("id")));
                solrGoods.setName(highFile);
                solrGoods.setDescription((String) result.get("description"));

                solrGoods.setPrice((Integer) result.get("price"));
                 solrGoods.setColor((String) result.get("color"));
                solrGoods.setImg((String) result.get("img"));
                solrGoods.setCamera((String) result.get("camera"));
                solrGoods.setSystem((String) result.get("system"));
                solrGoods.setTime((Date) result.get("time"));
                solrGoods.setBrand((String) result.get("brand"));
                /*solrGoods.setCarPrice(Double.valueOf(result.get("carPrice").toString()));*/
                list1.add(solrGoods);
            }
            pageModel.setList(list1);
            return pageModel;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
