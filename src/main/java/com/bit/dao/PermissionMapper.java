package com.bit.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bit.entity.Permission;

import java.util.List;

public interface PermissionMapper extends BaseMapper<Permission> {
//    根据用户ID查询权限菜单列表
    List<Permission> findPermissionListByUserId(Long userId);
}
