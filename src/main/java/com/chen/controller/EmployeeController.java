package com.chen.controller;

import com.chen.dao.DepartmentDao;
import com.chen.dao.EmployeeDao;
import com.chen.pojo.Department;
import com.chen.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/user/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    @RequestMapping("/user/toAddPage")
    public String toAddEmployeePage(Model model){
        // 查出所有部门的信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "emp/add";
    }

    @RequestMapping("/user/addEmployee")
    public String addEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/user/emps";
    }

    @RequestMapping("/user/toUpdatePage")
    public String toUpdateEmployeePage(Model model, int emid){
        // 查出原来的信息
        Employee employee = employeeDao.getEmployeeById(emid);
        model.addAttribute("emp", employee);
        // 查出所有部门的信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "emp/update";
    }

    @RequestMapping("/user/updateEmployee")
    public String updateEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/user/emps";
    }
}
