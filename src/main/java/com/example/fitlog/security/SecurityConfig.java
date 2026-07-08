
package com.example.fitlog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.fitlog.service.customuserdetails;
import com.example.fitlog.util.JwtFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    @Autowired
    private customuserdetails userDetailsService;

    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration config) throws Exception {

        return config.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());

        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())

            .sessionManagement(session ->
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

            .authorizeHttpRequests(auth -> auth
                

    // ================= AUTH (PUBLIC) =================
    .requestMatchers("/auth/register", "/auth/login")
    .permitAll()


    // ================= SYSTEM ACCOUNT =================
    .requestMatchers("/account/postData")
        .hasRole("ADMIN")

    .requestMatchers("/account/get")
        .hasRole("ADMIN")

    .requestMatchers("/account/get/**")
        .hasAnyRole("ADMIN", "TRAINER")

    .requestMatchers("/account/put/**")
        .hasAnyRole("ADMIN","TRAINER","USER")

    .requestMatchers("/account/delete/**")
        .hasRole("ADMIN")

    .requestMatchers("/account/patch/**")
        .hasAnyRole("ADMIN", "TRAINER","USER")


    // ================= ROUTINE =================
    .requestMatchers("/routine/postData")
        .hasAnyRole("ADMIN", "TRAINER","USER")

    .requestMatchers("/routine/get")
        .hasAnyRole("ADMIN", "TRAINER")

    .requestMatchers("/routine/get/**")
        .hasAnyRole("ADMIN", "TRAINER", "USER")

    .requestMatchers("/routine/put/**")
        .hasAnyRole("ADMIN", "TRAINER","USER")

    .requestMatchers("/routine/delete/**")
        .hasAnyRole("ADMIN","TRAINER")

    .requestMatchers("/routine/patch/**")
        .hasAnyRole("ADMIN", "TRAINER","USER")


    // ================= WORKOUT =================
    .requestMatchers("/workout/postData")
        .hasAnyRole("ADMIN", "TRAINER","USER")

    .requestMatchers("/workout/get")
        .hasAnyRole("ADMIN", "TRAINER")

    .requestMatchers("/workout/get/**")
        .hasAnyRole("ADMIN", "TRAINER", "USER")

    .requestMatchers("/workout/put/**")
        .hasAnyRole("ADMIN", "TRAINER","USER")

    .requestMatchers("/workout/delete/**")
        .hasAnyRole("ADMIN","TRAINER")

    .requestMatchers("/workout/patch/**")
        .hasAnyRole("ADMIN", "TRAINER","USER")


    // ================= EXERCISE =================
    .requestMatchers("/exercise/postData")
        .hasAnyRole("ADMIN", "TRAINER","USER")

    .requestMatchers("/exercise/get")
        .hasAnyRole("ADMIN", "TRAINER")

    .requestMatchers("/exercise/get/**")
        .hasAnyRole("ADMIN", "TRAINER", "USER")

    .requestMatchers("/exercise/put/**")
        .hasAnyRole("ADMIN", "TRAINER","USER")

    .requestMatchers("/exercise/delete/**")
        .hasAnyRole("ADMIN","TRAINER")

    .requestMatchers("/exercise/patch/**")
        .hasAnyRole("ADMIN", "TRAINER","USER")


    // ================= SESSION =================
    .requestMatchers("/session/postData")
        .hasAnyRole("ADMIN", "TRAINER","USER")

    .requestMatchers("/session/get")
        .hasAnyRole("ADMIN", "TRAINER")

    .requestMatchers("/session/get/**")
        .hasAnyRole("ADMIN", "TRAINER", "USER")

    .requestMatchers("/session/put/**")
        .hasAnyRole("ADMIN", "TRAINER","USER")

    .requestMatchers("/session/delete/**")
        .hasAnyRole("ADMIN","TRAINER","USER")

    .requestMatchers("/session/patch/**")
        .hasAnyRole("ADMIN", "TRAINER","USER")


    // ================= FITNESS =================
    .requestMatchers("/fit/postData")
        .hasAnyRole("ADMIN", "TRAINER", "USER")

    .requestMatchers("/fit/get")
        .hasAnyRole("ADMIN", "TRAINER")

    .requestMatchers("/fit/get/**")
        .hasAnyRole("ADMIN", "TRAINER", "USER")

    .requestMatchers("/fit/put/**")
        .hasAnyRole("ADMIN", "USER","TRAINER")

    .requestMatchers("/fit/delete/**")
        .hasAnyRole("ADMIN","TRAINER","USER")

    .requestMatchers("/fit/patch/**")
        .hasAnyRole("ADMIN", "USER","TRAINER")


    // ================= EVERYTHING ELSE =================
    .anyRequest().authenticated()
)

    

            .httpBasic(httpBasic -> httpBasic.disable())

            .formLogin(form -> form.disable())

            .authenticationProvider(authenticationProvider())

            .addFilterBefore(jwtFilter,
                    UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}


