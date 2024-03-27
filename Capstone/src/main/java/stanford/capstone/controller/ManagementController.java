package stanford.capstone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import stanford.capstone.model.Department;
import stanford.capstone.model.Employee;
import stanford.capstone.service.DepartmentService;
import stanford.capstone.service.EmployeeService;

import java.util.List;

@Controller
@RequestMapping("/manage")
public class ManagementController {
    @Autowired
    DepartmentService departmentService;
    @Autowired
    EmployeeService employeeService;
    @GetMapping("")
    public String showLoginForm(Model model){
        return "manage";
    }

    @GetMapping("/departments")
    public String showDepartments(Model model){
        List<Department> departments= departmentService.findAllDepartments();
        model.addAttribute("departments", departments);
        return "manage-departments";
    }
    @GetMapping("/departments/{departmentId}")
    public String showDepartmentDetails(@PathVariable Long departmentId, Model model){
        Department department = departmentService.findDepartmentById(departmentId);
        model.addAttribute("department", department);
        List<Employee> employees = employeeService.findAllByDepartment(departmentId);
        model.addAttribute("employees", employees);
        return "department-details";

    }

}
