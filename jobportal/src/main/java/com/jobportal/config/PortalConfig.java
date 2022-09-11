package com.jobportal.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan("com.jobportal")
@PropertySource("classpath:application.properties")
public class PortalConfig {
	
	@Autowired
	private Environment env;
	
	@Bean
	public RestTemplate restTemplete() {
		return new RestTemplate();
	}
	
	@Bean
	public ViewResolver internalViewresolver() {
		
		InternalResourceViewResolver view = new InternalResourceViewResolver();
		view.setPrefix("/WEB-INF/view/");
		view.setSuffix(".jsp");
		
		return view;
	}
	
	@Bean
	public DataSource dataSource() {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		
		try {
		   ds.setDriverClass(env.getProperty("jdbc.driver"));	
		}catch(PropertyVetoException exc){
			throw new RuntimeException();
			
		}
		
		ds.setJdbcUrl(env.getProperty("jdbc.url"));
		ds.setUser(env.getProperty("jdbc.user"));
		ds.setPassword(env.getProperty("jdbc.password"));
		
		ds.setInitialPoolSize(Integer.parseInt(env.getProperty("connection.pool.initialPoolSize")));
		ds.setMinPoolSize(Integer.parseInt(env.getProperty("connection.pool.minPoolSize")));
		ds.setMaxPoolSize(Integer.parseInt(env.getProperty("connection.pool.maxPoolSize")));
		ds.setMaxIdleTime(Integer.parseInt(env.getProperty("connection.pool.maxIdleTime")));
	
	    return ds;
	}

}
