package com.xf.mapper;

import com.xf.entity.AuthUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xf.entity.UserInfoEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 登陆用户 Mapper 接口
 * </p>
 *
 * @author administrator
 * @since 2021-04-12
 */
public interface AuthUserMapper extends BaseMapper<AuthUser> {

    @Select("SELECT * FROM auth_user a where a.Username = #{username}")
    AuthUser getUserByUserName(String username);
}
