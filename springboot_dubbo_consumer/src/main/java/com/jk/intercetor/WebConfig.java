package com.jk.intercetor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @version 1.0
 * @ClassName WebConfig
 * @Description TODO
 * @Author rhy
 * @Date 2019/11/26 19:50
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("进来啦拦截器大哥哥");
        registry.addInterceptor(loginInterceptor).addPathPatterns("/toCart","/collect/tocollect","/myOrder","/toGetorder");
    }
}
