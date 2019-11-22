package com.jk.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("to")
public class ToController {

    @RequestMapping("cmsLogin")
    public String tocmsLogin(){
        return "login";
    }


}
