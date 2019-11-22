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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    private RedisTemplate<String,String> redisTemplate;

    /** @Author 原国庆
     * @Description: 登录验证+缓存redis
     * @Param: [cmsUser, request]
     * @Return: java.lang.Integer
     * @Create: 2019/11/18 8:42
     */
    @RequestMapping("loginCms")
    @ResponseBody
    public  Integer   loginCms(CmsUser cmsUser,HttpServletRequest request){
        String userKey=KEY+cmsUser.getCmsUserName();
        if(redisTemplate.hasKey(userKey)){
            String user1=redisTemplate.opsForValue().get(userKey);
            CmsUser user = JSON.parseObject(user1, CmsUser.class);
            if (user != null) {
                if (cmsUser.getCmsUserPwd().equals(user.getCmsUserPwd())) {
                    HttpSession session = request.getSession();
                    session.setAttribute(session.getId(), user);
                    return 1;
                }
                return 2;
            }
        }
            CmsUser loginUser = userService.queryCmsUser(cmsUser.getCmsUserName());
            if (loginUser != null) {
                if (cmsUser.getCmsUserPwd().equals(loginUser.getCmsUserPwd())) {
                    redisTemplate.opsForValue().set(userKey, JSON.toJSONString(loginUser));
                    redisTemplate.expire(userKey, 10, TimeUnit.MINUTES);
                    HttpSession session = request.getSession();
                    session.setAttribute(session.getId(), loginUser);
                    return 1;
                }
                return 2;
            }
            return 3;


    }

    /** @Author 原国庆
     * @Description: 新增注册用户信息
     * @Param: [cmsUser]
     * @Return: java.lang.Integer
     * @Create: 2019/11/18 15:02
     */
    @RequestMapping("registerCmsUser")
    @ResponseBody
    public  void registerCmsUser(CmsUser cmsUser){
            cmsUser.setCmsUserDate(new Date());
            userService.addCmsUser(cmsUser);
    }

    /** @Author 原国庆
     * @Description: 注册短信接口
     * @Param: [cmsPhone]
     * @Return: java.lang.Integer
     * @Create: 2019/11/18 15:04
     */
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
        map.put("tpl_id",192669);
        map.put("tpl_value", "#code#="+yz);
        map.put("key","d79d603e4a2a2d5594c1605d81b7a3cc");
        String key=yz+"";
        redisTemplate.opsForValue().set(cmsPhone,key);
        redisTemplate.expire(cmsPhone,5, TimeUnit.HOURS);
        // HttpClientUtil.post(url, map);
        return yz;
    }

    /** @Author 原国庆
     * @Description: 忘记密码回显
     * @Param: [cmsUserName, model]
     * @Return: java.lang.String
     * @Create: 2019/11/19 11:59
     */
    @RequestMapping("forgetPwd")
    public String forgetPwd(String cmsUserName,Model model){
        CmsUser cmsUser=userService.queryForgetPwd(cmsUserName);
        model.addAttribute("cms",cmsUser);
        return "forget";
    }

    /** @Author 原国庆
     * @Description: 短信验证修改密码
     * @Param: [cmsUser]
     * @Return: void
     * @Create: 2019/11/19 11:59
     */
    @RequestMapping("updatePwd")
    @ResponseBody
    public void   updatePwd(CmsUser cmsUser){
        userService.updatePwd(cmsUser);
    }

    @RequestMapping("queryCmsUserName")
    @ResponseBody
    public Integer  queryCmsUserName(CmsUser cmsUser){
        CmsUser user=userService.queryForgetPwd(cmsUser.getCmsUserName());
        if(user!=null){
            return 1;
        }else{
            return 2;
        }
    }
}
