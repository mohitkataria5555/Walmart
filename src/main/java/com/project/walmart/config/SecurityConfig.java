package com.project.walmart.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails normalUser = User.withUsername("mohit").password(passwordEncoder().encode("password")).roles("Normal").build();
        UserDetails adminUser = User.withUsername("Admin_1").password(passwordEncoder().encode("admin@123")).roles("Admin").build();
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager(normalUser,adminUser);
        return inMemoryUserDetailsManager;

    }

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated()
                ).httpBasic(Customizer.withDefaults());

        return http.build();
    }

}
