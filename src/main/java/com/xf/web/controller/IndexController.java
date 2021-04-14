package com.xf.web.controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import java.io.IOException;
import java.time.ZoneId;
import java.util.Date;


/**
 * 登录
 * @since 2021年4月13日
 * @author administrator
 */
@Controller
public class IndexController extends BaseController {

    /**
     * 登录页
     *
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/")
    public String login(ModelMap map)  {
        map.addAttribute("name","hello");
        return "index";
    }
}
