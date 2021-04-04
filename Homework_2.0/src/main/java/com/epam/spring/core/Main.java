package com.epam.spring.core;

import com.epam.spring.core.config.AppConfig1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig1.class);

        //Task 9 print all beans
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
        context.close();
    }
}
