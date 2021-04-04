package com.epam.spring.core.interfaceBeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class NewBean {
    private Car audi;
    private Car porsche;
    private Car tesla;
    private Car volkswagen;

    public NewBean() {
    }

    public NewBean(Car audi, Car porsche, Car tesla, Car volkswagen) {
        this.audi = audi;
        this.porsche = porsche;
        this.tesla = tesla;
        this.volkswagen = volkswagen;
    }

    public Car getAudi() {
        return audi;
    }

    @Autowired
    @Qualifier("audi")
    public void setAudi(Car audi) {
        this.audi = audi;
    }

    public Car getPorsche() {
        return porsche;
    }

    @Autowired
    @Qualifier("porsche")
    public void setPorsche(Car porsche) {
        this.porsche = porsche;
    }

    public Car getTesla() {
        return tesla;
    }

    @Autowired
    public void setTesla(Car tesla) {
        this.tesla = tesla;
    }

    public Car getVolkswagen() {
        return volkswagen;
    }

    @Autowired
    @Qualifier("volkswagen")
    public void setVolkswagen(Car volkswagen) {
        this.volkswagen = volkswagen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewBean newBean = (NewBean) o;
        return Objects.equals(audi, newBean.audi) &&
                Objects.equals(porsche, newBean.porsche) &&
                Objects.equals(tesla, newBean.tesla) &&
                Objects.equals(volkswagen, newBean.volkswagen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(audi, porsche, tesla, volkswagen);
    }

    @Override
    public String toString() {
        return "NewBean{" +
                "audi=" + audi.getCar() +
                ", porsche=" + porsche.getCar() +
                ", tesla=" + tesla.getCar() +
                ", volkswagen=" + volkswagen.getCar() +
                '}';
    }
}
