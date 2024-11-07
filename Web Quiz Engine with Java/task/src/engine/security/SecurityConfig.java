package engine.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.security.SecureRandom;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12, new SecureRandom());
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // For Postman and H2 console
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(auth -> auth
                        .antMatchers(HttpMethod.POST, "/api/register", "/actuator/shutdown").permitAll()
                        .antMatchers("/h2-console/**").permitAll()
                        .antMatchers("/api/quizzes/**").authenticated()
                        .anyRequest().denyAll()
                )
                .headers(headers -> headers
                        .frameOptions().sameOrigin() // Allow H2 console to be displayed in a frame
                );
        return http.build();
    }
}
