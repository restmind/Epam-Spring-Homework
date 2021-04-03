package com.epam.spring.core.config;

import com.epam.spring.core.beans.beans3.BeanE;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = {"com.epam.spring.core.beans.beans2", "com.epam.spring.core.beans.beans3"},
        excludeFilters =@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = BeanE.class))
public class AppConfig2 {

}
