package com.jobportal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("com.jobportal")
@PropertySource("classpath:application.properties")
public class PortalConfig {
	
	@Bean
	public RestTemplate restTemplete() {
		return new RestTemplate();
	}

}
