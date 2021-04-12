package com.xf.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 操作权限表
 * </p>
 *
 * @author administrator
 * @since 2021-04-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class AuthPermission extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("Id")
    private String Id;

    /**
     * 权限路径
     */
    @TableField("PermissionPath")
    private String PermissionPath;

    /**
     * 权限名称
     */
    @TableField("PermissionName")
    private String PermissionName;

    /**
     * 所属菜单主键
     */
    @TableField("MenuId")
    private String MenuId;

    /**
     * 创建时间
     */
    @TableField("CreateDateTime")
    private LocalDateTime CreateDateTime;

    /**
     * 记录更新时间（记录创建时与记录创建时间同值）
     */
    @TableField("UpdateDateTime")
    private LocalDateTime UpdateDateTime;


}
