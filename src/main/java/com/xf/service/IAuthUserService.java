package com.xf.service;

import com.xf.entity.AuthUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 登陆用户 服务类
 * </p>
 *
 * @author administrator
 * @since 2021-04-12
 */
public interface IAuthUserService extends IService<AuthUser> {

    AuthUser getUserByUserName(String username);

}
