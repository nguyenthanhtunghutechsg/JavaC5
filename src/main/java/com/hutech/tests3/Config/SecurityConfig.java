package com.hutech.tests3.Config;

import com.hutech.tests3.Services.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.AbstractConfiguredSecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    private HandleSuccessLogin handleSuccessLogin;
    @Autowired
    private HandleFailureLogin handleFailureLogin;

    @Autowired
    private DataSource dataSource;
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(
                request->request
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/users").hasAuthority("USER")
                        .requestMatchers("/users/**").hasAuthority("MODIFIER, USER")
                        .requestMatchers("/roles").hasAuthority("ADMIN, MODIFIER, USER")
                        .anyRequest().permitAll()
        ).formLogin(AbstractConfiguredSecurityBuilder
                ->AbstractConfiguredSecurityBuilder.loginPage("/login")
                .permitAll().successHandler(handleSuccessLogin).
                        failureHandler(handleFailureLogin)
        ).rememberMe(remember
                        ->remember.tokenRepository(persistentTokenRepository())
                        .tokenValiditySeconds(1000*60*30))
        .logout(logout->logout.
                deleteCookies("JSESSIONID")).build();
    }

    public CustomUserDetailService userDetailsService() {
        return customUserDetailService;
    }
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepo = new JdbcTokenRepositoryImpl();
        tokenRepo.setDataSource(dataSource);
        return tokenRepo;
    }

}
