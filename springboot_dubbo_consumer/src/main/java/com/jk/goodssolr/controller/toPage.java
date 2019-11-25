package com.jk.goodssolr.controller;

import com.jk.utils.QueryParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName toPage
 * @Deacription TODO
 * @Author liushuxin
 * @Date 2019/11/21 10:51
 * @Version 1.0
 **/
@Controller
@RequestMapping("tosolr")
public class toPage {
    @RequestMapping("toQueryButton")
    public String toQuery(){
        return "sorlgoods/solrbutton";
    }
    @RequestMapping("tosolrshow")
    public String tosolrshow(String flag, Model model,Integer bigTypeId,String bigTypeName,Integer smallTypeid,String smalltypename){
        QueryParam queryParam = new QueryParam();
        queryParam.setFlag(flag);
        queryParam.setBigTypeId(bigTypeId);
        queryParam.setBigTypeName(bigTypeName);
        queryParam.setSmallTypeid(smallTypeid);
        queryParam.setSmalltypename(smalltypename);
        model.addAttribute("qp",queryParam);
        return "sorlgoods/solrshow";
    }
}
