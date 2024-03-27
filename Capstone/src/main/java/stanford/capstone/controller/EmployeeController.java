package stanford.capstone.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import stanford.capstone.DTO.EmployeeDTO;
import stanford.capstone.model.Employee;
import stanford.capstone.model.Role;
import stanford.capstone.repository.EmployeeRepository;
import stanford.capstone.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeService employeeService;


    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/{id}")
    private ResponseEntity<Employee> findById(@PathVariable Long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {

            return ResponseEntity.ok(employeeOptional.get());
        } else {
            return ResponseEntity.notFound()
                    .build();
        }
    }
//    Returns Employee detail for single employee by searching for employee_id in database
    @GetMapping("/employeeDetail/{id}")
    private String showEmployeeDetailsById(@PathVariable Long id, Model model){
        Employee employee = employeeService.findEmployeeById(id);
        model.addAttribute("employee", employee);
        return "employee-detail";
    }
    @GetMapping("/department/{departmentId}")
    private ResponseEntity<List<Employee>> findAllEmployeesByDepartment(@PathVariable Long departmentId){
        return ResponseEntity.ok(employeeService.findAllByDepartment(departmentId));
    }
//Create new employee controller

//    update employee controller, redirects to /manage/departments afterwords.
    @PostMapping("/update/{requestedId}")
    private String updateEmployee(@PathVariable Long requestedId, @ModelAttribute("employee") EmployeeDTO employeeDTO){
        employeeService.updateEmployee(requestedId, employeeDTO);
        return "redirect:/manage/departments";
//        return ResponseEntity.noContent().build();
    }




}
