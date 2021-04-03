package com.epam.spring.core.interfaceBeans;

import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Primary
@Order(3)
public class Tesla implements Car {
    @Override
    public String getCar() {
        return "Tesla";
    }
}
