package fr.but3.revision;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer.FrameOptionsConfig;

import javax.sql.DataSource;

import static org.springframework.security.authorization.AuthenticatedAuthorizationManager.rememberMe;

@Configuration
@EnableWebSecurity
public class Security {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcUserDetailsManager userDetailsManager;

    @Bean
    public SecurityFilterChain mesautorisations(HttpSecurity http, HandlerMappingIntrospector introspector)
            throws Exception {
        // MvcRequestMatcher.Builder mvc = new MvcRequestMatcher.Builder(introspector);
        return http
                .authorizeHttpRequests((authorize) -> authorize
                        // .requestMatchers("/home").authenticated()
                        .requestMatchers("/questions/activer").hasAuthority("ADMIN")
                        .requestMatchers("/questions/desactiver").hasAuthority("ADMIN")
                        .requestMatchers("/questions/voir").hasAuthority("ADMIN")
                        .requestMatchers("/questions/voter").hasAuthority("USER")
                        .requestMatchers("/h2-console/**").permitAll()
                        .anyRequest().permitAll()
                )
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/h2-console/**")  // Désactive CSRF uniquement pour H2 Console
                )
                .headers( headers -> headers.frameOptions(FrameOptionsConfig::sameOrigin) )
                .formLogin(Customizer.withDefaults())
                //.formLogin(form -> form
                //     .defaultSuccessUrl("/addEtudiant", true)
                //   .permitAll()
                // )
                // // .logout(configurer -> configurer.logoutSuccessUrl("/"))
                .rememberMe(configurer -> configurer.rememberMeParameter("remember")
                        .useSecureCookie(true))
                .csrf().disable()
                .build();
    }

    @Bean
    public PasswordEncoder encoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
