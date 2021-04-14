package com.xf.web.shirRealm;

import com.xf.entity.AuthPermission;
import com.xf.entity.AuthRole;
import com.xf.entity.AuthUser;
import com.xf.entity.AuthUserauthorization;
import com.xf.service.IAuthRoleService;
import com.xf.service.IAuthUserService;
import com.xf.service.IAuthUserauthorizationService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

public class ShirRealm extends AuthorizingRealm {

    @Resource
    private IAuthUserService userService;

    @Resource
    private IAuthUserauthorizationService userauthorizationService;

    /**
     * 权限配置
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("MyShirRealm->doGetAuthorizationInfo");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        AuthUser userInfo = (AuthUser) principals.getPrimaryPrincipal();
        for (AuthRole role : userInfo.getRoles()) {
            //添加角色
            authorizationInfo.addRole(role.getName());
            for (AuthPermission p : role.getPermissions()) {
                authorizationInfo.addStringPermission(p.getPermissionName());
            }
        }
        return authorizationInfo;
    }

    /**
     * 主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        System.out.println("MyShirRealm->doGetAuthenticationInfo");
        //用户名
        String username = (String) token.getPrincipal();
        System.out.println("username:" + username);

        //获取用户信息
        AuthUser userInfo = userService.getUserByUserName(username);

        if (userInfo == null) {
            throw new UnknownAccountException();//没找到帐号
        }
        AuthUserauthorization userAuthorization = userauthorizationService.getById(userInfo.getId());
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username,
                userAuthorization.getPassword(), getName());
        return authenticationInfo;
    }
}