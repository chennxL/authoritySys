package com.bit.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@TableName("sys_permission")
public class Permission implements Serializable {
    private  static final long serialVersionUID=1L;

//    权限编号
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

//    权限名称
    private String label;

//    父权限ID
    private Long parentID;

//    父权限名称
    private String parentName;

//    授权标识符
    private String code;

//    路由地址
    private String path;

//    路由名称
    private String name;

//    授权路径
    private String url;

//    权限类型 0-目录 1-菜单 2-按钮
    private Integer type;

//    图标
    private String icon;

//    创建时间
    private Date createTime;

//    修改时间
    private Date updateTime;

//    备注
    private String remark;

//    排序
    private Integer orderNum;

//    是否删除
    private Integer isDelete;

//    子菜单列表
    @JsonInclude(JsonInclude.Include.NON_NULL) //属性值为null的不进行序列化操作
    @TableField(exist = false)
    private List<Permission> children = new ArrayList<Permission>();

//    用于在前端判断当前是目录，菜单还是按钮
    @TableField(exist = false)
    private String value;

//    是否展开
    @TableField
    private Boolean open;
}
