package com.xf.web.controller.role;


import com.xf.entity.AuthRole;
import com.xf.service.IAuthRoleService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 角色 前端控制器
 * </p>
 *
 * @author administrator
 * @since 2021-04-12
 */
@RestController
@RequestMapping("/authRoleManager")
public class AuthRoleController {

    @Resource
    IAuthRoleService roleService;

    /**
     * 查询所有角色
     *
     * @return
     */
    @RequestMapping(value = "/getAllUserRole",method = RequestMethod.GET)
    List<AuthRole> getAll() {
        return roleService.list();
    }


}
