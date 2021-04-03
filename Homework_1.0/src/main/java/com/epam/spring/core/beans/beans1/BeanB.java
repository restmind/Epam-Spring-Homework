package com.epam.spring.core.beans.beans1;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class BeanB {
    private String name;

    public BeanB(String name) {
        this.name = name;
    }

    public BeanB() {
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
        BeanB beanB = (BeanB) o;
        return Objects.equals(name, beanB.name);
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
