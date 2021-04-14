package com.xf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xf.entity.AuthRole;
import com.xf.entity.AuthUser;
import com.xf.entity.AuthUserauthorization;
import com.xf.mapper.AuthRoleMapper;
import com.xf.mapper.AuthUserMapper;
import com.xf.mapper.AuthUserauthorizationMapper;
import com.xf.mapper.AuthUserroleMapper;
import com.xf.service.IAuthRoleService;
import com.xf.service.IAuthUserauthorizationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xf.util.MD5Tools;
import com.xf.util.ResultData;
import com.xf.util.StringTools;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 登陆用户授权 服务实现类
 * </p>
 *
 * @author administrator
 * @since 2021-04-12
 */
@Service
public class AuthUserauthorizationServiceImpl extends ServiceImpl<AuthUserauthorizationMapper, AuthUserauthorization> implements IAuthUserauthorizationService {

    @Resource
    private AuthUserauthorizationMapper userauthorizationMapper;

    @Resource
    private AuthRoleMapper roleDao;

    @Resource
    private AuthUserroleMapper userroleMapper;

    @Resource
    private IAuthRoleService authRoleService;

    @Resource
    private AuthUserMapper userMapper;

    /**
     * 登陆验证
     * @param loginname 登陆名
     * @param password 登陆密码（明文）
     * @return ResultData.state 10000=成功 20000=登陆账号不存在 30000=密码错误 30001=密码未设置 40000=用户被禁用 50000=角色被禁用
     */
    public ResultData login(String loginname, String password) throws Throwable {
        ResultData rd = new ResultData();
        AuthUserauthorization obj = userauthorizationMapper.getObject(loginname);
        if(obj != null) {
            AuthUser userEntity = userMapper.selectById(obj.getUserId());
            if(StringTools.isNullOrEmpty(obj.getPassword())){//密码为空或未设置
                rd.setState(30001);
            }else if (!MD5Tools.check(password, obj.getPasswordEncryption())) {//密码不匹配
                rd.setState(30000);
            } else if (userEntity.getEnabled() != 1) {//账号禁用
                rd.setState(40000);
            } else {
                List<String> list = userroleMapper.getUserIdList(userEntity.getId());
                if (list.size() > 0) {
                    List<String> roleCodeList = new ArrayList<String>();
                    List<String> idList = new ArrayList<String>();
                    StringBuffer ids = new StringBuffer();
                    StringBuffer codes = new StringBuffer();
                    StringBuffer names = new StringBuffer();
                    List<AuthRole> roleList = (List<AuthRole>) authRoleService.listByIds(list);

                    for (AuthRole item : roleList) {
                        if(item.getEnabled() == Integer.valueOf(1)) {
                            roleCodeList.add(item.getCode());
                            idList.add(item.getId());
                            ids.append(item.getId() + ",");
                            codes.append(item.getCode() + ",");
                            names.append(item.getName() + ",");
                        }
                    }
                    Set<AuthRole> roles = new HashSet<AuthRole>(roleList);
                    userEntity.setRoles(roles);
                    userEntity.setRoleCodeList(roleCodeList);
                    userEntity.setRoleIdArray(idList.toArray(new String[idList.size()]));
                    if(ids.toString().length() > 0) {
                        userEntity.setRoleIds(ids.toString().substring(0, ids.toString().length() - 1 ));
                    }
                    if(codes.toString().length() > 0) {
                        userEntity.setRoleCodes(codes.toString().substring(0, codes.toString().length() - 1 ));
                    }
                    if(ids.toString().length() > 0) {
                        userEntity.setRoleNames(names.toString().substring(0, names.toString().length() - 1 ));
                    }
                    rd.setObj(userEntity);
                    rd.setState(10000);
                } else {//角色禁用
                    rd.setState(50000);
                }
            }
        } else {//账号不存在
            rd.setState(20000);
        }
        return rd;
    }
}
