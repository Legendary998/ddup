package com.xf.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xf.entity.UserInfoEntity;
import com.xf.mapper.UserInfoDao;
import com.xf.service.UserInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description 用户业务实现
 */
@Service
@Transactional
public class UserInfoSerivceImpl extends ServiceImpl<UserInfoDao, UserInfoEntity> implements UserInfoService {

    @Resource
    UserInfoDao userInfoDao;

    @Override
    public List<UserInfoEntity> getUserInfoList() {
        return userInfoDao.getUserInfoList();
    }

    @Override
    public List<UserInfoEntity> getUserInfoList123() {
        return userInfoDao.getUserInfoList123();
    }
}