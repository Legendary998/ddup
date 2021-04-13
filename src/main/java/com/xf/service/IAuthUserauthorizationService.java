package com.xf.service;

import com.xf.entity.AuthUserauthorization;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xf.util.ResultData;

import java.security.NoSuchAlgorithmException;

/**
 * <p>
 * 登陆用户授权 服务类
 * </p>
 *
 * @author administrator
 * @since 2021-04-12
 */
public interface IAuthUserauthorizationService extends IService<AuthUserauthorization> {

    /**
     * 登陆验证
     * @param loginname 登陆名
     * @param password 登陆密码（明文）
     * @return ResultData.state 10000=成功 20000=用户名不存在 30000=密码错误 30001=密码未设置 40000=用户被禁用 50000=角色被禁用
     * @throws NoSuchAlgorithmException
     */
    ResultData login(String loginname, String password) throws Throwable;

}
