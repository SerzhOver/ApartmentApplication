package com.example.springcrud.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.example.springcrud.security.Role.ADMIN;
import static com.example.springcrud.security.Role.REALTOR;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.GET, "/apartment/**").hasAnyRole(REALTOR.name(), ADMIN.name())
                .antMatchers(HttpMethod.DELETE, "/management/apartment/**").hasRole(ADMIN.name())
                .antMatchers(HttpMethod.POST, "/management/apartment/**").hasRole(ADMIN.name())
                .antMatchers(HttpMethod.PUT, "/management/apartment/**").hasRole(ADMIN.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails alexUser = User.builder()
                .username("alex")
                .password(passwordEncoder.encode("pass"))
                .roles(REALTOR.name())
                .build();

        UserDetails serzhUser = User.builder()
                .username("serzh")
                .password(passwordEncoder.encode("admin"))
                .roles(ADMIN.name())
                .build();

        return new InMemoryUserDetailsManager(alexUser, serzhUser);
    }
}
