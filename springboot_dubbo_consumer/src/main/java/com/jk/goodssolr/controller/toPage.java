package com.jk.goodssolr.controller;

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
    public String tosolrshow(String flag, Model model){
        model.addAttribute("flag",flag);
        return "sorlgoods/solrshow";
    }
}
