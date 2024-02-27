package stanford.jdbcspringsecurity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@SpringBootTest
//@AutoConfigureMockMvc
class JdbcSpringSecurityApplicationTests {

    @Autowired
    TestRestTemplate restTemplate;
//    @Autowired
//    private MockMvc mockMvc;

    @Test
    void shouldLogin() throws Exception {
        ResponseEntity<String> getResponse = restTemplate.withBasicAuth("stan", "123")
                .getForEntity("/", String.class);
        assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
//        mockMvc.perform(get("/")).andExpect(status().isOk());
    }

    @Test
    void shouldNotLoginWithWrongCredentials() {
        ResponseEntity<String> getResponse = restTemplate.withBasicAuth("stan", "456")
                .getForEntity("/", String.class);
        assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
    }

}
