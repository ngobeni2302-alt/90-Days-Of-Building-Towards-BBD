package com.bbd.day20.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.core.userdetails.*;

import com.bbd.day20.UserRepository;

@Configuration
public class SecurityConfig {

    @Autowired private JwtFilter jwtFilter;
    @Autowired private UserRepository userRepo;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**", "/h2-console/**").permitAll()
                .anyRequest().authenticated()
            )
            .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .headers(headers -> headers.frameOptions(f -> f.disable())); // for H2 console

        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            com.bbd.day20.User user = userRepo.findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            return org.springframework.security.core.userdetails.User.builder()
                    .username(user.getUsername())
                    .password(user.getPassword())
                    .roles(user.getRole())
                    .build();
        };
    }

    @Bean public PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }

    @Bean public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
