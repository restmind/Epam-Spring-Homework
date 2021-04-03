package com.epam.spring.core.interfaceBeans;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("Porsche")
@Order(2)
public class Porsche implements Car {
    @Override
    public String getCar() {
        return "Porsche";
    }
}
