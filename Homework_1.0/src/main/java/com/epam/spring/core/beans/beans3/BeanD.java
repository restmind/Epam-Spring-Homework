package com.epam.spring.core.beans.beans3;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class BeanD {
    private String name;

    public BeanD(String name) {
        this.name = name;
    }

    public BeanD() {
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
        BeanD beanD = (BeanD) o;
        return Objects.equals(name, beanD.name);
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
