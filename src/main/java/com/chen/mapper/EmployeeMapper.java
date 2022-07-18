package com.chen.mapper;

import com.chen.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeMapper {
    // 增加员工
    int addEmp(Employee employee);
    // 查询全部员工
    List<Employee> getAllEmps();
    // 通过id查询员工
    Employee getEmpById(int id);
    // 通过id删除员工
    int removeEmpById(int id);
    // 更新员工信息
    int updateEmp(Employee employee);
}
