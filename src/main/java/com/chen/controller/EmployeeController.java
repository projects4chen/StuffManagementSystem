package com.chen.controller;

import com.chen.mapper.DepartmentMapper;
import com.chen.mapper.EmployeeMapper;
import com.chen.pojo.Department;
import com.chen.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeMapper employeeDao;
    @Autowired
    DepartmentMapper departmentDao;

    @RequestMapping("/user/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAllEmps();
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
        employeeDao.addEmp(employee);
        return "redirect:/user/emps";
    }

    @RequestMapping("/user/toUpdatePage")
    public String toUpdateEmployeePage(Model model, @RequestParam("id") int id){
        // 查出原来的信息
        Employee employee = employeeDao.getEmpById(id);
        System.out.println(employee);
        model.addAttribute("emp", employee);
        // 查出所有部门的信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "emp/update";
    }

    @RequestMapping("/user/updateEmployee")
    public String updateEmployee(Employee employee){
        employeeDao.updateEmp(employee);
        return "redirect:/user/emps";
    }

    @RequestMapping("/user/removeEmployee")
    public String removeEmployee(@RequestParam("id") Integer id){
        employeeDao.removeEmpById(id);
        return "redirect:/user/emps";
    }
}
