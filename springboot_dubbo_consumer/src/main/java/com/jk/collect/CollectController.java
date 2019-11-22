package com.jk.collect;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.collect.model.Collect;
import com.jk.collect.service.CollectService;
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

    @Reference(version = "1.1")
    private CollectService collectService;


    @RequestMapping("queryCollect")
    @ResponseBody
    public List<Collect> queryCollect(HttpServletRequest request){
        return collectService.queryCollect(request);
    }

    @RequestMapping("deleteCollect")
    @ResponseBody
    public void deleteCollect(Integer id){
        collectService.deleteCollect(id);
    }


    @RequestMapping("addCollect")
    @ResponseBody
    public void addCollect(Integer commodityId,HttpServletRequest request){
        collectService.addCollect(commodityId,request);
    }

    @RequestMapping("tocollect")
    public String tocollect(){
        return "collect/collect";
    }
}
