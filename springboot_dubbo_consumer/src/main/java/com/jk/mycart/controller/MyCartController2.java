package com.jk.mycart.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.jk.comd.model.Commodity;
import com.jk.common.CommonConf;
import com.jk.entity.model.Result;
import com.jk.mycart.service.MyCartService2;
import com.jk.user.model.CmsUser;
import com.jk.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("mycart")
public class MyCartController2 {
    @Resource
    private RedisTemplate redisTemplate;
    @Reference(version = "1.0")
    private MyCartService2 myCartService2;
    @Autowired
    private HttpServletRequest request;
    @Resource
    private HttpServletResponse response;
    @RequestMapping("findMyCartCount")
    @ResponseBody
    public String  findMyCartCount(){
        HttpSession session = request.getSession();
        CmsUser user= (CmsUser) session.getAttribute(session.getId());
        System.out.println("当前登录人："+user.getCmsUserName());
        String redisMyCartKey= CommonConf.LOGIN_CACHE_KEY+user.getCmsUserName();

        return  myCartService2.findMyCartCount(redisMyCartKey);
    }
    @RequestMapping("changeMyCart")
    @ResponseBody
    public void changeMyCart( List<Commodity> mycartInfoList){
        HttpSession session = request.getSession();
        CmsUser user= (CmsUser) session.getAttribute(session.getId());
        System.out.println("当前登录人："+user.getCmsUserName());
        String redisMyCartKey= CommonConf.LOGIN_CACHE_KEY+user.getCmsUserName();
        myCartService2.changeMyCart(mycartInfoList,redisMyCartKey);
    }
    @RequestMapping("removeMyCartByGoodsId")
    @ResponseBody
    public void removeMyCartByGoodsId(String id){
        HttpSession session = request.getSession();
        CmsUser user= (CmsUser) session.getAttribute(session.getId());
        System.out.println("当前登录人："+user.getCmsUserName());
        String redisMyCartKey= CommonConf.LOGIN_CACHE_KEY+user.getCmsUserName();
        myCartService2.removeMyCartByGoodsId(id,redisMyCartKey);
    }
    @RequestMapping("queryMyCartAllPrice")
    @ResponseBody
    public Integer queryMyCartAllPrice(){
        HttpSession session = request.getSession();
        CmsUser user= (CmsUser) session.getAttribute(session.getId());
        System.out.println("当前登录人："+user.getCmsUserName());
        String redisMyCartKey= CommonConf.LOGIN_CACHE_KEY+user.getCmsUserName();
        return myCartService2.queryMyCartAllPrice(redisMyCartKey);
    }
    @RequestMapping("/queryMyCartInfo")
    @ResponseBody
    public List<Commodity> findCartList(){
        HttpSession session = request.getSession();
        CmsUser user= (CmsUser) session.getAttribute(session.getId());
        System.out.println("当前登录人："+user.getCmsUserName());
        String redisMyCartKey= CommonConf.LOGIN_CACHE_KEY+user.getCmsUserName();
        String loclCartCookiesKey=CommonConf.LOCALCART_CACHE_KEY;
        String cartListString = CookieUtil.getCookieValue(request, "redisMyCartKey", "UTF-8");
        if(cartListString==null || cartListString.equals("")){
            cartListString="[]";
        }
        List<Commodity> cartList_cookie = JSON.parseArray(cartListString, Commodity.class);

        if(user==null && "".equals(user.getCmsUserName())){//如果未登录
            //从cookie中提取购物车
            System.out.println("从cookie中提取购物车");
            return cartList_cookie;
        }else{//如果已登录
            //获取redis购物车
            List<Commodity> cartList_redis = myCartService2.findCartListFromRedis(redisMyCartKey);
            if(cartList_cookie!=null && cartList_cookie.size()>0){//判断当本地购物车中存在数据
                //得到合并后的购物车
                List<Commodity> cartList = myCartService2.mergeCartList(cartList_cookie, cartList_redis);
                //将合并后的购物车存入redis
                myCartService2.saveCartListToRedis(redisMyCartKey, cartList);
                //本地购物车清除
                CookieUtil.deleteCookie(request, response, loclCartCookiesKey);
                System.out.println("执行了合并购物车的逻辑");
                return cartList;
            }
            return cartList_redis;
        }

    }

    @RequestMapping("/addGoodsToCartList")
    @ResponseBody
    public Result addGoodsToCartList( Long itemId, Integer num){
        HttpSession session = request.getSession();
        CmsUser user= (CmsUser) session.getAttribute(session.getId());
        //当前登录人账号
        String redisMyCartKey=CommonConf.LOGIN_CACHE_KEY+user.getCmsUserName();
        String loclCartCookiesKey=CommonConf.LOCALCART_CACHE_KEY;
        System.out.println("当前登录人："+user.getCmsUserName());
        try {
            //提取购物车
            List<Commodity> cartList = findCartList();
            //调用服务方法操作购物车
            cartList = myCartService2.addGoodsToCartList(cartList, itemId, num);

            if(user.getCmsUserName().equals("")){//如果未登录
                //将新的购物车存入cookie
                String cartListString = JSON.toJSONString(cartList);
                CookieUtil.setCookie(request, response, loclCartCookiesKey, cartListString, 3600*24, "UTF-8");
                System.out.println("向cookie存储购物车");

            }else{//如果登录
                myCartService2.saveCartListToRedis(redisMyCartKey, cartList);
            }
            return new Result(true, "存入购物车成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "存入购物车失败");
        }


    }
}
