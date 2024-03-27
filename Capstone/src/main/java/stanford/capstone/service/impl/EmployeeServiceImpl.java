package stanford.capstone.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import stanford.capstone.DTO.EmployeeDTO;
import stanford.capstone.model.Employee;
import stanford.capstone.model.Role;
import stanford.capstone.principal.EmployeePrincipal;
import stanford.capstone.repository.EmployeeRepository;
import stanford.capstone.repository.RoleRepository;
import stanford.capstone.service.DepartmentService;
import stanford.capstone.service.EmployeeService;
import stanford.capstone.service.PositionService;
import stanford.capstone.service.RoleService;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final RoleService roleService;

    private final PasswordEncoder encoder;

    private final DepartmentService departmentService;
    private final PositionService positionService;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, RoleService roleService, PasswordEncoder encoder, DepartmentService departmentService, PositionService positionService) {
        this.employeeRepository = employeeRepository;
        this.roleService = roleService;
        this.encoder = encoder;
        this.departmentService = departmentService;
        this.positionService = positionService;
    }

    @Override
    public Employee findEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Transactional
    public void create(EmployeeDTO employeeDTO) {
//        ModelMapper modelMapper = new ModelMapper();
//        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        Employee employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setGender(employeeDTO.getGender());
        employee.setSalary(employeeDTO.getSalary());
        employee.setOnline(employeeDTO.isOnline());
        employee.setPassword(encoder.encode(employeeDTO.getPassword()));
        employee.setRoles(Arrays.asList(roleService.findRoleByRoleName("ROLE_EMPLOYEE")));
        employee.setDepartment(departmentService.findDepartmentById(employeeDTO.getDepartmentId()));
        employee.setPosition(positionService.findPositionById(employeeDTO.getPositionId()));
        employeeRepository.save(employee);
    }

    @Transactional
    public void updateEmployee(Long employeeId, EmployeeDTO updatedEmployeeDTO){
        Employee existingEmployee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + employeeId));

        // Update the attributes of the existing employee with the new values
        existingEmployee.setFirstName(updatedEmployeeDTO.getFirstName());
        existingEmployee.setLastName(updatedEmployeeDTO.getLastName());
        existingEmployee.setEmail(updatedEmployeeDTO.getEmail());
        existingEmployee.setGender(updatedEmployeeDTO.getGender());
        existingEmployee.setSalary(updatedEmployeeDTO.getSalary());
        existingEmployee.setDepartment(departmentService.findDepartmentById(updatedEmployeeDTO.getDepartmentId()));
        existingEmployee.setPosition(positionService.findPositionById(updatedEmployeeDTO.getPositionId()));
        existingEmployee.setOnline(updatedEmployeeDTO.isOnline());

        // Save the updated employee back to the database
        employeeRepository.save(existingEmployee);
    }
    @Transactional
    public void deleteEmployee(Long employeeId){
        if (employeeRepository.existsById(employeeId)) {
            employeeRepository.deleteById(employeeId);
        } else {
            throw new EntityNotFoundException("Employee not found with ID: " + employeeId);
        }
    }

    public Employee findEmployeeByEmail(String email) {
        return employeeRepository.findEmployeeByEmail(email);
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<Employee> findAllByDepartment(Long departmentId) {
        return employeeRepository.findAllByDepartmentId(departmentId);
    }

//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Employee employee = employeeRepository.findEmployeeByEmail(username);
//        if(employee == null){
//            throw new UsernameNotFoundException("Invalid username or password.");
//        }
//        return new EmployeePrincipal(employee, roleService.getRolesByEmployee(employee.getId()));
//    }

}
