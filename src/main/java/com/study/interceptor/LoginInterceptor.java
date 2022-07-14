package com.study.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * 定义一个拦截器，
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 检测全局session 对象中是否有 uid等数据，如果有则放行，如果没有则重定向到 login.html
     * @param request 请求对象
     * @param response 响应对象
     * @param handler 处理器（url+controller的映射）
     * @return 如果返回值为true，表示放行当前的请求，如果返回值为false，那么对当前请求进行拦截
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session= request.getSession(false);
        if(session==null || session.getAttribute("uid")==null){ // 说明没有登陆系统，那么重定向到index.html
            System.out.println("进入拦截器! 重定向到登陆页面!");
             response.sendRedirect("/store/web/login.html");
             return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
