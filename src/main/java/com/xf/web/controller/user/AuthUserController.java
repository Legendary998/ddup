package com.xf.web.controller.user;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xf.entity.AuthUser;
import com.xf.service.IAuthUserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 登陆用户 前端控制器
 * </p>
 *
 * @author administrator
 * @since 2021-04-12
 */
@RestController
@RequestMapping("/authUserManager")
public class AuthUserController {

    @Resource
    IAuthUserService userService;

    /**
     * 根据用户ID获取信息
     *
     * @param userId
     * @return AuthUser
     */
    @RequestMapping("/getInfo/{id}")
    public AuthUser getAuthUserInfoById(@PathVariable("id") Integer userId) {
        AuthUser user = userService.getById(userId);
        return user;
    }

    /**
     * 获取所有用户信息
     *
     * @return
     */
    @RequestMapping("getAllUser")
    public List<AuthUser> getAllUser() {
        List<AuthUser> userList = userService.list();
        return userList;
    }

    /**
     * 分页查询数据
     *
     * @param current
     * @param size
     * @return
     */
    @RequestMapping(value = "getInfoListPage", method = RequestMethod.POST)
    public IPage<AuthUser> getInfoListPage(Long current, Long size) {
        IPage<AuthUser> page = new Page<AuthUser>();
        page.setCurrent(current);
        page.setSize(size);
        page = userService.page(page);
        return page;
    }

}
