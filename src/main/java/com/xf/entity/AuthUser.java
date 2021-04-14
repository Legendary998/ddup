package com.xf.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 登陆用户
 * </p>
 *
 * @author administrator
 * @since 2021-04-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class AuthUser extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("Id")
    private String Id;

    @TableField("OrganizationId")
    private String OrganizationId;

    @TableField("OrganizationCode")
    private String OrganizationCode;

    @TableField("OrganizationName")
    private String OrganizationName;

    /**
     * 用户名
     */
    @TableField("Username")
    private String Username;

    @TableField("Realname")
    private String Realname;

    @TableField("IDNumber")
    private String IDNumber;

    @TableField("EmployeeID")
    private String EmployeeID;

    @TableField("Telephone")
    private String Telephone;

    /**
     * 绑定的手机号
     */
    @TableField("Mobile")
    private String Mobile;

    /**
     * 绑定的邮箱
     */
    @TableField("Email")
    private String Email;

    /**
     * 同时登陆数
     */
    @TableField("Logined")
    private Integer Logined;

    /**
     * 启用状态（1=启用 0=禁用 默认1）
     */
    @TableField("Enabled")
    private Integer Enabled;

    /**
     * 最后登录Ip
     */
    @TableField("ThisLoginIp")
    private String ThisLoginIp;

    /**
     * 最后登录时间
     */
    @TableField("ThisLoginDateTime")
    private LocalDateTime ThisLoginDateTime;

    /**
     * 上次登录Ip
     */
    @TableField("LastLoginIp")
    private String LastLoginIp;

    /**
     * 上次登录时间
     */
    @TableField("LastLoginDateTime")
    private LocalDateTime LastLoginDateTime;

    /**
     * 记录创建时间
     */
    @TableField("CreateDateTime")
    private LocalDateTime CreateDateTime;

    /**
     * 记录更新时间（记录创建时与记录创建时间同值）
     */
    @TableField("UpdateDateTime")
    private LocalDateTime UpdateDateTime;

    @TableField(exist = false)
    private List<String> roleCodeList;

    @TableField(exist = false)
    private Set<AuthRole> roles;

    @TableField(exist = false)
    private String[] roleIdArray;

    @TableField(exist = false)
    private String roleIds;

    @TableField(exist = false)
    private String roleCodes;

    @TableField(exist = false)
    private String roleNames;

}
