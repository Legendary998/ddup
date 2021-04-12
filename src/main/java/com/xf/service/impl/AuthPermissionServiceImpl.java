package com.xf.service.impl;

import com.xf.entity.AuthPermission;
import com.xf.mapper.AuthPermissionMapper;
import com.xf.service.IAuthPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 操作权限表 服务实现类
 * </p>
 *
 * @author administrator
 * @since 2021-04-12
 */
@Service
public class AuthPermissionServiceImpl extends ServiceImpl<AuthPermissionMapper, AuthPermission> implements IAuthPermissionService {

}
