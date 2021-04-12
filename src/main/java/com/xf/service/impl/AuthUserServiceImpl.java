package com.xf.service.impl;

import com.xf.entity.AuthUser;
import com.xf.mapper.AuthUserMapper;
import com.xf.service.IAuthUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 登陆用户 服务实现类
 * </p>
 *
 * @author administrator
 * @since 2021-04-12
 */
@Service
public class AuthUserServiceImpl extends ServiceImpl<AuthUserMapper, AuthUser> implements IAuthUserService {

}
