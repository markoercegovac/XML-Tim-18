package com.example.advertmanagerapp.repository;

import com.example.advertmanagerapp.model.ConcreteCar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcreteCarRepository extends JpaRepository<ConcreteCar,Long> {
}
