package com.epam.spring.core.beans.beans2;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class NarcissusFlower {
    private String name;

    public NarcissusFlower(String name) {
        this.name = name;
    }

    public NarcissusFlower() {
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
        NarcissusFlower narcissusFlower = (NarcissusFlower) o;
        return Objects.equals(name, narcissusFlower.name);
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
