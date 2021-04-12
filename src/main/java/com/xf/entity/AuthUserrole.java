package com.xf.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户与角色关联表
 * </p>
 *
 * @author administrator
 * @since 2021-04-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class AuthUserrole extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("Id")
    private String Id;

    /**
     * 用户主键
     */
    @TableField("UserId")
    private String UserId;

    /**
     * 角色主键
     */
    @TableField("RoleId")
    private String RoleId;


}
