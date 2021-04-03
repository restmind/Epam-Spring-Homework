package com.epam.spring.core.otherBeans;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class OtherBeanA {
    private String name;

    public OtherBeanA(String name) {
        this.name = name;
    }

    public OtherBeanA() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OtherBeanA otherBeanA = (OtherBeanA) o;
        return Objects.equals(name, otherBeanA.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
