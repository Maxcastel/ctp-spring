package fr.but3.revision;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// // import org.springframework.security.core.userdetails.User;
// // import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class WebSecurityConfig {

    @Autowired
    DataSource dataSource;

    @Bean
    public JdbcUserDetailsManager jdbcUserDetailsManager() {
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager();
        userDetailsManager.setDataSource(dataSource);

        // // UserDetails user1 = User.withUsername("user1")
        // //         .password("$2a$10$bAxUYKBxjkf.PhLMcRWbvO20ecHu2xtKRXfYh0Xxx2BUdS9Fk.0US") // abc
        // //         .roles("ADMIN")
        // //         .build();

        // // userDetailsManager.createUser(user1);

        return userDetailsManager;
    }
}
