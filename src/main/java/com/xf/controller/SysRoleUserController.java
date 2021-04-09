package com.xf.controller;


import com.xf.entity.SysRoleUser;
import com.xf.entity.SysUser;
import com.xf.service.ISysRoleUserService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author administrator
 * @since 2021-04-09
 */
@RestController
@RequestMapping("/sys-role-user")
public class SysRoleUserController {

    @Resource
    private ISysRoleUserService sysRoleUserService;

    /**
     * 根据ID获取用户角色关系数据
     * @Param userId  ID
     */
    @RequestMapping(value = "/getInfo",method = RequestMethod.POST)
    public SysRoleUser getInfo(Long id) {
        SysRoleUser roleUser = sysRoleUserService.getById(id);
        return roleUser;
    }

}
