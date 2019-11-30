package com.nagarro.employeemanagement.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author vishalchaudhary01
 *
 */
@Configuration
@ComponentScan({ "com.nagarro.employeemanagement" })
public class SpringConfig {

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}

}
