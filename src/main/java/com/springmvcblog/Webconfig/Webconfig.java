package com.springmvcblog.Webconfig;

import com.springmvcblog.Interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class Webconfig extends WebMvcConfigurerAdapter{
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        System.out.println("Hello There!");
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/admin/**");
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/blogs/create");
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/blogs/{id}/edit");
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/profile/**");
    }

}