package com.example.request.repository;

import com.example.request.model.CarReservedDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarReservedDaterepository extends JpaRepository<CarReservedDate, Long> {
}
