package com.chen.mapper;

import com.chen.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentMapper {
    // 查询所有的部门
    List<Department> getDepartments();
    // 根据id查部门名字
    Department getDepartmentNameById(Integer id);
}
