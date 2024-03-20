package stanford.capstone.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import stanford.capstone.model.Employee;
import stanford.capstone.repository.EmployeeRepository;

import java.util.stream.Collectors;

@Service
public class CustomEmployeeDetailsService implements UserDetailsService {
    private EmployeeRepository employeeRepository;

    public CustomEmployeeDetailsService(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

        Employee employee = employeeRepository.findEmployeeByEmail(usernameOrEmail);
        if(employee != null) {
            return new org.springframework.security.core.userdetails.User(employee.getEmail(),
                    employee.getPassword(),
                    employee.getRoles().stream()
                            .map((role) -> new SimpleGrantedAuthority(role.getName()))
                            .collect(Collectors.toList()));
        }else {
            throw new UsernameNotFoundException("Invalid email or password");
        }
    }
}
