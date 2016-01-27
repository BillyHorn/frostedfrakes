package com.catalyst.springboot;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by atatro on 1/25/2016.
 */
@EnableWebSecurity
@Configuration
public class SpringSecurityConfigurer extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource datasource;
	
	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
	}
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
}
