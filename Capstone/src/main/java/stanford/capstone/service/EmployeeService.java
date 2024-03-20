package stanford.capstone.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import stanford.capstone.DTO.EmployeeDTO;
import stanford.capstone.model.Employee;

public interface EmployeeService {
    public UserDetails loadUserByUsername(String userName);
    public void create(EmployeeDTO employeeDTO);
    public Employee findEmployeeByEmail(String email);
}
