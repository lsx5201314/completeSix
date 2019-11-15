package com.jk.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.user.model.CmsUser;
import com.jk.user.service.UserService;
import com.jk.user.util.HttpClientUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

@Controller
@RequestMapping("user")
public class UserController {

    @Reference(version = "1.1")
    private UserService userService;
    @RequestMapping("loginCms")
    @ResponseBody
    public  Integer   loginCms(CmsUser cmsUser,HttpServletRequest request){
         CmsUser loginUser=userService.queryCmsUser(cmsUser.getCmsUserName());
        if(loginUser!=null){
            if(cmsUser.getCmsUserPwd().equals(loginUser.getCmsUserPwd())){
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
