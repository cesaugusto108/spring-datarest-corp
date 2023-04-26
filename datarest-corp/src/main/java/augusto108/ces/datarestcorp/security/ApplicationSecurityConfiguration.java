package augusto108.ces.datarestcorp.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@RequiredArgsConstructor
@PropertySource("classpath:users.properties")
public class ApplicationSecurityConfiguration {
    private final Environment env;

    private @Value("${user.user1.name}") String user1Username;
    private @Value("${user.user2.name}") String user2Username;
    private @Value("${user.user3.name}") String user3Username;
    private @Value("${user.user4.name}") String user4Username;


    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails user1 = User.builder()
                .username(user1Username)
                .password("{noop}" + env.getProperty("users.password"))
                .roles(env.getProperty("user.role1"))
                .build();

        UserDetails user2 = User.builder()
                .username(user2Username)
                .password("{noop}" + env.getProperty("users.password"))
                .roles(env.getProperty("user.role1"), env.getProperty("user.role2"))
                .build();

        UserDetails user3 = User.builder()
                .username(user3Username)
                .password("{noop}" + env.getProperty("users.password"))
                .roles(env.getProperty("user.role1"), env.getProperty("user.role3"))
                .build();

        UserDetails user4 = User.builder()
                .username(user4Username)
                .password("{noop}" + env.getProperty("users.password"))
                .roles(env.getProperty("user.role4"))
                .build();

        return new InMemoryUserDetailsManager(user1, user2, user3, user4);
    }
}
