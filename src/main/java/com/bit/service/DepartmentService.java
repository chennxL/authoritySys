package com.bit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bit.entity.Department;
import com.bit.vo.query.DepartmentQueryVo;

import java.util.List;

public interface DepartmentService extends IService<Department> {
    //查询部门列表
    List<Department> findDepartmentList(DepartmentQueryVo departmentQueryVo);

    //查询上级部门列表
    List<Department> findParentDepartment();
/*
判断部门下是否有子部门
 */
    boolean hasChildrenOfDepartment(Long id);

    /**
     * 判断部门下是否存在用户
     * @param id
     * @return
     */
    boolean hasUserOfDepartment(Long id);
}
