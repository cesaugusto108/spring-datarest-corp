package augusto108.ces.datarestcorp.security;

import augusto108.ces.datarestcorp.service.HREmployeeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@PropertySource("classpath:users.properties")
public class ApplicationSecurityConfiguration {
    private @Value("${user.role1}") String employee;
    private @Value("${user.role2}") String manager;
    private @Value("${user.role3}") String admin;
    private @Value("${user.role4}") String trainee;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(HREmployeeService hrEmployeeService) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();

        authenticationProvider.setUserDetailsService(hrEmployeeService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());

        return authenticationProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(registry -> registry
                .requestMatchers(HttpMethod.GET).hasAnyRole(employee, manager, admin, trainee)
                .requestMatchers(HttpMethod.POST).hasAnyRole(manager, admin)
                .requestMatchers(HttpMethod.PUT).hasAnyRole(manager, admin)
                .requestMatchers(HttpMethod.DELETE).hasRole(admin)
        );

        httpSecurity.httpBasic();
        httpSecurity.csrf().disable();

        return httpSecurity.build();
    }
}
