package com.xf.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xf.entity.UserInfoEntity;

import java.util.List;

/**
 * @Description 用户业务接口
 */
public interface UserInfoService extends IService<UserInfoEntity> {

    /**
     * 获取所有用户信息
     * @return
     */
    List<UserInfoEntity> getUserInfoList();

    /**
     * 获取所有用户信息
     * @return
     */
    List<UserInfoEntity> getUserInfoList123();

}