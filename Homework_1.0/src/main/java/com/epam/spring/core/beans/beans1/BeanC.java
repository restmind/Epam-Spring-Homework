package com.epam.spring.core.beans.beans1;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class BeanC {
    private String name;

    public BeanC(String name) {
        this.name = name;
    }

    public BeanC() {
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
        BeanC beanC = (BeanC) o;
        return Objects.equals(name, beanC.name);
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
