package com.bit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bit.entity.Permission;

import java.util.List;

public interface PermissionService extends IService<Permission> {
    List<Permission> findPermissionListByUserId(Long userId);
}
