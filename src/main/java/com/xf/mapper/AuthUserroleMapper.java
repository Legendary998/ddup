package com.xf.mapper;

import com.xf.entity.AuthUser;
import com.xf.entity.AuthUserrole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 用户与角色关联表 Mapper 接口
 * </p>
 *
 * @author administrator
 * @since 2021-04-12
 */
public interface AuthUserroleMapper extends BaseMapper<AuthUserrole> {

    @Select("select * from auth_userrole userRole " +
            "left join auth_user authUser on userRole.UserId = authUser.id where userRole.RoleId = #{roleId} ")
    List<AuthUser> getUserListByRoleId(Integer roleId);

}
