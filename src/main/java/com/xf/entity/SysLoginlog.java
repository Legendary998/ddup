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
 * 记录用户登陆基本信息（如浏览器信息、将计算机信息等）
 * </p>
 *
 * @author administrator
 * @since 2021-04-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysLoginlog extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("Id")
    private String Id;

    /**
     * 操作账号
     */
    @TableField("LoginName")
    private String LoginName;

    /**
     * sessionid
     */
    @TableField("SessionId")
    private String SessionId;

    /**
     * 登陆IP
     */
    @TableField("LoginIp")
    private String LoginIp;

    /**
     * 浏览器信息
     */
    @TableField("ClientInfo")
    private String ClientInfo;

    /**
     * 登陆日期及时间
     */
    @TableField("LoginDateTime")
    private LocalDateTime LoginDateTime;

    /**
     * 登出日期及时间
     */
    @TableField("LogoutDateTime")
    private LocalDateTime LogoutDateTime;

    /**
     * 创建日期及时间
     */
    @TableField("CreateDateTime")
    private LocalDateTime CreateDateTime;


}
