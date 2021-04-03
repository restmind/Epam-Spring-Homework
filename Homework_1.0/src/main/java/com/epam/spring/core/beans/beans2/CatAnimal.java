package com.epam.spring.core.beans.beans2;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CatAnimal {
    private String name;

    public CatAnimal(String name) {
        this.name = name;
    }

    public CatAnimal() {
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
        CatAnimal catAnimal = (CatAnimal) o;
        return Objects.equals(name, catAnimal.name);
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
