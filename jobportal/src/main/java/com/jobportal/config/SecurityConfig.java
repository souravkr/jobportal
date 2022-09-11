package com.jobportal.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	private DataSource ds;
	
	SecurityConfig(DataSource tempds){
			this.ds = tempds;
	}
	
	
	@Bean
	public UserDetailsManager userDetailsManager() {
		return new JdbcUserDetailsManager(ds);
	}
	
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
	  return http.authorizeRequests(config->config.antMatchers("/home").hasRole("NONPRIME")
			  .antMatchers("/postJob/**").hasRole("PRIME"))
	.formLogin(config->config.loginPage("/showLoginPage").loginProcessingUrl("/authenticateUser").permitAll())
	.logout(config->config.permitAll())
	.exceptionHandling(configure->configure.accessDeniedPage("/access-denied"))
					  .build();
	}
	
	

}
