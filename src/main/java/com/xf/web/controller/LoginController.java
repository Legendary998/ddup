package com.xf.web.controller;

import java.io.IOException;
import java.time.ZoneId;
import java.util.Date;
import javax.annotation.Resource;
import javax.servlet.http.Cookie;

import com.xf.entity.AuthUser;
import com.xf.entity.SysLoginlog;
import com.xf.service.IAuthUserService;
import com.xf.service.IAuthUserauthorizationService;
import com.xf.service.ISysLoginlogService;
import com.xf.util.ResultData;
import com.xf.util.StringTools;
import com.xf.util.UUIDTools;
import com.xf.web.base.BaseController;
import com.xf.web.common.SessionKey;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 登录
 *
 * @author administrator
 * @since 2021年4月13日
 */
@Controller
public class LoginController extends BaseController {

    @Resource
    private IAuthUserauthorizationService userauthorizationService;

    @Resource
    private IAuthUserService userService;

    @Resource
    private ISysLoginlogService sysLoginlogService;

    /**
     * 用户登录
     *
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultData login(String loggingName, String password, String captcha) throws IOException {
        String flag = request.getParameter("flag");
        ResultData data = new ResultData();
//        if (StringTools.isNullOrEmpty(captcha)) {
//            data.setMessage("请输入验证码！");
//            return data;
//        }
        if (StringTools.isNullOrEmpty(loggingName)) {
            data.setMessage("请输入验用户名！");
            return data;
        }
        if (StringTools.isNullOrEmpty(password)) {
            data.setMessage("请输入密码！");
            return data;
        }
        try {
            data = userauthorizationService.login(loggingName, password);
            if (data.getState() == 10000) {
                AuthUser logingUser = (AuthUser) data.getObj();
                Date loginDateTime = new Date();
                AuthUser loginedUser = super.getCurrentLoginUser();// getSessionObj(SessionKey.SESSION_USER);
                String logingLogId = getSessionString(SessionKey.SESSION_LOGINID);

                if (StringTools.isNullOrEmpty(logingLogId)) {// 第一次登录
                    logingUser.setLogined(logingUser.getLogined() + 1);
                } else {// 已经登录
                    // AuthUserEntity loginedUser = (AuthUserEntity)
                    // sessionUser;
                    SysLoginlog loginedLog = sysLoginlogService.getById(logingLogId);
                    if (!loginedUser.getUsername().equalsIgnoreCase(logingUser.getUsername())) {// 不同用户
                        loginedUser = userService.getById(loginedUser.getId());
                        if (loginedUser != null) {
                            loginedUser.setLogined(loginedUser.getLogined() - 1);
                            userService.saveOrUpdate(loginedUser);
                        }
                        // 更新登陆用户
                        logingUser.setLogined(logingUser.getLogined() + 1);
                    }
                    if (loginedLog != null) {// 更新登出时间
                        loginedLog.setLogoutDateTime(loginDateTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
                        sysLoginlogService.saveOrUpdate(loginedLog);
                    }
                }
                // 更新登陆用户
                logingUser.setLastLoginDateTime(logingUser.getThisLoginDateTime());
                logingUser.setThisLoginDateTime(loginDateTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
                logingUser.setLastLoginIp(logingUser.getThisLoginIp());
                logingUser.setThisLoginIp(request.getRemoteAddr());
                // 记录登陆日志
                logingLogId = UUIDTools.randomUUID();
                SysLoginlog loggingLog = new SysLoginlog();
                loggingLog.setId(logingLogId);
                loggingLog.setLoginName(logingUser.getUsername());
                loggingLog.setSessionId(session.getId());
                loggingLog.setLoginIp(request.getRemoteAddr());
                loggingLog.setClientInfo(String
                        .format("[Scheme:%s] [Server Name:%s] [Server Port:%s] [Protocol:%s] [Remote Addr:%s] [Remote Host:%s] [Character Encoding:%s] [Content Length:%s] [Content Type:%s] [Auth Type:%s] [HTTP Method:%s] [Path Info:%s] [Path Trans:%s] [Query String:%s] [Remote User:%s] [Request URI:%s] [Servlet Path:%s] [Accept:%s] [Host:%s] [Referer:%s] [Accept-Language:%s] [Accept-Encoding:%s] [User-Agent:%s] [Connection:%s] [Cookie:%s] [Session Id:%s]",
                                request.getScheme(),
                                request.getServerName(),
                                request.getServerPort(),
                                request.getProtocol(),
                                request.getRemoteAddr(),
                                request.getRemoteHost(),
                                request.getCharacterEncoding(),
                                request.getContentLength(),
                                request.getContentType(),
                                request.getAuthType(),
                                request.getMethod(),
                                request.getPathInfo(),
                                request.getPathTranslated(),
                                request.getQueryString(),
                                request.getRemoteUser(),
                                request.getRequestURI(),
                                request.getServletPath(),
                                request.getHeader("Accept"),
                                request.getHeader("Host"),
                                request.getHeader("Referer"),
                                request.getHeader("Accept-Language"),
                                request.getHeader("Accept-Encoding"),
                                request.getHeader("User-Agent"),
                                request.getHeader("Connection"),
                                request.getHeader("Cookie"),
                                request.getRequestedSessionId()));
                loggingLog.setLoginDateTime(logingUser.getThisLoginDateTime());
                loggingLog.setCreateDateTime(logingUser.getThisLoginDateTime());
                userService.saveOrUpdate(loginedUser);
                sysLoginlogService.saveOrUpdate(loggingLog);

                setSession(SessionKey.SESSION_LOGINID, logingLogId);
                setSession(SessionKey.SESSION_USER, logingUser);

                //登陆成功如果选择的记住用户名
                if (flag != null && flag.equals("1")) {
                    Cookie cookie = new Cookie("cookie_user", loggingName + "," + null);
                    cookie.setMaxAge(60 * 60 * 24 * 30);
                    response.addCookie(cookie);
                }/*else{
						Cookie cookie = new Cookie("cookie_user", loginname+","+null);
						cookie.setMaxAge(60*60*24*30);
						cookie.setPath("/");
						response.addCookie(cookie);
					}*/

                toIndex(data);
            } else if (data.getState() == 20000) {
                data.setMessage("用户名不存在");
            } else if (data.getState() == 30000) {
                data.setMessage("登录密码错误");
            } else if (data.getState() == 30001) {
                data.setMessage("登录密码未设置");
            } else if (data.getState() == 40000) {
                data.setMessage("该用户已被禁用，请联系管理员");
            } else if (data.getState() == 50000) {
                data.setMessage("该用户所属角色已被禁用，请联系管理员");
            }
        } catch (Throwable e) {
            data = new ResultData();
            data.setMessage(e.getMessage());
        }
        return data;
    }

    public String toIndex(ResultData data) {
        ModelMap map = new ModelMap();
        AuthUser user = (AuthUser) data.getObj();
        map.addAttribute("name", user.getRoleNames());
        return "thymeleaf/index";
    }
}
