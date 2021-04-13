package com.xf.web.filter;

import com.xf.entity.AuthUser;
import com.xf.util.ResultData;
import com.xf.web.common.SessionKey;
import net.sf.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class CorsFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init....");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println("doFilter...");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT,OPTIONS");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Accept,Pragma,DNT,X-CustomHeader,Keep-Alive,User-Agent,X-Requested-With,X_Requested_With,If-Modified-Since,Cache-Control,Content-Type,token");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("expires", -1);
        HttpSession session = request.getSession();
        if (!request.getServletPath().equals("/login") &&
                !request.getServletPath().startsWith("/upload") &&
                !request.getServletPath().startsWith("/download") &&
                !request.getServletPath().startsWith("/ueditor") &&
                !request.getServletPath().startsWith("/services")) {

            AuthUser userInfo = (AuthUser) session.getAttribute(SessionKey.SESSION_USER);
            if (userInfo == null) {
                session.invalidate();
                response.setContentType("text/html;charset=utf-8");
                response.setCharacterEncoding("UTF-8");
                PrintWriter out = response.getWriter();
                ResultData resultInfo = new ResultData();
                resultInfo.setState(0105);
                resultInfo.setMessage("请先登录！");
                out.println(JSONObject.fromObject(resultInfo).toString());
                out.flush();
                out.close();
            }
        }
        ParameterRequestWrapper requestWrapper = new ParameterRequestWrapper(request);
        chain.doFilter(requestWrapper, response);
    }

    @Override
    public void destroy() {
        System.out.println("destroy...");
    }
}
