package com.epam.spring.core.otherBeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class FieldBasedDIBeanC {
    @Autowired
    @Qualifier("otherBeanC")
    private OtherBeanC otherBeanC;


    public FieldBasedDIBeanC(OtherBeanC otherBeanC) {
        this.otherBeanC = otherBeanC;
    }

    public FieldBasedDIBeanC() {
    }

    public OtherBeanC getOtherBeanC() {
        return otherBeanC;
    }

    public void setOtherBeanC(OtherBeanC otherBeanC) {
        this.otherBeanC = otherBeanC;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FieldBasedDIBeanC that = (FieldBasedDIBeanC) o;
        return Objects.equals(otherBeanC, that.otherBeanC);
    }

    @Override
    public int hashCode() {
        return Objects.hash(otherBeanC);
    }

    @Override
    public String toString() {
        return otherBeanC.toString();
    }
}
