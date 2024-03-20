package com.bit.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sun.xml.internal.bind.v2.model.core.ID;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@TableName("sys_role")
public class Role implements Serializable {

    private static final long serialVersionUID=1L;

//    角色编号
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

//    角色编码
    private String roleCode;

//    角色名称
    private String roleName;

//    创建人
    private Long createUser;

//    创建时间
    private Date createTime;

//    修改时间
    private Date updateTime;

//    备注
    private String remark;

//    是否删除
    private Integer isDelete;


}
