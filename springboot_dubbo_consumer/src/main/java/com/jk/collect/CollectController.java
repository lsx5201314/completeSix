package com.jk.collect;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.collect.model.Collect;
import com.jk.collect.service.CollectService;
import com.jk.goods.model.Commodity;
import com.jk.order.model.TOrder;
import com.jk.talk.model.Talk;
import com.jk.user.model.CmsUser;
import com.jk.user.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName CollectController
 * @Description
 * @Author
 * @Date 2019/11/22 10:57
 * @Version V1.0
 **/
@Controller
@RequestMapping("collect")
public class CollectController {

    @Reference(version = "1.0")
    private CollectService collectService;


    @RequestMapping("queryCollect")
    @ResponseBody
    public List<Collect> queryCollect(HttpServletRequest request){
        String id = request.getSession().getId();
        CmsUser user = (CmsUser) request.getSession().getAttribute(id);
        return collectService.queryCollect(user.getCmsUserId());
    }

    @RequestMapping("deleteCollect")
    @ResponseBody
    public void deleteCollect(Integer id){
        collectService.deleteCollect(id);
    }

    @RequestMapping("myOrder")
    @ResponseBody
    public List<TOrder> myOrder(HttpServletRequest request){
        String id = request.getSession().getId();
        CmsUser user = (CmsUser) request.getSession().getAttribute(id);
        return collectService.myOrder(user.getCmsUserId());
    }

    @RequestMapping("detailed")
    @ResponseBody
    public List<Commodity> detailed(String id){

        return collectService.detailed(id);
    }

    @RequestMapping("addCollect")
    @ResponseBody
    public int addCollect(Integer commodityId,HttpServletRequest request){
        String id = request.getSession().getId();
        CmsUser user = (CmsUser) request.getSession().getAttribute(id);
        Collect c = collectService.queryCollectByCommodityId(commodityId);
        if(c==null){
            collectService.addCollect(commodityId,user.getCmsUserId());
            return 1;
        }
        collectService.deleteCollectAll(commodityId,user.getCmsUserId());
        return 2;

    }

    @RequestMapping("addTalk")
    @ResponseBody
    public int addTalk(Integer id,HttpServletRequest request){
        String sessionId = request.getSession().getId();
        CmsUser user = (CmsUser) request.getSession().getAttribute(sessionId);
        Talk talk = collectService.addTalk(id, user.getCmsUserId());
        if(talk == null){
            return 1;
        }
        return 2;
    }

    @RequestMapping("addTalk2")
    @ResponseBody
    public void addTalk2(Integer id,String talkinfo,HttpServletRequest request){
        String sessionId = request.getSession().getId();
        CmsUser user = (CmsUser) request.getSession().getAttribute(sessionId);
        collectService.addTalk2(user.getCmsUserId(),id,talkinfo);
    }

    @RequestMapping("tocollect")
    public String tocollect(){
        return "collect/collect";
    }
}
