package com.epam.spring.core.beans;

import org.springframework.beans.factory.annotation.Value;


public class BeanD implements GeneralBean {
    @Value("${beanD.name}")
    private String name;
    @Value("${beanD.value}")
    private int value;

    public BeanD() {
        System.out.println("=====Inside BeanD Constructor=====\n");
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
        return "BeanD: " +
                "name= " + name +
                ", value= " + value;
    }

    private void customInitMethod() {
        System.out.println("=====Inside beanD customInitMethod=====\n");
    }

    private void customDestroyMethod() {
        System.out.println("=====Inside beanD customDestroyMethod=====\n");
    }
}
