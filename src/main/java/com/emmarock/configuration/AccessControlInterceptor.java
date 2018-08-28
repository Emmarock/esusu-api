package com.emmarock.configuration;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by babajide.apata on 2/12/2017.
 */
public class AccessControlInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
         try{
             HandlerMethod method = (HandlerMethod) handler;
             response.setHeader("Access-Control-Allow-Origin","*");
         }catch (Exception ex){
            return false;
         }
         return true;
    }

    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
        super.postHandle(request,response,handler,modelAndView);
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires",0);
    }
}
