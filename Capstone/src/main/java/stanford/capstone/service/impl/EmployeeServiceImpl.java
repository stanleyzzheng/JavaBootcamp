package stanford.capstone.service.impl;

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
import stanford.capstone.service.RoleService;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private RoleService roleService;

    private PasswordEncoder encoder;

    private DepartmentService departmentService;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, RoleService roleService, PasswordEncoder encoder, DepartmentService departmentService) {
        this.employeeRepository = employeeRepository;
        this.roleService = roleService;
        this.encoder = encoder;
        this.departmentService = departmentService;
    }

    @Transactional
    public void create(EmployeeDTO employeeDTO) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        employee.setPassword(encoder.encode(employee.getPassword()));
        employee.setRoles(Arrays.asList(roleService.findRoleByRoleName("ROLE_EMPLOYEE")));
        employee.setDepartment(departmentService.findDepartmentById(employeeDTO.getDepartmentId()));
        employeeRepository.save(employee);
    }

    public Employee findEmployeeByEmail(String email) {
        return employeeRepository.findEmployeeByEmail(email);
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findEmployeeByEmail(username);
        if(employee == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new EmployeePrincipal(employee, roleService.getRolesByEmployee(employee.getId()));
    }

}
