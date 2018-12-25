package org.smartinrubio.spring5webapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
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
}
