package com.epam.spring.web.mvc.rentcarservice;

import com.epam.spring.web.mvc.rentcarservice.inperceptor.LoggingInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class RentCarServiceApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(RentCarServiceApplication.class, args);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoggingInterceptor());
	}

}
