package com.epam.spring.core.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;


public class BeanA implements InitializingBean, DisposableBean, GeneralBean {
    @Value("Yura")
    private String name;
    @Value("11")
    private int value;

    public BeanA() {
        System.out.println("=====Inside BeanA Constructor=====\n");
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
        return "BeanA: " +
                "name= " + name +
                ", value= " + value;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("=====Inside beanA InitializingBean.afterPropertiesSet()=====\n");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("=====Inside beanA DisposableBean.destroy()=====\n");
    }
}
