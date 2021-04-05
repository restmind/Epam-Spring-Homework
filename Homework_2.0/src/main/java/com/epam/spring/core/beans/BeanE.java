package com.epam.spring.core.beans;

import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class BeanE implements GeneralBean {
    @Value("Anna")
    private String name;
    @Value("25")
    private int value;

    public BeanE() {
        System.out.println("=====Inside BeanE Constructor=====\n");
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BeanE: " +
                "name= " + name +
                ", value= " + value;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("=====Inside beanE @PostConstruct=====\n");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("=====Inside beanE @PreDestroy=====\n");
    }
}
