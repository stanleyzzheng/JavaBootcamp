package stanford.capstone.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import stanford.capstone.service.EmployeeService;
import stanford.capstone.service.impl.EmployeeServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {


//    private final PasswordEncoder passwordEncoder;
//    @Autowired
//    private EmployeeService userDetailsService;


//    @Autowired
//    public SecurityConfiguration(EmployeeService userDetailsService) {
//        this.userDetailsService = userDetailsService;
////        this.passwordEncoder = passwordEncoder;
//    }

//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
//        auth.setUserDetailsService(userDetailsService);
//        auth.setPasswordEncoder(passwordEncoder());
//        return auth;
//    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(11);
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth.requestMatchers("/", "/login", "/sign-up", "/signup-process")
                .permitAll());
        return http.build();
    }
}
