package augusto108.ces.datarestcorp.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
@PropertySource("classpath:users.properties")
public class ApplicationSecurityConfiguration {
    private final Environment env;

    private @Value("${user.user1.name}") String user1Username;
    private @Value("${user.user2.name}") String user2Username;
    private @Value("${user.user3.name}") String user3Username;
    private @Value("${user.user4.name}") String user4Username;
    private @Value("${user.role1}") String employee;
    private @Value("${user.role2}") String manager;
    private @Value("${user.role3}") String admin;
    private @Value("${user.role4}") String trainee;

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails user1 = User.builder()
                .username(user1Username)
                .password("{noop}" + env.getProperty("users.password"))
                .roles(employee)
                .build();

        UserDetails user2 = User.builder()
                .username(user2Username)
                .password("{noop}" + env.getProperty("users.password"))
                .roles(manager)
                .build();

        UserDetails user3 = User.builder()
                .username(user3Username)
                .password("{noop}" + env.getProperty("users.password"))
                .roles(admin)
                .build();

        UserDetails user4 = User.builder()
                .username(user4Username)
                .password("{noop}" + env.getProperty("users.password"))
                .roles(trainee)
                .build();

        return new InMemoryUserDetailsManager(user1, user2, user3, user4);
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
