package com.epam.spring.core.beans.beans2;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class RoseFlower {
    private String name;

    public RoseFlower(String name) {
        this.name = name;
    }

    public RoseFlower() {
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
        RoseFlower roseFlower = (RoseFlower) o;
        return Objects.equals(name, roseFlower.name);
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
