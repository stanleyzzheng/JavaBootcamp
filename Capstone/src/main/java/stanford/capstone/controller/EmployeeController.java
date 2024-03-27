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
    @PostMapping
    private ResponseEntity<String> createEmployee(@RequestBody EmployeeDTO employeeDTO){
        employeeService.create(employeeDTO);
        return new ResponseEntity<>("Employee Created successfully: " , HttpStatus.CREATED);
    }
//    update employee controller
    @PutMapping("/{requestedId}")
    private ResponseEntity<Void> updateEmployee(@PathVariable Long requestedId, @RequestBody EmployeeDTO employeeDTO){
        employeeService.updateEmployee(requestedId, employeeDTO);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{requestedId}")
    private ResponseEntity<Void> deleteEmployee(@PathVariable Long requestedId){
        try {
            employeeService.deleteEmployee(requestedId);
            return ResponseEntity.noContent().build(); // Success: 204 No Content
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build(); // Employee not found: 404 Not Found
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Other errors: 500 Internal Server Error
        }
    }


}
