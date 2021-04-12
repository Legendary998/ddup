package com.xf.service.impl;

import com.xf.entity.AuthUserrole;
import com.xf.mapper.AuthUserroleMapper;
import com.xf.service.IAuthUserroleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
