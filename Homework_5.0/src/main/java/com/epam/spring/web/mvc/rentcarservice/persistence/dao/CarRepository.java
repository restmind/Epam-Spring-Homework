package com.epam.spring.web.mvc.rentcarservice.persistence.dao;

import com.epam.spring.web.mvc.rentcarservice.persistence.model.Car;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {

    Optional<Car> findByCarNumber(String carNumber);

    List<Car> findAllByBrand(String brand, Pageable pageable);

    List<Car> findAllByCarClass(String carClass, Pageable paging);

    List<Car> findAllByOrderByBrandAscModelAsc();

    @Query("SELECT c FROM Car c WHERE c.isAvailable = true")
    List<Car> findAllByIsAvailable();
}
