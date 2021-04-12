package com.xf.web.controller.role;


import com.xf.entity.AuthUser;
import com.xf.service.IAuthUserroleService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户与角色关联表 前端控制器
 * </p>
 *
 * @author administrator
 * @since 2021-04-12
 */
@RestController
@RequestMapping("/authUuserroleManner")
public class AuthUserroleController {

    @Resource
    IAuthUserroleService userroleService;

    @RequestMapping(value = "getUserByRoleId",method = RequestMethod.POST)
    public List<AuthUser> getUserByRoleId(Integer roleId) {
        return userroleService.getUserListByRoleId(roleId);
    }

}
