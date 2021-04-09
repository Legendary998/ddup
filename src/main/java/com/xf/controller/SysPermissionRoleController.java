package com.xf.controller;


import com.xf.entity.SysPermissionRole;
import com.xf.service.ISysPermissionRoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author administrator
 * @since 2021-04-09
 */
@RestController
@RequestMapping("/sys-permission-role")
public class SysPermissionRoleController {

    @Resource
    private ISysPermissionRoleService sysPermissionRoleService;

    /**
     * 根据ID获取用户信息
     *
     * @Param userId  用户ID
     */
    @RequestMapping(value = "/getInfo", method = RequestMethod.POST)
    public SysPermissionRole getInfo(String userId) {
        SysPermissionRole sysPermissionRole = sysPermissionRoleService.getById(userId);
        return sysPermissionRole;
    }

}
