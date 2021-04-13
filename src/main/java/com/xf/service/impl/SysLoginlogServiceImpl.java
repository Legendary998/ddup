package com.xf.service.impl;

import com.xf.entity.SysLoginlog;
import com.xf.mapper.SysLoginlogMapper;
import com.xf.service.ISysLoginlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 记录用户登陆基本信息（如浏览器信息、将计算机信息等） 服务实现类
 * </p>
 *
 * @author administrator
 * @since 2021-04-12
 */
@Service
public class SysLoginlogServiceImpl extends ServiceImpl<SysLoginlogMapper, SysLoginlog> implements ISysLoginlogService {

}
