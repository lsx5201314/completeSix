package com.jk.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.jk.user.model.CmsUser;
import com.jk.user.service.UserService;
import com.jk.user.util.HttpClientUtil;
import io.lettuce.core.dynamic.domain.Timeout;
import org.omg.CORBA.TIMEOUT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Time;
import java.time.DateTimeException;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.jk.user.constant.Constant.KEY;

@Controller
@RequestMapping("user")
public class UserController {

    @Reference(version = "1.1")
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    /** @Author 原国庆
     * @Description: 登录验证
     * @Param: [cmsUser, request]
     * @Return: java.lang.Integer
     * @Create: 2019/11/18 8:42
     */
    @RequestMapping("loginCms")
    @ResponseBody
    public  Integer   loginCms(CmsUser cmsUser,HttpServletRequest request){
        String userKey=KEY+cmsUser.getCmsUserName();
        CmsUser user = (CmsUser) redisTemplate.opsForValue().get(userKey);
        if(user!=null){
            if(cmsUser.getCmsUserPwd().equals(user.getCmsUserPwd())){
                return 1;
            }
                return 2;
        }
        if(user==null){
            CmsUser loginUser=userService.queryCmsUser(cmsUser.getCmsUserName());
            if(cmsUser.getCmsUserPwd().equals(loginUser.getCmsUserPwd())){
                redisTemplate.opsForValue().set(userKey,JSON.toJSONString(loginUser));
                redisTemplate.expire(userKey,10,TimeUnit.DAYS);
                HttpSession session = request.getSession();
                session.setAttribute(session.getId(),loginUser);
                return 1;
            }
                return 2;
        }
        return 3;
    }
    @RequestMapping("registerCmsUser")
    @ResponseBody
    public  Integer registerCmsUser(CmsUser cmsUser){
        cmsUser.setCmsUserDate(new Date());
        try {
            userService.addCmsUser(cmsUser);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 2;
    }

    @RequestMapping("noteHint")
    @ResponseBody
    public Integer noteHint(String cmsPhone){
        if(redisTemplate.hasKey(cmsPhone)){
            String yzm = (String) redisTemplate.opsForValue().get(cmsPhone);
            return Integer.parseInt(yzm);
        }
        Random r = new Random();
        int yz = r.nextInt(899999)+100000;
        String url="http://v.juhe.cn/sms/send";
        //http://v.juhe.cn/sms/send?mobile=手机号码&tpl_id=短信模板ID&tpl_value=%23code%23%3D654654&key=
        HashMap<String, Object> map = new HashMap<>();
        map.put("mobile",cmsPhone);
        //六脉短信 198843
        map.put("tpl_id",192642);
        map.put("tpl_value", "#code#="+yz);
        map.put("key","e72080c20a1c19d4f580490131315649");
        String key=yz+"";
        redisTemplate.opsForValue().set(cmsPhone,key);
        redisTemplate.expire(cmsPhone,5, TimeUnit.MINUTES);
         HttpClientUtil.post(url, map);
        return yz;
      /*  int yz = r.nextInt(899999)+100000;
        String url = "http://v.juhe.cn/sms/send";
        HashMap<String,Object> m = new HashMap<String,Object>();
        m.put("mobile", phone);
        m.put("tpl_id", 192582);
        m.put("tpl_value", "#code#="+yz);
        m.put("key", "d5967d957fe4af4f9379fdac68115bd7");
        HttpClientUtil.post(url,m);
        return yz;*/
    }

}
