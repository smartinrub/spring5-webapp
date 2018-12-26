package org.smartinrubio.spring5webapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("user")
//                .password("$2a$04$3dqK2YgGGW8zUJnDYvyBwuR7lcTXlKiPoH.IOt94vigDmd22yYQka")
//                .roles("USER")
//                .and()
//                .passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("admin")
//                .password("$2a$04$3dqK2YgGGW8zUJnDYvyBwuR7lcTXlKiPoH.IOt94vigDmd22yYQka")
//                .roles("ADMIN");

        auth.ldapAuthentication()
                .userSearchBase("ou=people")
                .userSearchFilter("(uid={0})")
                .groupSearchBase("ou=groups")
                .groupSearchFilter("member={0}")
                .contextSource()
                .root("dc=smartinrubio,dc=org")
                .ldif("classpath:users.ldif");

    }

//    When configure(HttpSecurity) is overridden the default login page provided by Spring is not used anymore
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .authorizeRequests()
                .antMatchers("/hotels/**").authenticated()
                .antMatchers("/user/details/**").authenticated()
                .anyRequest().permitAll();
    }
}
