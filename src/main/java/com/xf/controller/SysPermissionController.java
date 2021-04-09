package com.xf.controller;


import com.xf.entity.SysPermission;
import com.xf.service.ISysPermissionService;
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
@RequestMapping("/sys-permission")
public class SysPermissionController {

    @Resource
    private ISysPermissionService sysPermissionService;

    /**
     * 根据ID获取用户信息
     *
     * @Param userId  用户ID
     */
    @RequestMapping(value = "/getInfo", method = RequestMethod.POST)
    public SysPermission getInfo(String userId) {
        SysPermission sysPermission = sysPermissionService.getById(userId);
        return sysPermission;
    }

}
