package com.xf.service.impl;

import com.xf.entity.AuthRolepermission;
import com.xf.mapper.AuthRolepermissionMapper;
import com.xf.service.IAuthRolepermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色和操作权限关联表 服务实现类
 * </p>
 *
 * @author administrator
 * @since 2021-04-12
 */
@Service
public class AuthRolepermissionServiceImpl extends ServiceImpl<AuthRolepermissionMapper, AuthRolepermission> implements IAuthRolepermissionService {

}
