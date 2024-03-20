package com.bit.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import java.util.List;

@Data
@TableName("sys_user")
public class User implements Serializable, UserDetails {
//    用户编号
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    private String username;

    private  String password;

//    账户是否过期
    private boolean isAccountNonExpired=true;

//    账户是否被锁定
    private boolean isAccountNonLocked=true;

//    密码是否过期
    private boolean isCredentialsNonExpired=true;

//    账户是否可用
    private boolean isEnabled=true;

//    真实姓名
    private String realName;

//    昵称
    private String nickName;

//    所属部门id
    private Long departmentId;

//    所属部门名称
    private String departmentName;

//    性别 0-男 1-女
    private Integer gender;

    private String phone;

    private String email;

//    头像
    private String avatar;

//    是否是管理员
    private Integer isAdmin;

//    创建时间
    private Date createTime;

    private Date updateTime;

//    是否删除
    private Integer isDelete;

//    权限列表
    @TableField(exist = false)
    Collection<? extends GrantedAuthority> authorities;

//    查询用户权限列表
    @TableField(exist = false)
    private List<Permission> permissionList;
}
