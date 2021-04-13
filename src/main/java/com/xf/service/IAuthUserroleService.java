package com.xf.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xf.entity.AuthUser;
import com.xf.entity.AuthUserrole;

import java.util.List;

/**
 * <p>
 * 用户与角色关联表 服务类
 * </p>
 *
 * @author administrator
 * @since 2021-04-12
 */
public interface IAuthUserroleService extends IService<AuthUserrole> {

    List<AuthUser> getUserListByRoleId(Integer roleId);

    List<String> getUserIdList(String userId);

}
