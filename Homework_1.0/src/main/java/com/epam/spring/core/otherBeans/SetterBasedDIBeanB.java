package com.epam.spring.core.otherBeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class SetterBasedDIBeanB {
    private OtherBeanB otherBeanB;

    public SetterBasedDIBeanB(OtherBeanB otherBeanB) {
        this.otherBeanB = otherBeanB;
    }

    public SetterBasedDIBeanB() {
    }

    public OtherBeanB getOtherBeanB() {
        return otherBeanB;
    }

    @Autowired
    @Qualifier("otherBeanB")
    public void setOtherBeanB(OtherBeanB otherBeanB) {
        this.otherBeanB = otherBeanB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SetterBasedDIBeanB that = (SetterBasedDIBeanB) o;
        return Objects.equals(otherBeanB, that.otherBeanB);
    }

    @Override
    public int hashCode() {
        return Objects.hash(otherBeanB);
    }

    @Override
    public String toString() {
        return otherBeanB.toString();
    }
}
