package com.xf.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xf.entity.UserInfoEntity;
import com.xf.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @Description UserInfoController
 */
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 根据ID获取用户信息
     *
     * @Param userId  用户ID
     * @Return UserInfoEntity 用户实体
     */
    @RequestMapping("/getInfo")
    public UserInfoEntity getInfo(String userId) {
        UserInfoEntity userInfoEntity = userInfoService.getById(userId);
        return userInfoEntity;
    }

    /**
     * 查询全部信息
     *
     * @Param userId  用户ID
     * @Return List<UserInfoEntity> 用户实体集合
     */
    @RequestMapping("/getList")
    public List<UserInfoEntity> getList() {
        List<UserInfoEntity> userInfoEntityList = userInfoService.list();
        return userInfoEntityList;
    }

    /**
     * 查询全部信息
     *
     * @Param userId  用户ID
     * @Return List<UserInfoEntity> 用户实体集合
     */
    @RequestMapping("/getUserInfoList")
    public List<UserInfoEntity> getUserInfoList() {
//        List<UserInfoEntity> userInfoEntityList = userInfoService.getUserInfoList();
        List<UserInfoEntity> userInfoEntityList = userInfoService.getUserInfoList123();
        return userInfoEntityList;
    }

    /**
     * 分页查询全部数据
     *
     * @Return IPage<UserInfoEntity> 分页数据
     */
    @RequestMapping("/getInfoListPage")
    public IPage<UserInfoEntity> getInfoListPage() {
        //需要在Config配置类中配置分页插件
        IPage<UserInfoEntity> page = new Page<>();
        page.setCurrent(1); //当前页
        page.setSize(2);    //每页条数
        page = userInfoService.page(page);
        System.out.println(1234);
        return page;
    }

    /**
     * 根据指定字段查询用户信息集合
     *
     * @Return Collection<UserInfoEntity> 用户实体集合
     */
    @RequestMapping("/getListMap")
    public Collection<UserInfoEntity> getListMap() {
        Map<String, Object> map = new HashMap<>();
        //kay是字段名 value是字段值
        map.put("age", 20);
        Collection<UserInfoEntity> userInfoEntityList = userInfoService.listByMap(map);
        return userInfoEntityList;
    }

    /**
     * 新增用户信息
     */
    @RequestMapping("/saveInfo")
    public void saveInfo() {
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setName("小龙");
        userInfoEntity.setSkill("JAVA");
        userInfoEntity.setAge(18);
        userInfoEntity.setFraction(59L);
        userInfoEntity.setEvaluate("该学生是一个在改BUG的码农");
        userInfoService.save(userInfoEntity);
    }

    /**
     * 批量新增用户信息
     */
    @RequestMapping("/saveInfoList")
    public void saveInfoList() {
        //创建对象
        UserInfoEntity sans = new UserInfoEntity();
        sans.setName("Sans");
        sans.setSkill("睡觉");
        sans.setAge(18);
        sans.setFraction(60L);
        sans.setEvaluate("Sans是一个爱睡觉,并且身材较矮骨骼巨大的骷髅小胖子");
        UserInfoEntity papyrus = new UserInfoEntity();
        papyrus.setName("papyrus");
        papyrus.setSkill("JAVA");
        papyrus.setAge(18);
        papyrus.setFraction(58L);
        papyrus.setEvaluate("Papyrus是一个讲话大声、个性张扬的骷髅，给人自信、有魅力的骷髅小瘦子");
        //批量保存
        List<UserInfoEntity> list = new ArrayList<>();
        list.add(sans);
        list.add(papyrus);
        userInfoService.saveBatch(list);
    }

    /**
     * 更新用户信息
     */
    @RequestMapping("/updateInfo")
    public void updateInfo() {
        //根据实体中的ID去更新,其他字段如果值为null则不会更新该字段,参考yml配置文件
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setId(1L);
        userInfoEntity.setAge(19);
        userInfoService.updateById(userInfoEntity);
    }

    /**
     * 新增或者更新用户信息
     */
    @RequestMapping("/saveOrUpdateInfo")
    public void saveOrUpdate() {
        //传入的实体类userInfoEntity中ID为null就会新增(ID自增)
        //实体类ID值存在,如果数据库存在ID就会更新,如果不存在就会新增
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setId(1L);
        userInfoEntity.setAge(20);
        userInfoService.saveOrUpdate(userInfoEntity);
    }

    /**
     * 根据ID删除用户信息
     */
    @RequestMapping("/deleteInfo")
    public void deleteInfo(String userId) {
        userInfoService.removeById(userId);
    }

    /**
     * 根据ID批量删除用户信息
     */
    @RequestMapping("/deleteInfoList")
    public void deleteInfoList() {
        List<String> userIdlist = new ArrayList<>();
        userIdlist.add("12");
        userIdlist.add("13");
        userInfoService.removeByIds(userIdlist);
    }

    /**
     * 根据指定字段删除用户信息
     */
    @RequestMapping("/deleteInfoMap")
    public void deleteInfoMap() {
        //kay是字段名 value是字段值
        Map<String, Object> map = new HashMap<>();
        map.put("skill", "删除");
        map.put("fraction", 10L);
        userInfoService.removeByMap(map);
    }

    @RequestMapping("/getInfoListPlus")
    public Map<String, Object> getInfoListPage1() {
        //初始化返回类
        Map<String, Object> result = new HashMap<>();
        //查询年龄等于18岁的学生
        //等价SQL: SELECT id,name,age,skill,evaluate,fraction FROM user_info WHERE age = 18
        QueryWrapper<UserInfoEntity> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.lambda().eq(UserInfoEntity::getAge, 18);
        List<UserInfoEntity> userInfoEntityList1 = userInfoService.list(queryWrapper1);
        result.put("studentAge18", userInfoEntityList1);
        //查询年龄大于5岁的学生且小于等于18岁的学生
        //等价SQL: SELECT id,name,age,skill,evaluate,fraction FROM user_info WHERE age > 5 AND age <= 18
        QueryWrapper<UserInfoEntity> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.lambda().gt(UserInfoEntity::getAge, 5);
        queryWrapper2.lambda().le(UserInfoEntity::getAge, 18);
        List<UserInfoEntity> userInfoEntityList2 = userInfoService.list(queryWrapper2);
        result.put("studentAge5", userInfoEntityList2);
        //模糊查询技能字段带有"画"的数据,并按照年龄降序
        //等价SQL: SELECT id,name,age,skill,evaluate,fraction FROM user_info WHERE skill LIKE '%画%' ORDER BY age DESC
        QueryWrapper<UserInfoEntity> queryWrapper3 = new QueryWrapper<>();
        queryWrapper3.lambda().like(UserInfoEntity::getSkill, "画");
        queryWrapper3.lambda().orderByDesc(UserInfoEntity::getAge);
        List<UserInfoEntity> userInfoEntityList3 = userInfoService.list(queryWrapper3);
        result.put("studentAgeSkill", userInfoEntityList3);
        //模糊查询名字带有"小"或者年龄大于18的学生
        //等价SQL: SELECT id,name,age,skill,evaluate,fraction FROM user_info WHERE name LIKE '%小%' OR age > 18
        QueryWrapper<UserInfoEntity> queryWrapper4 = new QueryWrapper<>();
        queryWrapper4.lambda().like(UserInfoEntity::getName, "小");
        queryWrapper4.lambda().or().gt(UserInfoEntity::getAge, 18);
        List<UserInfoEntity> userInfoEntityList4 = userInfoService.list(queryWrapper4);
        result.put("studentOr", userInfoEntityList4);
        //查询评价不为null的学生,并且分页
        //等价SQL: SELECT id,name,age,skill,evaluate,fraction FROM user_info WHERE evaluate IS NOT NULL LIMIT 0,5
        IPage<UserInfoEntity> page = new Page<>();
        page.setCurrent(1);
        page.setSize(5);
        QueryWrapper<UserInfoEntity> queryWrapper5 = new QueryWrapper<>();
        queryWrapper5.lambda().isNotNull(UserInfoEntity::getEvaluate);
        page = userInfoService.page(page, queryWrapper5);
        result.put("studentPage", page);
        return result;
    }

}
