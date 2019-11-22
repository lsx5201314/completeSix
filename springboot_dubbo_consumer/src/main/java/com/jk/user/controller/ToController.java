package com.jk.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("to")
public class ToController {

    /** @Author 原国庆
     * @Description:登录
     * @Param: []
     * @Return: java.lang.String
     * @Create: 2019/11/19 11:07
     */
    @RequestMapping("cmsLogin")
    public String tocmsLogin(){
        return "login";
    }

    /** @Author 原国庆
     * @Description: 跳转找回密码
     * @Param: []
     * @Return: java.lang.String
     * @Create: 2019/11/19 11:07
     */
    @RequestMapping("forget")
    public String toForget(){
        return "forget";
    }

    /** @Author 原国庆
     * @Description: 跳转短信修改密码
     * @Param: []
     * @Return: java.lang.String
     * @Create: 2019/11/19 11:12
     */
    @RequestMapping("updatePwd")
    public String updatePwd(){
        return "updatePwd";
    }

    /** @Author 原国庆
     * @Description:跳转主页面
     * @Param: []
     * @Return: java.lang.String
     * @Create: 2019/11/19 17:05
     */
    @RequestMapping("index")
    public String  index(){
        return "index";
    }
}
