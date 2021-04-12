package com.xf.web.base;

import com.xf.entity.AuthUser;
import com.xf.util.StringTools;
import com.xf.web.common.SessionKey;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BaseController {
    protected HttpServletRequest request;

    protected HttpServletResponse response;

    protected HttpSession session;

    protected ServletContext application;

    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.session = request.getSession();
        this.application = this.session.getServletContext();
    }

    protected String getSessionString(String key) {
        Object obj = session.getAttribute(key);
        return obj != null ? obj.toString() : null;
    }

    protected Object getSessionObject(String key) {
        return session.getAttribute(key);
    }

    protected void setSession(String key, Object value) {
        session.setAttribute(key, value);
    }

    protected void setRequest(String key, Object value) {
        request.setAttribute(key, value);
    }

    protected String getParameter(String key) {
        return request.getParameter(key);
    }

    protected int getPageIndex() {
        String v = getParameter("page");
        if (!StringTools.isNullOrEmpty(v)) {
            return Integer.parseInt(v);
        }
        return 0;
    }

    protected int getPageSize() {
        String v = getParameter("rows");
        if (!StringTools.isNullOrEmpty(v)) {
            return Integer.parseInt(v);
        }
        return 0;
    }

    /**
     * 获取当前登录用户
     *
     * @return
     */
    public AuthUser getCurrentLoginUser() {
        Object obj = getSessionObject(SessionKey.SESSION_USER);
        if (obj != null) {
            AuthUser en = (AuthUser) obj;
            return en;
        }
        return null;
    }
}
