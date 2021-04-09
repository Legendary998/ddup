package com.xf.controller;


import com.xf.entity.SysUser;
import com.xf.service.ISysUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author astupidcoder
 * @since 2021-04-09
 */
@RestController
@RequestMapping("/sys-user")
public class SysUserController {

    @Resource
    private ISysUserService sysUserService;

    /**
     * 根据ID获取用户信息
     *
     * @Param userId  用户ID
     */
    @RequestMapping(value = "/getInfo", method = RequestMethod.POST)
    public SysUser getInfo(String userId) {
        SysUser sysUser = sysUserService.getById(userId);
        return sysUser;
    }

}
