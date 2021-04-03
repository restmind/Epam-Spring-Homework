package com.epam.spring.core.otherBeans;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component("otherBeanC")
public class OtherBeanC {
    private String name;

    public OtherBeanC(String name) {
        this.name = name;
    }

    public OtherBeanC() {
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
        OtherBeanC otherBeanC = (OtherBeanC) o;
        return Objects.equals(name, otherBeanC.name);
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
