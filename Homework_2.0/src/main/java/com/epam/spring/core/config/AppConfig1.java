package com.epam.spring.core.config;

import com.epam.spring.core.beans.*;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "com.epam.spring.core.beans")
@PropertySource("classpath:application.properties")
public class AppConfig1 {
    @Bean
    public BeanA beanA() {
        return new BeanA();
    }

    @Bean(initMethod = "customInitMethod", destroyMethod = "customDestroyMethod")
    @DependsOn({"beanD"})
    public BeanB beanB() {
        return new BeanB();
    }

    @Bean(initMethod = "customInitMethod", destroyMethod = "customDestroyMethod")
    @DependsOn({"beanD", "beanB"})
    public BeanC beanC() {
        return new BeanC();
    }

    @Bean(initMethod = "customInitMethod", destroyMethod = "customDestroyMethod")
    public BeanD beanD() {
        return new BeanD();
    }

    @Bean
    public BeanE beanE() {
        return new BeanE();
    }

    @Bean
    @Lazy
    public BeanF beanF() {
        return new BeanF();
    }
}
