package com.xf.service.impl;

import com.xf.entity.AuthUser;
import com.xf.entity.AuthUserrole;
import com.xf.mapper.AuthUserroleMapper;
import com.xf.service.IAuthUserroleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户与角色关联表 服务实现类
 * </p>
 *
 * @author administrator
 * @since 2021-04-12
 */
@Service
public class AuthUserroleServiceImpl extends ServiceImpl<AuthUserroleMapper, AuthUserrole> implements IAuthUserroleService {

    @Resource
    AuthUserroleMapper authUserroleMapper;

    @Override
    public List<AuthUser> getUserListByRoleId(Integer roleId) {
        return authUserroleMapper.getUserListByRoleId(roleId);
    }

    @Override
    public List<String> getUserIdList(String userId) {
        return authUserroleMapper.getUserIdList(userId);
    }


}
