package com.epam.spring.core.beans;

import org.springframework.beans.factory.annotation.Value;


public class BeanC implements GeneralBean {
    @Value("${beanC.name}")
    private String name;
    @Value("${beanC.value}")
    private int value;

    public BeanC() {
        System.out.println("=====Inside BeanC Constructor=====\n");
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
        return "BeanC: " +
                "name= " + name +
                ", value= " + value;
    }

    private void customInitMethod() {
        System.out.println("=====Inside beanC customInitMethod=====\n");
    }

    private void customDestroyMethod() {
        System.out.println("=====Inside beanC customDestroyMethod=====\n");
    }
}
