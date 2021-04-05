package com.epam.spring.core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.epam.spring.core.implBeans")
@Import(AppConfig1.class)
public class AppConfig2 {
}
