package com.xf.mapper;

import com.xf.entity.AuthUser;
import com.xf.entity.AuthUserauthorization;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xf.entity.UserInfoEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 登陆用户授权 Mapper 接口
 * </p>
 *
 * @author administrator
 * @since 2021-04-12
 */
public interface AuthUserauthorizationMapper extends BaseMapper<AuthUserauthorization> {

    @Select("select B.* FROM Auth_User A,Auth_UserAuthorization B " +
            " WHERE A.id=B.userId and (UPPER(A.mobile)=#{param} or UPPER(A.email)=#{param} " +
            " or UPPER(A.username)=#{param}) ")
    AuthUserauthorization getObject(String param);

}
