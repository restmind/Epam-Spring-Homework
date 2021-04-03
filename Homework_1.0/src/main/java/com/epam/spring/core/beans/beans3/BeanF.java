package com.epam.spring.core.beans.beans3;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class BeanF {
    private String name;

    public BeanF(String name) {
        this.name = name;
    }

    public BeanF() {
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
        BeanF beanF = (BeanF) o;
        return Objects.equals(name, beanF.name);
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
