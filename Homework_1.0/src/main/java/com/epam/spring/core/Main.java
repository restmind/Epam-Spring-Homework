package com.epam.spring.core;

import com.epam.spring.core.config.AppConfig1;
import com.epam.spring.core.config.AppConfig2;
import com.epam.spring.core.config.AppConfig3;
import com.epam.spring.core.config.AppConfig4;
import com.epam.spring.core.interfaceBeans.CollectionBean;
import com.epam.spring.core.interfaceBeans.NewBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Print task 3
        ApplicationContext context1 = new AnnotationConfigApplicationContext(AppConfig1.class);
        System.out.println(Arrays.toString(context1.getBeanDefinitionNames()));

        //Print task 4
        ApplicationContext context2 = new AnnotationConfigApplicationContext(AppConfig2.class);
        System.out.println(Arrays.toString(context2.getBeanDefinitionNames()));

        //Print task 6
        ApplicationContext context3 = new AnnotationConfigApplicationContext(AppConfig3.class);
        System.out.println(Arrays.toString(context3.getBeanDefinitionNames()));

        //Print task 7-8
        ApplicationContext context4 = new AnnotationConfigApplicationContext(AppConfig4.class);
        System.out.println(Arrays.toString(context4.getBeanDefinitionNames()) + "\nPrint bean collection with @Order:");
        context4.getBean(CollectionBean.class).printCars();
        System.out.println("\nDependency Injection in new bean with @Qualifier and @Primary: \n" + context4.getBean(NewBean.class).toString());
    }
}
