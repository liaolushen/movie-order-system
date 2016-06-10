package com.jjfly.config;

import com.jjfly.service.AuthenticationService;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

/**
 * Created by luwin on 16-3-27.
 */

@Configuration
@EnableWebSecurity
@ComponentScan("com.jjfly")
@PropertySource("classpath:application.properties")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    Environment env;

    @Autowired
    AuthenticationService authenticationService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable();
        http
                .authorizeRequests()
                    .antMatchers("/api/register","/api/cinema/*","/api/index/*", "/api/showtime/*").permitAll()
                    //.antMatchers("/api/movie-info/*").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        ShaPasswordEncoder encoder = new ShaPasswordEncoder();
        auth.userDetailsService(authenticationService).passwordEncoder(encoder);
    }

    @Bean
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        return dataSource;
    }
}