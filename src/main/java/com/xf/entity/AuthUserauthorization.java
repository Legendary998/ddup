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
 * 登陆用户授权
 * </p>
 *
 * @author administrator
 * @since 2021-04-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class AuthUserauthorization extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * 登陆用户表主键
     */
    @TableId("UserId")
    private String UserId;

    /**
     * 登陆密码（明文）
     */
    @TableField("Password")
    private String Password;

    /**
     * 登陆密码（加密）
     */
    @TableField("PasswordEncryption")
    private String PasswordEncryption;

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


}
