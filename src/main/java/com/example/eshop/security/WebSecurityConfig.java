package com.example.eshop.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable().
//                formLogin().successForwardUrl("/logadmin")
//                .and()
//                .authorizeRequests()
//                .antMatchers("/login/**").hasAuthority("ROLE_ADMIN")
//                .anyRequest().permitAll();
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN").and()
//                .withUser("user").password("user").roles("USER").and()
//                .withUser("user1").password("user1").roles("USER");
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().
                authorizeRequests()
                .antMatchers("/login/**").hasAuthority("ADMIN")
//                .antMatchers("/register/**").permitAll()
//                .anyRequest().fullyAuthenticated()
                .and()
                .formLogin()
                .loginPage("/login")
//                .failureUrl("/login?error")
                .usernameParameter("j_username")
                .passwordParameter("j_password")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout");
//                .deleteCookies("remember-me")
//                .logoutSuccessUrl("/")
//                .permitAll()
//                .and()
//                .rememberMe();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());

    }

}
