package com.epam.spring.core.beans;

import org.springframework.beans.factory.annotation.Value;

public class BeanF implements GeneralBean {
    @Value("Roman")
    private String name;
    @Value("21")
    private int value;

    public BeanF() {
        System.out.println("=====Inside BeanF Constructor=====\n");
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
        return "BeanF: " +
                "name= " + name +
                ", value= " + value;
    }
}

