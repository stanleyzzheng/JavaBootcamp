package stanford.capstone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import stanford.capstone.DTO.DepartmentDTO;
import stanford.capstone.DTO.EmployeeDTO;
import stanford.capstone.model.Department;
import stanford.capstone.model.Employee;
import stanford.capstone.model.Position;
import stanford.capstone.service.DepartmentService;
import stanford.capstone.service.EmployeeService;
import stanford.capstone.service.PositionService;

import java.util.List;

@Controller
@RequestMapping("/manage")
public class ManagementController {
    @Autowired
    DepartmentService departmentService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    PositionService positionService;

    @GetMapping("")
    public String showLoginForm(Model model) {
        return "manage";
    }
//    Show all departments get mapping to manage departments

    @GetMapping("/departments")
    public String showDepartments(Model model) {
        List<Department> departments = departmentService.findAllDepartments();
        model.addAttribute("departments", departments);
        return "manage-departments";
    }

    @GetMapping("/employees")
    public String showEmployees(Model model){
        List<Employee> employees = employeeService.findAllEmployees();
        model.addAttribute("employees", employees);
        return "manage-employees";
    }

    // Get mapping for department details. and employees associated with department.
    @GetMapping("/departments/{departmentId}")
    public String showDepartmentDetails(@PathVariable Long departmentId, Model model) {
        Department department = departmentService.findDepartmentById(departmentId);
        model.addAttribute("department", department);
        List<Employee> employees = employeeService.findAllByDepartment(departmentId);
        model.addAttribute("employees", employees);
        return "department-details";

    }
//    Get mapping to add-department template

    @GetMapping("/departments/add")
    public String showAddDepartmentForm(Model model) {
        model.addAttribute("department", new Department());
        return "add-department";
    }

    //    post mapping to create a new department
    @PostMapping("/departments")
    public String addDepartment(@ModelAttribute DepartmentDTO departmentDTO) {
        departmentService.saveDepartment(departmentDTO);
        return "redirect:/manage/departments"; // Redirect to the department list page after adding the department
    }

    //Get mapping controller to get add-employee template
    @GetMapping("/add-employee")
    public String showAddEmployeeForm(Model model) {
        List<Department> departments = departmentService.findAllDepartments();
        List<Position> positions = positionService.getAllPositions();
        model.addAttribute("departments", departments);
        model.addAttribute("positions", positions);
        EmployeeDTO employeeDTO = new EmployeeDTO();
        model.addAttribute("employee", employeeDTO); // Assuming you're binding form data to an Employee object
        return "add-employee";
    }

    //    Post mapping controller to create a new employee
    @PostMapping("/employee")
    private String createEmployee(@ModelAttribute("employeeDTO") EmployeeDTO employeeDTO) {
        employeeService.create(employeeDTO);
        return "redirect:/manage/departments";
    }

    //Get mapping for form to update employee
    @GetMapping("/updateEmployee/{employeeId}")
    public String showEditEmployeeForm(@PathVariable Long employeeId, Model model) {
        Employee employee = employeeService.findEmployeeById(employeeId);
        EmployeeDTO employeeDTO = getEmployeeDTO(employee);

        List<Department> departments = departmentService.findAllDepartments();
        List<Position> positions = positionService.getAllPositions();
        model.addAttribute("departments", departments);
        model.addAttribute("positions", positions);
//        model.addAttribute("employee", employee);
        model.addAttribute("employeeDTO", employeeDTO);
        return "edit-employee";
    }

    // helper function to convert into employee DTO
    private EmployeeDTO getEmployeeDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setFirstName(employee.getFirstName());
        employeeDTO.setLastName(employee.getLastName());
        employeeDTO.setPassword(employee.getPassword());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setGender(employee.getGender());
        employeeDTO.setSalary(employee.getSalary());
        employeeDTO.setDepartmentId(employee.getDepartment()
                .getId());
        employeeDTO.setPositionId(employee.getPosition()
                .getId());
        employeeDTO.setOnline(employee.isOnline());
        return employeeDTO;
    }

    //Get mapping to form to delete employee
    @GetMapping("/deleteEmployee/{id}")
    public String showDeleteEmployeeForm(@PathVariable Long id, Model model) {
        model.addAttribute("employeeId", id);
        return "delete-employee";
    }

    //PostMapping for deleting an employee from database
    @PostMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/manage";
    }
}
