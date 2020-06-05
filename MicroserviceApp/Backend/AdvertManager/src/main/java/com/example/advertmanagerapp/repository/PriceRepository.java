package com.example.advertmanagerapp.repository;

import com.example.advertmanagerapp.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price,Long> {
}
