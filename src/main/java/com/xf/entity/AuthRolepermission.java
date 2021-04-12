package com.xf.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色和操作权限关联表
 * </p>
 *
 * @author administrator
 * @since 2021-04-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class AuthRolepermission extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("Id")
    private String Id;

    /**
     * 角色主键
     */
    @TableField("RoleId")
    private String RoleId;

    /**
     * 操作权限主键
     */
    @TableField("PermissionId")
    private String PermissionId;


}
