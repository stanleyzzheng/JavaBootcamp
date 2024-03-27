package stanford.capstone.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import stanford.capstone.DTO.EmployeeDTO;
import stanford.capstone.model.Employee;

import java.util.List;

public interface EmployeeService {
    //    public UserDetails loadUserByUsername(String userName);
    void create(EmployeeDTO employeeDTO);

    Employee findEmployeeByEmail(String email);

    void updateEmployee(Long id, EmployeeDTO employeeDTO);

    void deleteEmployee(Long id);

    List<Employee> findAllByDepartment(Long departmentId);

    Employee findEmployeeById(Long id);
}
