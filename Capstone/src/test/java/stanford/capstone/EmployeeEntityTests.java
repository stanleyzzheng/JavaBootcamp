package stanford.capstone;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import stanford.capstone.DTO.EmployeeDTO;
import stanford.capstone.model.Employee;
import stanford.capstone.repository.EmployeeRepository;
import stanford.capstone.service.EmployeeService;
import stanford.capstone.service.impl.EmployeeServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeEntityTests {
    //    @Autowired
//    TestRestTemplate restTemplate;
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void shouldLoginWithTestUser() throws Exception {
        mockMvc.perform(SecurityMockMvcRequestBuilders.formLogin()
                        .user("test123@gmail.com")
                        .password("123"))
                .andExpect(authenticated());


    }
    @Test
    void shouldNotAuthenticateWithWrongPassword() throws Exception {
//        mockMvc.perform(formLogin().user("test123@gmail.com").password("456")).andExpect(status().isUnauthorized());
        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                        .param("username", "test123@gmail.com")
                        .param("password", "456")
                        .with(csrf()))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection());
    }
    @Test
    @WithUserDetails("test123@gmail.com")
    void shouldAllowAccessToEmployeeWithManagerUser() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/employees/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    @WithUserDetails("test2@gmail.com")
    void shouldNotAllowAccessToEmployeeRouteWithoutManagerRole() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/employees/1"))
                .andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    @DirtiesContext
    void shouldCreateANewEmployee(){
        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setId(3L);
        employeeDTO.setFirstName("John");
        employeeDTO.setLastName("Doe");
        employeeDTO.setEmail("john.doe@example.com");
        employeeDTO.setGender("male");
        employeeDTO.setSalary(50000.0);
        employeeDTO.setDepartmentId(1L);
        employeeDTO.setPositionId(1L);
        employeeDTO.setOnline(true);
        employeeDTO.setPassword("123");
        employeeService.create(employeeDTO);
        Employee createdEmployee = employeeRepository.findEmployeeByEmail(employeeDTO.getEmail());
        assertThat(createdEmployee).isNotNull();
        assertThat(createdEmployee.getFirstName()).isEqualTo(employeeDTO.getFirstName());
        assertThat(createdEmployee.getLastName()).isEqualTo(employeeDTO.getLastName());
        assertThat(createdEmployee.getEmail()).isEqualTo(employeeDTO.getEmail());
        assertThat(createdEmployee.getGender()).isEqualTo(employeeDTO.getGender());
        assertThat(createdEmployee.getSalary()).isEqualTo(employeeDTO.getSalary());
        assertThat(createdEmployee.getDepartment().getId()).isEqualTo(employeeDTO.getDepartmentId());
        assertThat(createdEmployee.getPosition().getId()).isEqualTo(employeeDTO.getPositionId());
        assertThat(createdEmployee.isOnline()).isEqualTo(employeeDTO.isOnline());
    }

    @Test
    void shouldUpdateAnExistingEmployee(){
        Employee employee1 = employeeRepository.findEmployeeByEmail("test123@gmail.com");
        employee1.setEmail("test1234@gmail.com");
    }

}
