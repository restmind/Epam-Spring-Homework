package com.epam.spring.core.interfaceBeans;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("audi")
@Order(1)
public class Audi implements Car {
    @Override
    public String getCar() {
        return "Audi";
    }
}
