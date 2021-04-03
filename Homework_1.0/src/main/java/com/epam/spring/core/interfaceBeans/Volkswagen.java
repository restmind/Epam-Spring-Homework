package com.epam.spring.core.interfaceBeans;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("Volkswagen")
@Order(4)
public class Volkswagen implements Car {
    @Override
    public String getCar() {
        return "Volkswagen";
    }
}
