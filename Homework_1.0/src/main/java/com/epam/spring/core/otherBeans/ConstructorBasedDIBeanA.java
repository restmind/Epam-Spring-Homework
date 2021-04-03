package com.epam.spring.core.otherBeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ConstructorBasedDIBeanA {
    private OtherBeanA otherBeanA;

    @Autowired
    public ConstructorBasedDIBeanA(OtherBeanA otherBeanA) {
        this.otherBeanA = otherBeanA;
    }

    public ConstructorBasedDIBeanA() {
    }

    public OtherBeanA getOtherBeanA() {
        return otherBeanA;
    }

    public void setOtherBeanA(OtherBeanA otherBeanA) {
        this.otherBeanA = otherBeanA;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConstructorBasedDIBeanA that = (ConstructorBasedDIBeanA) o;
        return Objects.equals(otherBeanA, that.otherBeanA);
    }

    @Override
    public int hashCode() {
        return Objects.hash(otherBeanA);
    }

    @Override
    public String toString() {
        return otherBeanA.toString();
    }
}
