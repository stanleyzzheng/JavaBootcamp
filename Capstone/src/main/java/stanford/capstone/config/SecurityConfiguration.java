package stanford.capstone.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import stanford.capstone.service.EmployeeService;
import stanford.capstone.service.impl.EmployeeServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.httpBasic(Customizer.withDefaults()).and()
        http.authorizeHttpRequests(auth -> auth.requestMatchers("/manage", "/employees/**", "/manage/**")
                        .hasRole("MANAGER")

                        .requestMatchers("/js/**", "/css/**", "/html/**")
                        .permitAll()
                        .requestMatchers("/login", "/register", "/roles/**", "/favicon.ico")
                        .permitAll()
                        .requestMatchers("/error/**")
                        .permitAll()
                        .requestMatchers("/")
                        .permitAll())
                .formLogin(form -> form.loginPage("/")
                        .loginProcessingUrl("/login")
                        .failureUrl("/?error=true")
                        .defaultSuccessUrl("/manage")
                        .permitAll())
                .logout(logout -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/") // Redirect to login page after successful logout
                        .invalidateHttpSession(true) // Invalidate HTTP session
                        .deleteCookies("JSESSIONID")
                        .permitAll());

//                .httpBasic(Customizer.withDefaults())
//                .csrf(csrf -> csrf.disable());
        return http.build();
    }
}
