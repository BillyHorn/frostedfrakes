package com.catalyst.springboot.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
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
		auth.inMemoryAuthentication().withUser("brad").password("root").roles("user");
		
		auth.jdbcAuthentication()
		   .dataSource(datasource)
		   .passwordEncoder(encoder())
		   .usersByUsernameQuery("SELECT email, password,isactive FROM dev WHERE email=? ")
		   .authoritiesByUsernameQuery("SELECT email, role FROM dev WHERE email=?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/**").authenticated()
		    .and().formLogin().loginPage("/loginPage").permitAll()
		    .usernameParameter("username").passwordParameter("password").loginProcessingUrl("/login")
		    .failureHandler(authFailure)
		    .and().logout().logoutSuccessHandler(logoutHandler).logoutSuccessUrl("/login")
		    .and().headers().cacheControl();
		http.csrf().disable();
	}
	
	@Override
	 public void configure(WebSecurity web) throws Exception {
	  web.ignoring().antMatchers("/css/**", "/vendor/**", "/app/**", "/views/login.html", "/register");
	  
	 }
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	CustomAuthenticationFailureHandler authFailure;
	
	@Autowired
	LogoutSuccessHandler logoutHandler;

	@Bean
	CustomAuthenticationFailureHandler authenticationFailureHandler() {
	    return new CustomAuthenticationFailureHandler();
	}
	
	@Bean
	LogoutSuccessHandler newLogoutHandler(){
		return new LogoutSuccessHandler();
	}
	 
	 /**
	  * @param authFailure the authFailure to set
	  */
	public void setAuthFailure(CustomAuthenticationFailureHandler authFailure) {
	 this.authFailure = authFailure;
	}

	/**
	 * @param logoutHandler the logoutHandler to set
	 */
	public void setLogoutHandler(LogoutSuccessHandler logoutHandler) {
		this.logoutHandler = logoutHandler;
	}
	
	
}
