package com.epam.spring.core.otherBeans;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component("otherBeanB")
public class OtherBeanB {
    private String name;

    public OtherBeanB(String name) {
        this.name = name;
    }

    public OtherBeanB() {
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
        OtherBeanB otherBeanB = (OtherBeanB) o;
        return Objects.equals(name, otherBeanB.name);
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
