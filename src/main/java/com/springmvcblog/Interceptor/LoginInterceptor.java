package com.springmvcblog.Interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception{
        if(request.getSession().getAttribute("CURRENT_USER") != null){
            return true;
        }
        //System.out.println(request.getRequestURI());
        response.sendRedirect("/login?next=".concat(request.getRequestURI()));
        return false;

    }

}
