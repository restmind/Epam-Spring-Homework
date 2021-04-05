package com.epam.spring.core;

import com.epam.spring.core.config.AppConfig1;
import com.epam.spring.core.config.AppConfig2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {
        System.out.println("\n\n-------------------------------------Task 9 print all beans" +
                "-------------------------------------\n\n");
        AnnotationConfigApplicationContext context1 = new AnnotationConfigApplicationContext(AppConfig1.class);
        for (String beanName : context1.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
        context1.close();

        System.out.println("\n\n-------------------------------------Task 12 print all beans" +
                "-------------------------------------\n\n\n");
        AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext(AppConfig2.class);
        for (String beanName : context2.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
        context2.close();
    }
}
