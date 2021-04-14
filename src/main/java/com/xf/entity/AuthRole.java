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
 * 角色
 * </p>
 *
 * @author administrator
 * @since 2021-04-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class AuthRole extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * 角色编码（主键）
     */
    @TableId("Id")
    private String Id;

    @TableField("Code")
    private String Code;

    /**
     * 角色名称
     */
    @TableField("Name")
    private String Name;

    /**
     * 启用状态（1=启用 0=禁用 默认1）
     */
    @TableField("Enabled")
    private Integer Enabled;

    /**
     * 描述
     */
    @TableField("Description")
    private String Description;

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
    private String menuIds;

    @TableField(exist = false)
    private String[] menuIdArray;

    @TableField(exist = false)
    private String permissionIds;

    @TableField(exist = false)
    private String[] permissionIdArray;

    @TableField(exist = false)
    private Set<AuthPermission> permissions;

}
