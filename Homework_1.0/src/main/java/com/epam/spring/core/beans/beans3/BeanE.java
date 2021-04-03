package com.epam.spring.core.beans.beans3;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class BeanE {
    private String name;

    public BeanE(String name) {
        this.name = name;
    }

    public BeanE() {
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
        BeanE beanE = (BeanE) o;
        return Objects.equals(name, beanE.name);
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
