package com.xf.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 请求过滤器，计算方法执行多长时间
 */
public class RequestInterceptor implements HandlerInterceptor {

    private Date start;
    private Date end;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        start = new Date();
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        end = new Date();
        System.out.println(request.getRequestURI() + "------------耗时：" + (end.getTime() - start.getTime()));
    }
}

