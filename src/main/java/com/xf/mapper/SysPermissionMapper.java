package com.xf.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author administrator
 * @since 2021-04-09
 */
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

    List<SysPermission> findAll();
    List<SysPermission> findByAdminUserId(int userId);
}
