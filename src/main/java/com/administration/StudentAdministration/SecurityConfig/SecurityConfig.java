package com.administration.StudentAdministration.SecurityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import javax.sql.DataSource;

//class used for configurating the security details of application
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    //password encoder used to hash passwords
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //datasource
    @Autowired
    private DataSource dataSource;

    //queries used to get usernames, passwords enabled status and roles
    @Value("${spring.queries.students-query}")
    private String studentsQuery;

    @Value("${spring.queries.teachers-query}")
    private String teachersQuery;

    @Value("${spring.queries.admins-query}")
    private String adminsQuery;

    @Value("${spring.queries.studentsRoles-query}")
    private String studentsRolesQuery;

    @Value("${spring.queries.teachersRoles-query}")
    private String teachersRolesQuery;

    @Value("${spring.queries.adminsRoles-query}")
    private String adminsRolesQuery;

    //security configuration, queries are run here to get roles and check if
    //username and passwords match input from user
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.
                jdbcAuthentication()
                .usersByUsernameQuery(teachersQuery)
                .authoritiesByUsernameQuery(teachersRolesQuery)
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder)
                .and()
                .jdbcAuthentication()
                .usersByUsernameQuery(studentsQuery)
                .authoritiesByUsernameQuery(studentsRolesQuery)
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder)
                .and()
                .jdbcAuthentication()
                .usersByUsernameQuery(adminsQuery)
                .authoritiesByUsernameQuery(adminsRolesQuery)
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder);

    }

    //configuration of access based on different roles
    //configuration of login, logout and access denied pages
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.
                authorizeRequests()
                .antMatchers("/admin/consume").permitAll()
                .antMatchers("/admin/test").permitAll()
                .antMatchers("/home/login").permitAll()
                .antMatchers("/push").permitAll()
                .antMatchers("/student/**").hasAuthority("STUDENT")
                .antMatchers("/teacher/**").hasAuthority("TEACHER")
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                .anyRequest()
                .authenticated().and().csrf().disable().formLogin()
                .loginPage("/home/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/home/course", true)
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/home/login").and().exceptionHandling()
                .accessDeniedPage("/home/denied");

    }

    /*@Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }*/
}
