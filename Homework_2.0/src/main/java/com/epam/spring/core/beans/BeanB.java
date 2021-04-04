package com.epam.spring.core.beans;

import org.springframework.beans.factory.annotation.Value;


public class BeanB implements GeneralBean {
    @Value("${beanB.name}")
    private String name;
    @Value("${beanB.value}")
    private int value;

    public BeanB() {
        System.out.println("=====Inside BeanB Constructor=====\n");
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
        return "BeanB: " +
                "name= " + name +
                ", value= " + value;
    }

    private void customInitMethod() {
        System.out.println("=====Inside beanB customInitMethod=====\n");
    }

    private void customDestroyMethod() {
        System.out.println("=====Inside beanB customDestroyMethod=====\n");
    }

    private void anotherCustomInitMethod() {
        System.out.println("=====Inside beanB anotherCustomInitMethod=====\n");
    }
}
