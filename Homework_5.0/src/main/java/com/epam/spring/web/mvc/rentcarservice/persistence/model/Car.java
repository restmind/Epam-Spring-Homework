package com.epam.spring.web.mvc.rentcarservice.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String brand;
    private String model;
    private String carClass;
    private int price;
    @Column(unique = true)
    private String carNumber;
    private boolean isAvailable = true;
}
