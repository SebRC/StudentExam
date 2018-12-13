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

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private DataSource dataSource;

    @Value("${spring.queries.students-query}")
    private String studentsQuery;

    @Value("${spring.queries.teachers-query}")
    private String teachersQuery;

    @Value("${spring.queries.studentsRoles-query}")
    private String studentsRolesQuery;

    @Value("${spring.queries.teachersRoles-query}")
    private String teachersRolesQuery;

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
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
                .passwordEncoder(bCryptPasswordEncoder);

    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.
                authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/admin/consume").permitAll()
                .antMatchers("/push").permitAll()
                //.antMatchers("/teacher/consumeTeachers").permitAll()
                .antMatchers("/home/login").permitAll()
                .antMatchers("/student/consume").permitAll()
                .antMatchers("/student/**").hasAuthority("STUDENT")
                .antMatchers("/teacher/**").hasAuthority("TEACHER")
                .anyRequest()
                .authenticated().and().csrf().disable().formLogin()
                .loginPage("/home/login")
                .usernameParameter("username")
                .passwordParameter("password")
                //.defaultSuccessUrl("/student/course", true)
                .defaultSuccessUrl("/home/frontpage", true)
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
