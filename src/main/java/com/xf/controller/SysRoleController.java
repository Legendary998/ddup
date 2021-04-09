package com.xf.controller;


import com.xf.entity.SysRole;
import com.xf.service.ISysRoleService;
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
@RequestMapping("/sys-role")
public class SysRoleController {

    @Resource
    private ISysRoleService sysRoleService;

    /**
     * 根据ID获取用户信息
     *
     * @Param userId  用户ID
     */
    @RequestMapping(value = "/getInfo", method = RequestMethod.POST)
    public SysRole getInfo(String userId) {
        SysRole sysRole = sysRoleService.getById(userId);
        return sysRole;
    }

}
