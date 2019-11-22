package com.jk.comd.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.comd.model.Adv;
import com.jk.comd.model.Commodity;
import com.jk.comd.service.ComdService;
import com.jk.user.model.CmsUser;
import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ComdController
 * @Deacription TODO
 * @Author 原国庆
 * @Date 2019/11/18 15:06
 * @Version 1.0
 **/
@Controller
@RequestMapping("comd")
public class ComdController {

    @Reference(version = "1.0")
    private ComdService comdService;

    @RequestMapping("queryPhone")
    @ResponseBody
    public List queryComdAll(){
        return comdService.queryComdAll();
    }

    @RequestMapping("queryComp")
    @ResponseBody
    public List queryComp(){
        return comdService.queryComp();
    }

    @RequestMapping("queryTelv")
    @ResponseBody
    public List queryTelv(){
        return comdService.queryTelv();
    }

    @RequestMapping("queryBestSelling")
    @ResponseBody
    public List queryBestSelling(){
        return comdService.queryBestSelling();
    }

    @RequestMapping("queryReTui")
    @ResponseBody
    public List queryReTui(){
        return comdService.queryReTui();
    }

    @RequestMapping("queryWeek")
    @ResponseBody
    public List queryWeek(){
        return comdService.queryWeek();
    }

    @RequestMapping("queryGoodComm")
    @ResponseBody
    public List queryGoodComm(){
        return comdService.queryGoodComm();
    }

    @RequestMapping("hottesGoods")
    @ResponseBody
    public List queryHottesGoods(){
        return comdService.queryHottesGoods();
    }

    @RequestMapping("queryAdv")
    @ResponseBody
    public List<Adv>  queryAdv(){
        return comdService.queryAdv();
    }

    @RequestMapping("queryType")
    @ResponseBody
    public List  queryType(){
        return comdService.queryType();
    }

    @RequestMapping("queryTypeTwo")
    @ResponseBody
    public List queryTypeTwo(){
        List list = comdService.queryTypeTwo();
        return list;
    }

    @RequestMapping("loginAndLoginout")
    @ResponseBody
    public Map loginAndLoginout(HttpServletRequest request){
        HttpSession session = request.getSession();
        Map map = new HashMap<>();
        if(session.getAttribute(session.getId())!=null){
            CmsUser cmsUser = (CmsUser) session.getAttribute(session.getId());
            map.put("cmsUser",cmsUser);
        }else{
            map.put("cmsUser",111);
        }
            return map;
    }

    @RequestMapping("loginOut")
    public  String   loginOut(HttpServletRequest request){
        HttpSession session=request.getSession();
        session.removeAttribute(session.getId());
        return "login";
    }

    @RequestMapping("queryLb")
    @ResponseBody
    public List queryLb(){
        return comdService.queryLb();
    }










}
