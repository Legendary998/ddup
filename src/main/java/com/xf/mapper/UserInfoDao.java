package com.xf.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xf.entity.UserInfoEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description 用户信息DAO
 */
//@Mapper
public interface UserInfoDao extends BaseMapper<UserInfoEntity> {

    /**
     * 获取所有用户信息
     * @return
     */
    List<UserInfoEntity> getUserInfoList();

    @Select("SELECT * FROM user_info ")
    List<UserInfoEntity> getUserInfoList123();

}